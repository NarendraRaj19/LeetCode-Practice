// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int size = (int)n;
        long[] pse = new long[size];
        long[] nse = new long[size];
        
        //Finding the Previous Smaller Element
        s.push(0);
        pse[0] = -1;
        for(int i=1; i<size; i++)
        {
            while(s.isEmpty() == false && hist[s.peek()] >= hist[i]){
                //System.out.println("The value popped is"+s.peek()+" current element :"+hist[i]);
                s.pop();
            }
            
            pse[i] = (s.isEmpty() ? -1 : s.peek());
            s.push(i);
        }
        
        while(s.isEmpty()==false){
            s.pop();
        }
        
        //Finding the Next Smaller Element
        s.push(size-1);
        nse[size-1] = n;
        
        for(int i=size-2; i>=0; i--)
        {
            while(s.isEmpty() == false && hist[s.peek()] >= hist[i]){
                
                s.pop();
            }
            
            nse[i] = (s.isEmpty() ? n : s.peek());
            s.push(i);
        }
        
        
        
        //Now we have the smaller element to left & right of each element in two arrays (pse & nse)
        
        long res = 0;
        
        for(int i=0;i<size;i++){
            long curr=hist[i];
            curr+=(i-pse[i]-1)*hist[i];
            curr+=(nse[i]-i-1)*hist[i];
            res=Math.max(res,curr);
        }
        return res;
        
    }
        
}



