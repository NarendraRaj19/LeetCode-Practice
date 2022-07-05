// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        ArrayDeque<Long> sq = new ArrayDeque<>();
        
        long[] result = new long[n];
        
        result[0] = -1;
        sq.push(arr[n-1]);
        int j =1;
        
        for(int i=n-2; i>=0; i--)
        {
            while(sq.isEmpty() == false && sq.peek() <= arr[i]){
                sq.pop();
            }
            result[j] = sq.isEmpty() ? -1 : sq.peek();
            j++;
            sq.push(arr[i]);
        }
        
        long[] output = new long[n];
        
        for(int i=0; i<n; i++)
        {
            output[i] = result[n-(i+1)];
        }
        
        return output;
    } 
}