package week2;

public class StackUsingArray {
	int top=-1;
	int[] stackArray;
	int size =2; // I will start with array of size 2
	
	public boolean isEmpty()
	{
		if(this.top==-1)
			return true;
		else return false;
	}
	
	public StackUsingArray()
	{
		this.stackArray = new int[size];
	}
	
	public void resizeArray(int newSize)
	{
		int[] tempArray = new int[newSize];
		for(int i=0;i<this.top;i++)
			tempArray[i] = this.stackArray[i];
		this.size = newSize;
		this.stackArray = tempArray;
	}
	
	public void push(int a)
	{
		this.top = this.top+1;
		if(this.top==size)
			resizeArray(size*2);
		stackArray[top] =a;
	}
	public int pop()
	{
		int temp = this.stackArray[top];
		if(top<=this.size/4 && this.size>2)
			resizeArray(size/4);
		
		top = top-1;
		return temp;
	}

	public static void main(String[] args) 
	{
		StackUsingArray sua = new StackUsingArray();
		sua.push(10);
		sua.push(20);
		System.out.println(sua.pop());
		sua.push(30);
		sua.push(40);
		sua.push(50);
		System.out.println(sua.pop());
		System.out.println(sua.pop());
		System.out.println(sua.pop());
		System.out.println(sua.pop());
		
		sua.push(250);
		sua.push(350);
		sua.push(450);
		sua.push(550);
		sua.push(650);
		sua.push(750);
		sua.push(850);
		sua.push(950);
		sua.push(1050);
		
		

	}

}
