package week3;

import java.util.Random;

public class Select {
	public static void shuffle(int[] a)
	{
		Random r = new Random();
		for(int i=a.length-1;i>=0;i--)
			exchange(a,i,r.nextInt(i+1));
	}
	private static void exchange(int[] a, int i , int j)
	{
		int temp = a[i];
		a[i]= a[j];
		a[j]=temp;
	}
	public static int partition(int[] a, int l, int h) {
		int i = l,j=h+1;
		while(true)
		{
			while(a[l]>a[++i])
				if(i==h) break;
			while(a[l]<a[--j]);
			
			if(i<j) //exchange has not happened
				exchange(a,i,j);
			else break;
		}
	//	System.out.println("j "+j);
		exchange(a,l,j);
		return j;		
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int k=7;
		int l=0, h=a.length-1;
		shuffle(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println(" ");
		while(l<=h)
		{
			int j = partition(a,l,h);
			if(j>k) h=j-1;
			else if(j<k) l = j+1;
			else {
				System.out.println(a[k]);
				break;
				}
		}
		

	}


}
