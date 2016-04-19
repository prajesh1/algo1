package week2;

import java.util.Random;

/*
 * "Given an input array with a million integers, write a function (in any language of your choice) 
 * which returns True if the input integer array contains any two elements summing to 42. Return False otherwise.”
 * 
 * The question is vague so I am going to make some assumption.
 * Assumption 1: I will be using Java as programming language and assume integer as 32 bit primitive int.
 * Assumption 2: Data is completely random and has no patterns (like only positive numbers, lot of duplicates, 
 * integers between specific range of values)
 * Assumption 3: Data is not sorted
 */

public class FindSum {
	
	public boolean areTwoElementsWithSumKPresent(int[] arr, int k)
	{
		radixSort(arr);
		
		int i=0, j = arr.length;
		while(i<j)
		{
			int sum = arr[i]+arr[j];
			if(sum==k)
				return true;
			else if(sum<k)
				i++;
			else j--;
		}
		return false;
	}
	
	private void radixSort(int[] a)
	{
		 	int R = 256, bucket = 4, mask=255;
	         
		 	int[] copyArr = new int[a.length];

	        for (int i = 0; i < bucket; i++) 
	        {         
	        	int[] count = new int[R+1];
	            for (int j = 0; i < a.length; j++) 
	            {   
	            	int shift = a[i] >> 8*i; 
	                int val = shift & mask;
	                count[val + 1]++;
	            }

	            for (int k = 0; k < R; k++)
	                count[k+1] += count[k];

	            if (i == bucket-1) 
	            {
	                int left = count[R] - count[R/2];
	                int right = count[R/2];
	                for (int r = 0; r < R/2; r++)
	                    count[r] += left;
	                for (int r = R/2; r < R; r++)
	                    count[r] -= right;
	            }

	            for (int k = 0; k < a.length; k++) 
	            {
	                int shift = (a[i] >> 8*i); 
	                int val =shift & mask;
	                copyArr[count[val]++] = a[k];
	            }

	            for (int k = 0; k < a.length; k++)
	                a[i] = copyArr[i];
	        }
	}

	public static void main(String[] args) {
		FindSum findSum = new FindSum();
		
		int one_million = 100;
		int[] arr = new int[one_million];
		Random r = new Random();
		for(int i=0;i<one_million;i++)
		{
			arr[i] = r.nextInt();
		}
		boolean present = findSum.areTwoElementsWithSumKPresent(arr, 42);
		if(present)
			System.out.println("Two numbers with sum 42 present");
		else System.out.println("Two numbers with sum 42 absent");

	}

}
