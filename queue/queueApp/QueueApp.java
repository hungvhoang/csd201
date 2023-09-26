// Name: Hoang Viet Hung   Student ID: SE183800 
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////

class Queue
   {
   private int maxSize;
   private Object[] queArray;
   private int front;
   private int rear;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new Object[maxSize];
      front = rear =-1;
      }
//--------------------------------------------------------------
   public void enqueue(Object j) {  // put item at rear of queue
      if(isFull()) grow();   //grow() if the queue is full
      if(rear == maxSize - 1 || rear == -1){ //wrapped-around case and empty queue case
         queArray[0] = j; 
         rear = 0;
         if(front == -1) front = 0;
      }
      else queArray[++rear] = j;
   }
//--------------------------------------------------------------
   public Object dequeue() throws Exception{      // take item from front of queue
      if(isEmpty()) throw new Exception(); //if empty throw Exception
      else{
         if(front == rear){      //if the queue has only one element
            Object temp = queArray[front];
            front = rear = -1; 
            return temp;
         } 
         else{
            Object temp = queArray[front++]; // get value and incr front
            if(front == maxSize)           // deal with wraparound
               front = 0;
            return temp;
         }
      }
      }
//--------------------------------------------------------------
   public Object front() throws Exception     // peek at front of queue
      {
         if(isEmpty()) throw new Exception();
         return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (front==-1);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
         return ((front==0 && rear == maxSize-1)||(front == rear+1));
                     //-normal case                  //wrapped-around
      }
//--------------------------------------------------------------
   /**
    * increase size of queue by 1.5.
    * @return
    */
   public boolean grow(){
      int newMax = maxSize + maxSize/2; // new max size of the queue
      Object[] a1 = new Object[maxSize]; // new queue array
      //----normal case------------------
      if(rear >= front)
         for(int i=front;i<=rear;i++) //run from front to rear and copy the array
            a1[i-front] = queArray[i]; //copy value to the new array
      //---wrapped-around case-----------------------------
      else{
         for(int i=front;i<maxSize;i++) {
            a1[i-front]=queArray[i];
         }
         int i = maxSize - front; //next index after insert element from front->maxSize
         for (int j = 0; j <= rear; j++) {
            a1[i+j] = queArray[j];  
         }
      }
      queArray = a1; //assign the queue array to the new array
      front = 0;  //set front to the first element
      rear = maxSize-1; //set rear to the last element
      maxSize = newMax; // set new size
      return true;
   }
//--------------------------------------------------------------
   public void display(){
	System.out.println("The array:");
      	for(int i = 0; i< maxSize;i++){
	if(queArray[i] != null)    System.out.print(queArray[i]+" ");
      	}
      	System.out.print("\nThe queue:");
	int start = front;
	while(true){
		if(front == rear){ 	//if only one element in the queue
			System.out.println(queArray[front]);
			break;
		}
		System.out.print(queArray[start]+" "); 	// print from the front
		if(start == maxSize-1) start = 0; 	//wrapped-around case
		else start++;
		if(start == rear){ //end when meet rear.
			System.out.println(queArray[rear]);
			break;
		}
	}
	System.out.println("Front element: "+queArray[front]);
      	System.out.println("Rear element: "+queArray[rear]);
   }
//--------------------------------------------------------------
   }  // end class Queue
////////////////////////////////////////////////////////////////
class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      System.out.println("enqueue 10");
      theQueue.enqueue(10);            // insert 4 items
      System.out.println("enqueue 20");
      theQueue.enqueue(20);
      System.out.println("enqueue 30");
      theQueue.enqueue(30);
      System.out.println("enqueue 40");
      theQueue.enqueue(40);
      theQueue.display();

      System.out.println("dequeue 3 elements");
      try{
      theQueue.dequeue();              // remove 3 items
      theQueue.dequeue();              //    (10, 20, 30)
      theQueue.dequeue();
      }catch(Exception e){
         System.out.println("Empty list");
      }
      theQueue.display();

      //enqueue 4 elements (wrapped-around case)
      System.out.println("enqueue 50");
      theQueue.enqueue(50);            
      System.out.println("enqueue 60");
      theQueue.enqueue(60);            
      System.out.println("enqueue 70");
      theQueue.enqueue(70);
      System.out.println("enqueue 80");
      theQueue.enqueue(80);
      theQueue.display();
     
      }  // end main()
   }  // end class QueueApp
////////////////////////////////////////////////////////////////
