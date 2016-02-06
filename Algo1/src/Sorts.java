import java.util.Random;


public class Sorts {
	
	public int[] bubbleSort(int[] a)
	{
		boolean swapped;
		for(int i=0;i<a.length;i++)
		{
			swapped= false;
			for(int j=1;j<a.length;j++)
			{
				if(a[j-1]>a[j])
					{
					swap(a,j-1,j);
					swapped = true;
					}
				
			}			
		}
		return a;
	}
	
	private void swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;		
	}

	public static void main(String[] args)
	{
		Random r = new Random();
		int[] arr = new int[10];
		for(int i=0;i<10;i++)
			arr[i] = r.nextInt(100);
		for(int x:arr)
			System.out.print(x+" ");
		System.out.println("Sorted ");
		//assert isSorted(arr);
		Sorts sort = new Sorts();
		arr = sort.bubbleSort(arr);
		for(int x:arr)
			System.out.print(x+" ");
		assert isSorted(arr);

	}

	private static boolean isSorted(int[] a) {

		for(int i = 1;i<a.length;i++)
		if(a[i-1]>a[i])
				return false;
		return true;
	}

}
