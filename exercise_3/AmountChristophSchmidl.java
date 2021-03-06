/*
- Name: Christoph Schmidl
- Studentnumber: 4226887
*/


/* ESC/Java2 exercise

   Objects of this class represent euro amounts. For example, an Amount 
   object with
     euros == 1
     cents == 55
   represents 1.55 euro. 

   Specify the class with JML and check it ESC/Java2.  

   NB there may be errors in the code that you have to fix to stop 
   ESC/Java2 from complaining, as these complaints of ESC/Java2 
   point to real bugs in the code. But keep changes to the code to
   a minimum of what is strictly needed. 
   Mark any changes you have made in the code with a comment,
   eg to indicate that you replaced <= by <.

   You should add enough annotations to stop ESC/Java2 complaining,
   but you should ALSO specify invariants discussed below:

   1) We do not want to represent 1.55 euro as an object with
         euro  == 0
         cents == 155
      (Note that the "equals" method will not be correct if we allow 
       this.)
      Specify an invariant that rules this out.

   2) We do not want to represent 1.55 euro as an object with
         euros =  2
         cents =  -45
      Specify one (or more) invariant(s) that rule this out. But note that
      we DO want to allow negative amounts, otherwise the method negate 
      can't be allowed.
      It may be useful to use the JML notation ==> (for implication) in 
      your invariants.

   The only JML keywords needed for this are
      requires
      invariant
      ensures

   If you want, you can also use
      non_null

   While developing your specs, it may be useful to use the keywords
      assert
   to add additional assertions in source code, to find out what 
   ESC/Java2 can - or cannot - prove at a given program point.

*/

public class Amount{

 private int cents;
 // CHANGED: Added invariants
 /*@ invariant -100 < cents && cents < 100; @*/

 private int euros;
 // CHANGED: Added invariants
 /*@ invariant 0 < euros ==> cents >= 0; @*/
 /*@ invariant 0 > euros ==> cents <= 0; @*/
 

 // CHANGED: Added requires
 /*@ requires -100 < cents && cents < 100; @*/
 /*@ requires 0 < euros ==> cents >= 0; @*/
 /*@ requires 0 > euros ==> cents <= 0; @*/
 public Amount(int euros, int cents){
   this.euros = euros;
   this.cents = cents;
 }

 // CHANGED: Added postcondition
 public /*@ non_null @*/ Amount negate(){
   return new Amount(-euros,-cents);  // CHANGED: the paramters of the constructor were in the wrong order
 }

 // CHANGED: Added precondition
 public Amount subtract(/*@ non_null @*/ Amount a){
   return this.add(a.negate());
 }

 // CHANGED: Added precondition
 public Amount add(/*@ non_null @*/ Amount a){               
   int new_euros = euros + a.euros;
   int new_cents = cents + a.cents; 
   if (new_cents <= -100) { // CHANGED: replaced < with <=  
      new_cents = new_cents + 100;
      new_euros = new_euros - 1;
   } 
   if (new_cents >= 100) {  // CHANGED: replaced > with >=  
      new_cents = new_cents - 100;
      new_euros = new_euros - 1;
   } 
   if (new_cents < 0 && new_euros > 0) { 
       new_cents = new_cents + 100; 
       new_euros = new_euros - 1;
   } 
   if (new_cents > 0 && new_euros < 0) { // CHANGED: replaced >= with > and <= with <  
       new_cents = new_cents - 100; 
       new_euros = new_euros + 1;
   }
   return new Amount(new_euros,new_cents);
 }

 public boolean equal(Amount a) {
   if (a==null) return false;
   else return (euros == a.euros && cents == a.cents);
 }

}
