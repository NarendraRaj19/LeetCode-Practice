// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int [] result = new int[n];
        
        result[0] = 1;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.add(0);
        
        for(int i=1; i<n; i++)
        {
            while(stack.isEmpty() == false && price[stack.peek()] <= price[i]){
                stack.pop();
            }
            // int span = (stack.isEmpty()) ? i+1 : i - stack.peek();
            // System.out.println("Span Value: "+span);
            result[i] = (stack.isEmpty()) ? i+1 : i - stack.peek();
            stack.push(i);
        }
        return result;
    }
    
}