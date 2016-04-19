package week2;

import java.util.HashMap;

public class Solution {
	 public int sumOfSqares(int a)
	    {
	        int value=0;
	        while(a>0)
	        {
	            value = value + a%10*a%10;
	            a=a/10;
	        }
	        return value;
	    }
	    public boolean isHappy(int n) {
	        if(n<1) return false;
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        while(n!=1)
	        {
	            n=sumOfSqares(n);
	            if(map.containsKey(n)) return false;
	            else map.put(n,n);
	        }
	        return true;
	    }
    
    public static void main(String[] args)
    {
    	Solution s= new Solution();
    	System.out.println((9%10)*(9%10));
    }
}