/*
 * Name: Hoang Viet Hung
 * Student ID:SE183800
 * Implement priority queue
 * to run this proram: java priorityQApp
 */
class priorityQueue{
	int maxSize;
	int[] queueArray;
	int top;
	public priorityQueue() { //default constructor
		this(10);
	}
	public priorityQueue(int maxSize){ //constructor with fields
		this.maxSize = maxSize;
		queueArray = new int[maxSize];
		top = -1;
	}

	/**
	 * check if queue is empty
	 * @return
	 */
	public boolean isEmpty(){
		return (top==-1);
	}

	public boolean isFull(){
		return (top == maxSize -1);
	}

	public void grow(){
		int newSize = maxSize + maxSize/2; //increase maxSize by 50%
		int a1[] = new int[newSize]; //initialize new array
		for (int i = 0; i < queueArray.length; i++) {
			a1[i] = queueArray[i]; //copy value to new array
		}
		queueArray = a1; //assign new array
		maxSize = newSize; //assign new size
	}


	public void enqueue(int element){
		if(isFull()) this.grow();	//if the queue is full, grow the queue
		if(top==-1) queueArray[++top]=element;		//empty queue case
		else{
			int i = top;
			while(i>=0 && element>queueArray[i]){
				queueArray[i+1] =queueArray[i];
				i--;
			}
			queueArray[i+1] = element; top++;
		}
	}
	

	public int dequeue(){
		return queueArray[--top];
	}
	
	public int peek(){
		if(isEmpty()) return -1;	
		return queueArray[top];
	}

	public void clear(){
		this.top = -1;
	}

	public void display(){		
		System.out.print("The queue: ");
		if(isEmpty()) System.out.println("empty");
		else {
			for(int i = top; i >= 0; i--){
				System.out.print(queueArray[i]+" ");
			}
			System.out.println("\nTop element: "+peek()+" at "+top+" index.");
		}
	}
}
class priorityQApp{
	public static void main(String[] args) {
		priorityQueue queue = new priorityQueue();
		System.out.println("Enqueue 3");
		queue.enqueue(3);
		System.out.println("Enqueue 7");
		queue.enqueue(7);
		System.out.println("Enqueue 4");
		queue.enqueue(4);
		System.out.println("Enqueue 8");
		queue.enqueue(8);
		queue.display();

		System.out.println("Dequeue 3 element");
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.display();

		System.out.println("Enqueue 1");
		queue.enqueue(1);
		System.out.println("Enqueue 9");
		queue.enqueue(9);
		queue.display();

		System.out.println("Clear the queue");
		queue.clear();
		queue.display();
	}
}