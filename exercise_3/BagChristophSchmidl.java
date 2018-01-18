/*
- Name: Christoph Schmidl
- Studentnumber: 4226887
*/

/* ESC/Java2 Exercise: 
   
   This class implements a Bag of integers, using an array.

   Add JML specs to this class, to stop ESC/Java2 from complaining.

   NB there may be errors in the code that you have to fix to stop 
   ESC/Java2 from complaining, as these complaints of ESC/Java2 
   point to real bugs in the code. But keep changes to the code to
   a minimum of what is strictly needed. 
   Mark any changes you have made in the code with a comment,
   eg to indicate that you replaced <= by <.


   The only JML keywords needed for this are
      requires
      invariant 
      ensures 
  
   If you want, you can also use
      non_null
   as abbreviation.


   While developing your specs, it may be useful to use the keywords
      assert
   to add additional assertions in source code, to find out what 
   ESC/Java2 can - or cannot - prove at a given program point.
  
*/

class Bag {

  int[] contents;
  // CHANGED: added invariant
  //@ invariant contents != null;
  int n;
  // CHANGED: added invariant
  //@ invariant n <= contents.length && 0 <= n;



  Bag(/*@ non_null @*/ int[] input) { // CHANGED: added invariant
    n = input.length;
    contents = new int[n];
    arraycopy(input, 0, contents, 0, n);
  }

  Bag() {
    n =0;
    contents = new int[0];
  }

  
  void removeOnce(int elt) {
    for (int i = 0; i < n; i++) {  // CHANGED: replaced i <= n with i < n
      if (contents[i] == elt ) {
         n--;
         contents[i] = contents[n];
         return;
      }
    }
  }

  void removeAll(int elt) {
    for (int i = 0; i < n; i++) {   // CHANGED: replaced i <= n with i < n
      if (contents[i] == elt ) {
         n--;
         contents[i] = contents[n];
      }
    }
  }

  int getCount(int elt) {
    int count = 0;
    for (int i = 0; i < n; i++) // CHANGED: replaced i <= n with i < n
      if (contents[i] == elt) count++; 
    return count;
  }

  /* Warning: you may have a hard time checking the method "add" below.
     ESC/Java2 may warn about a very subtle bug that can be hard to spot. 
     If you cannot find the problem after staring at the code for an hour, 
     feel free to stop.
   */

  void add(int elt) {
    if (n == contents.length) {
       int[] new_contents = new int[2*n+1]; // CHANGED: replaced 2*n with 2*n+1
       arraycopy(contents, 0, new_contents, 0, n);
       contents = new_contents;
    }
    contents[n]=elt;
    n++;
  }

  // CHANGED: added precondition
  //@ requires b != null && b.contents != null;
  void add(Bag b) {
    int[] new_contents = new int[n + b.n];
    arraycopy(contents, 0, new_contents, 0, n);
    arraycopy(b.contents, 0, new_contents, n, b.n); // CHANGED: replaced n+1 with n -> destOff changed
    contents = new_contents; 
  }

  // CHANGED: added precondition
  //@requires a != null;
  void add(int[] a) {
    this.add(new Bag(a));
  }

  // The example below is a bit nasty.
  // NB this is a constructor, not a method.
   
   // CHANGED: added precondition
   //@ requires b != null;
   Bag(Bag b) {
     this(); // CHANGED: Call to default constructor
     this.add(b);    
   }

  // CHANGED: added preconditions
  //@ requires src != null;
  //@ requires dest != null;
  //@ requires 0 <= srcOff;
  //@ requires 0 <= destOff; 
  //@ requires srcOff + length <= src.length; 
  //@ requires destOff + length <= dest.length; 
  private static void arraycopy(int[] src,
                                int   srcOff,
                                int[] dest,
                                int   destOff,
                                int   length) {
    for( int i=0 ; i<length; i++) {
       dest[destOff+i] = src[srcOff+i];
    }
  }
  
}
