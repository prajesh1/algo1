package week2;

public class QueueUsingArray {
	int[] queueArray;
	int front;
	int rear;
	int size = 2; //start with size 2

	public QueueUsingArray() {
		this.queueArray = new int[size];
	}
	public boolean isEmpty()
	{
		if(front == rear)
			return true;
		else return false;
	}
	
	public void enqueue(int a)
	{
		
		queueArray[rear] = a;
		rear  = (rear+1)%size; // redirect item coming at location size to 0
		if(rear == front)
			resizeArray(size*2);
	}
	
	public void resizeArray(int newSize)
	{
		int[] newArray = new int[newSize];
		int numElements = (rear-front)%size;
		int i = front,j=0;
		while(numElements!=0)
		{
			newArray[i] = queueArray[j];
			i = (i+1)%size;
			j = j+1;
			numElements = numElements -1;
			
		}
			
		front = 0;
		rear = rear-front; // old rear minus front
		size = newSize;
		queueArray = newArray;
	}
	public int dequeue()
	{
		int temp = queueArray[front];
		if(front ==0) 
			front = size-1;
		else
			front = front -1;
		
		if((rear-front)%size<size/4)
			resizeArray(size/2);
		return temp;
	}
	public void showArray()
	{
		for(int i = 0;i<size;i++)
			System.out.println(queueArray[i]);
	}

	public static void main(String[] args) {
		QueueUsingArray q = new QueueUsingArray();
		q.enqueue(10);
		q.enqueue(20);
		
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		//System.out.println(q.dequeue());
		q.showArray();

	}

}
