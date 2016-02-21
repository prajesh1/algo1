package week3;

import week4.HeapSort;

public class MergeSort {
	
	public void sort(int[] a)
	{
		int[] aux = new int[a.length];
		for(int i=0;i<a.length;i++)
		aux[i]=a[i];
		//printArray(a);
		mergeSort(a,aux,0,a.length-1);
		printArray(a);
	}
	 
	public void printArray(int[] a)
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public void mergeSort(int[] a,int[]aux, int l, int h)
	{
		if(l>=h)return;
		int m = l +(h-l)/2;
		mergeSort(aux,a,l,m);
		mergeSort(aux,a,m+1,h);
		merge(a,aux,l,m,h);
	}
	
	public void merge(int[] a,int[] aux, int l, int m , int h)
	{
		//for(int i=l;i<=h;i++)
			//aux[i]=a[i];
		int i=l;
		int j=m+1;
		int k=l;
		while(k<=h)
		{
			if(i>m) aux[k++]=a[j++];
			else if(j>h) aux[k++]=a[i++];
			else if(a[i]>a[j]) aux[k++]=a[j++];
			else aux[k++]=a[i++];
		}
	}
	public static void main(String[] args) {
		MergeSort h = new MergeSort();
		int[] a = {2,4,6,3,6,8,2,9,1,7,23,45,76,21,32,98,1,9};
		h.sort(a);

	}

}
