package week2;

public class InsertionSort {
	
	public void sort(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(arr[j]<arr[j-1])
				{
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args) {
		InsertionSort s = new InsertionSort();
		int[] arr = { 7,2,9,3,8,10,17,12,17};
		s.sort(arr);

	}

}
