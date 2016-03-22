import java.util.Random;

public class CountingSort {
    int unsortedArray[];
    int bucket[];
    int sortedArray[];

    public CountingSort(int[] a,int bucket) {
        this.unsortedArray = a;// this is not immutable
        this.sortedArray = new int[a.length];
        this.bucket = new int[bucket];
    }
    
    public void sort()
    {
        for(int i=0;i<this.unsortedArray.length;i++)
            bucket[this.unsortedArray[i]]++;
        
        for(int i=1;i<this.bucket.length;i++)
            bucket[i] = bucket[i]+bucket[i-1];
        
        for(int i=this.unsortedArray.length-1;i>=0;i--)
        {
            bucket[this.unsortedArray[i]]--;
            sortedArray[bucket[this.unsortedArray[i]]] = this.unsortedArray[i];
        }
    }
    
    public void newsort()
    {
    	   this.bucket = new int[20];
        for(int i=0;i<this.unsortedArray.length;i++)
            bucket[this.unsortedArray[i]]++;
        
        int i = 0;
        while(i<bucket.length)
        {
        	int j=0;
        	while(j++<bucket[i])
        		System.out.print(i+" ");
        	i++;
        }
    }
    
    public void display()
    {
        System.out.println("Unsorted Array");
        for(int i=0;i<this.unsortedArray.length;i++)
            System.out.print(this.unsortedArray[i]+" ");
        System.out.println("");
        System.out.println("Sorted Array");
        for(int i=0;i<this.sortedArray.length;i++)
            System.out.print(this.sortedArray[i]+" ");
    }

    public static void main(String[] args) {
        
        Random r = new Random();
        int size =10;
        int[] a = new int[size];
        for(int i=0;i<size;i++)
        {
            a[i]=r.nextInt(20); 
        }
        CountingSort s = new CountingSort(a,20);
        s.sort();
        s.display();
        System.out.println(" ");
        s.newsort();
    }

}