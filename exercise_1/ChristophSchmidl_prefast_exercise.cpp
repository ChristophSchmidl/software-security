// Christoph Schmidl s4226887

#include "stdafx.h"
#include "stdio.h"
#undef __analysis_assume
#include <CodeAnalysis\SourceAnnotations.h>

#define BUF_SIZE 100
#define STR_SIZE 200

void zeroing();

// Fixed: Added _Ret_cap_
_Ret_cap_(size) char *my_alloc(size_t size) {
	char *ch  = (char *)malloc(size);

	if(ch == NULL) { //FIXED C6011, check that ch is not null
		exit(0);
	}

	*ch = NULL;
	// FIXED: the last char is size-1 not size.
	ch[size - 1] = NULL;  // null terminate here too, to be safe //FIXED C6386
	return ch;
}

HRESULT input([SA_Post(Tainted=SA_Yes)] _Out_cap_(len) char *buf, size_t len) { //FIXED: Added _Out_cap_(len) and introduced len parameter
	return (fgets(buf, len, stdin) != NULL)?SEVERITY_SUCCESS:SEVERITY_ERROR; //FIXED C4996, use fgets and change parameters accordingly
	// see: http://beej.us/guide/bgc/output/html/multipage/gets.html
}

// Fixed: Added _Ret_cap_c
[returnvalue:SA_Post(Tainted=SA_Yes)] _Ret_cap_c_(STR_SIZE) char *do_read() {
	char *buf = my_alloc(STR_SIZE);
	printf("Allocated a string at %p", buf); //FIXED C6273, replaced %x for %p
	if (buf && FAILED(input(buf, STR_SIZE))) { //FIXED C6217, see https://msdn.microsoft.com/en-us/library/z5aa1ca1.aspx
		printf("error!");
		exit(-1);
	}
	if (*buf == NULL) //FIXED C6282
		printf("empty string");
	return buf;
}

// FIXED: adding buffer annotations
void copy_data([SA_Pre(Tainted=SA_No)] _In_count_c_(STR_SIZE) char *buf1,
               [SA_Post(Tainted=SA_No)] _Out_cap_c_(STR_SIZE) char *buf2) {

	// void* memcpy( void* dest, const void* src, std::size_t count );
	memcpy(buf2,buf1,STR_SIZE); 
	buf2[STR_SIZE-1] = NULL; // null terminate, just in case
}

int execute([SA_Pre(Tainted=SA_No)] char *buf) {
	return system(buf); // pass buf as command to be executed by the OS
}

void validate([SA_Pre(Tainted=SA_Yes)][SA_Post(Tainted=SA_No)] char *buf) {

    // This is a magical validation method, which turns tainted data
    // into untainted data, for which the code not shown.
    //
    // A real implementation might for example use a whitelist to filter
    // the string.

}

_Check_return_ int test_ready() {
	// code not shown
	return 1;
}

int APIENTRY WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow) {

	char *buf1 = do_read();
	// FIXED: do_read allocates STR_SIZE, so buf2 must also be STR_SIZE
	char *buf2 = my_alloc(STR_SIZE);

	if (buf2 == NULL)
		exit(-1);
	zeroing();

	if(!test_ready()) { //FIXED C6031, see: https://msdn.microsoft.com/en-us/library/81s4zzd4.aspx
		//exit(0);
	}

	validate(buf1); //Fixed: validate buf1 before execution
	execute(buf1);
        
    char* buf3 = do_read();
    validate(buf3); //Fixed: validate buf3 before execution
	copy_data(buf3, buf2); 
	execute(buf2);

    char *buf4 = do_read();
    validate(buf4); //Fixed: validate buf4 before execution
    execute(buf4);

}

// *****************************************************************

//FIXED: Added buffer annoation
void zero(_Out_cap_(len) int *buf, int len)
{
    int i;
    // FIXED: use < instead of <= to prevent buffer overflow
    for(i = 0; i < len; i++)
        buf[i] = 0;
}

//FIXED: Added buffer annoation
void zeroboth(_Out_cap_(len) int *buf, int len, 
              _Out_cap_(len3) int *buf3, int len3)
{
    int *buf2 = buf;
    int len2 = len;
    zero(buf2, len2);
    zero(buf3, len3);
}

//FIXED: Added buffer annoation
void zeroboth2(_Out_cap_(len) int *buf, int len, 
	        _Out_cap_(len3) int *buf3, int len3)
{
	zeroboth(buf, len3, buf3, len);
}

void zeroing()
{
    int elements[200];
    int oelements[100];
    zeroboth2(elements, 200, oelements, 100);
}
