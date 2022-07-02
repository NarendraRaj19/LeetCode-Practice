// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//taking the length of the string
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //taking the string
		   String str = br.readLine().trim();
		   
		   //calling removeConsecutiveDuplicates method of class solve
		   System.out.println(new Solution().removeConsecutiveDuplicates(str));
		}
	}
}// } Driver Code Ends




class Solution
{
    //Function to remove consecutive duplicates from given string using Stack.
    public static String removeConsecutiveDuplicates(String str)
    {
        // Your code here
        
        ArrayDeque<Character> a=new ArrayDeque<>();
       a.push(str.charAt(str.length()-1));
       for(int i=str.length()-2;i>=0;i--){
           if(str.charAt(i)==a.peek())
           continue;
           else{
               a.push(str.charAt(i));
           }
       }
       String ans="";
       while(!a.isEmpty()){
           ans=ans+a.pop();
       }
       return ans;
    }
}