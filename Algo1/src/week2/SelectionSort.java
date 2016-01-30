package week2;

public class SelectionSort {
	
	public void Sort(int[] array)
	{
		int min;
		for(int i=0;i<array.length;i++)
		{
			min = i;
			for(int j=i+1;j<array.length;j++)
			{
				if(array[min]>array[j])
					min=j;
			}
			if(min!=i)
			{
				int temp= array[min];
				array[min]= array[i];
				array[i] = temp;
			}
		}
		
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}

	public static void main(String[] args) {
		SelectionSort s = new SelectionSort();
		int[] arr = { 7,2,9,3,8,10,17,12,17};
		s.Sort(arr);

	}

}
