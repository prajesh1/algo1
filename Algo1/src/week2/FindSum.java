package week2;

import java.util.Random;

/*
 * "Given an input array with a million integers, write a function (in any language of your choice) 
 * which returns True if the input integer array contains any two elements summing to 42. Return False otherwise.
 * 
 * The question is vague so I am going to make some assumption.
 * Assumption 1: I will be using Java as programming language and assume integer as 32 bit primitive int.
 * Assumption 2: Data is completely random and has no patterns (like only positive numbers, lot of duplicates, 
 * integers between specific range of values)
 * Assumption 3: Data is not sorted
 * 
 * Main function:areTwoElementsWithSumKPresent
 * 1. calls radix sort to make sure data is sorted
 * 2. Using two pointers i and j tries to find the sum =k
 * 	  if sum > a[i]+ [j] then increments i else decrements j
 * 
 * function: radixSort
 * Convert integers into 4 buckets of size 8
 * Performs LSD Radix sort for each bucket
 * 
 * Complexity Analysis
 * Radix sort: 2 *O(n+bucket) = 2*O(one_million + 256) ~ O(n) 
 */

public class FindSum {
	
	public boolean areTwoElementsWithSumKPresent(int[] arr, int k)
	{
		radixSort(arr);
		
		int i=0, j = arr.length-1;
		while(i<j)
		{
			int sum = arr[i]+arr[j];
			
			if(sum>0&&(arr[i]<0&&arr[j]<0)) // Integer Underflow happened, 
				i++;						//sign of sum is opposite that of arr[i] and arr[j]
											// k must be >=Integer.MIN_VALUE so increment
			else if(sum<0&&(arr[i]>0&&arr[j]>0)) // Integer Overflow happened
				j--;
			else if(sum==k)
				return true;
			else if(sum<k)
				i++;
			else j--;
		}
		return false;
	}
	
	private void radixSort(int[] a)
	{	
			// Radix size = 2^8 = 256, bucket = 32/8, mask = Radix-1
		 	int R = 256, bucket = 4, mask=255;  
	         
		 	int[] copyArr = new int[a.length];

	        for (int i = 0; i < bucket; i++) //Runs 4 times for each radix
	        {         
	        	int[] count = new int[R+1];
	            for (int j = 0; j < a.length; j++) //Populates count array with count of each number
	            {   
	            	int shift = a[j] >> 8*i; // Bit shifted to get correct bucket
	                int val = shift & mask;  // mask to remove unwanted bits
	                count[val + 1]++;
	            }

	            for (int k = 0; k < R; k++)  // cumulative sum
	                count[k+1] += count[k];

	            if (i == bucket-1)   // In Java the most significant is 1 for negative numbers
	            {					// So for Most significant bit, we have to make sure +ve numbers come after -ve
	                int left = count[R] - count[R/2];
	                int right = count[R/2];
	                for (int r = 0; r < R/2; r++)  //Shifted +ve numbers to right
	                    count[r] += left;
	                for (int r = R/2; r < R; r++)//Shifted -ve numbers to left
	                    count[r] -= right;
	            }

	            for (int k = 0; k < a.length; k++) //Create copy array using count array
	            {
	                int shift = (a[k] >> 8*i); 
	                int val =shift & mask;
	                copyArr[count[val]++] = a[k];
	            }

	            for (int k = 0; k < a.length; k++) //copy back to original array
	                a[k] = copyArr[k];
	        }
	}

	public static void main(String[] args) {
		FindSum findSum = new FindSum();
		
		int one_million = 100000;
		int[] arr = new int[one_million];
		Random r = new Random();
		for(int i=0;i<one_million;i++)
		{
			arr[i] = r.nextInt();
		}
		/*for(int i=0;i<one_million;i++)
		{
			System.out.print(arr[i]+" ");
		}*/
		
		boolean present = findSum.areTwoElementsWithSumKPresent(arr, 42);
		
		if(present)
			System.out.println("Two numbers with sum 42 present");
		else System.out.println("Two numbers with sum 42 absent");

	}

}
