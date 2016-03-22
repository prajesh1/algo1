package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
    	if(pattern==null||str==null) return false;
        String[] hash = new String[26];
        String[] st = str.split("\\s+");
        int i=0; 
        for(String e:st)
        {
            if(i>= pattern.length()) return false;
            String x = hash[pattern.charAt(i)-'a'];
            if(x==null)
            hash[pattern.charAt(i)-'a'] = e;
            else if(!x.equals(e)) return false;
            i++;
        }
        for(int k=0;k<pattern.length();k++)
        	for(int j=k+1;j<pattern.length();j++)
        	{
        		if((pattern.charAt(k)!=pattern.charAt(j))&&hash[pattern.charAt(k)-'a'].equals(hash[pattern.charAt(j)-'a']))
        		return false;
        	}
        return true;
    }
    public static void main(String args[])
    {
    	
    	//Solution s = new Solution();
    	//s.addTwoNumbers(s.x, s.y);
    	//System.out.print(Math.ceil(Math.log(5)/Math.log(2)));
    	
    		//System.out.println(s.wordPattern("abba", "abba"));
    		
    		String x = "3e4";
    		Double t = Double.parseDouble(x);
}
}