// Name: Hoang Viet Hung   Student ID: SE183800 
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////

import java.util.EmptyStackException;

class StackX
   {
   private int maxSize;        // size of stack array
   private long[] stackArray;
   private int top;            // top of stack
//--------------------------------------------------------------
   public StackX(int s)         // constructor
      {
      maxSize = s;             // set array size
      stackArray = new long[maxSize];  // create array
      top = -1;                // no items yet
      }
//---------------------------------------------------------------
   /**
    * extend size of the array by 50%
    * @return
    */
   protected boolean grow(){
      int max1 = maxSize + (maxSize/2); //new max size
      long[] a1 = new long[max1]; //new array
      for(int i=0; i<= top; i++) 
         a1[i] = stackArray[i]; //copy value of the old array to new array
         stackArray = a1; //assign old array to the new array
      return true;
    }

//--------------------------------------------------------------
   public void push(long j)    // put item on top of stack
      {
         if(isFull()) this.grow();
         stackArray[++top] = j;     // increment top, insert item
      }
//--------------------------------------------------------------
   public long pop()  throws EmptyStackException         // take item from top of stack
      {
         if(isEmpty()) throw new EmptyStackException();  //if empty then throw Exception
         else return stackArray[top--];  // access item, decrement top
      }
//--------------------------------------------------------------
   public long peek() throws EmptyStackException        // peek at top of stack
      {
      if(isEmpty()) throw new EmptyStackException(); //check if the stack is empty then throw Exception
      else return stackArray[top];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      {
      return (top == -1);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if stack is full
      {
      return (top == maxSize-1);
      }
//--------------------------------------------------------------
   public void display(){
      System.out.print("The stack: ");
      for (int i = top; i >= 0; i--) { //print out the stack from the top element.
         System.out.print(stackArray[i]+" ");
      }
      System.out.println("\nTop element: "+stackArray[top]);
   }
   }  // end class StackX
////////////////////////////////////////////////////////////////
class StackApp
   {
   public static void main(String[] args)
      {
      StackX theStack = new StackX(10);  // make new stack
      System.out.println("Pushed 20.");
      theStack.push(20);               // push items onto stack
      System.out.println("Pushed 40.");
      theStack.push(40);
      System.out.println("Pushed 60.");
      theStack.push(60);
      System.out.println("Pushed 80.");
      theStack.push(80);

      theStack.display();
      
     
      System.out.println("Popped "+theStack.pop()+".");
      System.out.println("Peek: "+theStack.peek()+".");

      System.out.println("Pushed 100.");
      theStack.push(100);
      theStack.display();

      }  // end main()
   }  // end class StackApp
////////////////////////////////////////////////////////////////
