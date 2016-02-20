package week4;

public class HeapSort {
	
	public void sort(int[] a)
	{
		buildHeap(a);
		
		int N=a.length;
		while(N>0)
		{
			exchange(a,0,--N);
			sink(a,0,N);
		}
			
		printArray(a);
	}
	
	public void buildHeap(int[] a)
	{
		for(int i=a.length/2;i>=0;i--)
			sink(a,i,a.length);
	}
	
	public void sink(int[] a, int k,int N)
	{
		while(2*k+2<N)
		{
			int largest=k;
			if(a[2*k+1]>a[k])
				largest=2*k+1;
			if(a[largest]<a[2*k+2])
				largest = 2*k+2;
			
			if(largest!=k)
				{
					exchange(a,k,largest);
					k=largest;
				}
			else break;
		}
	}
	
	public void exchange(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public void printArray(int[] a)
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void main(String[] args) {
		HeapSort h = new HeapSort();
		int[] a = {2,4,6,3,6,8,2,9,1,7,23,45,76,21,32,98,1,9};
		h.sort(a);

	}

}
