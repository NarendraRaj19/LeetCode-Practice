// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class getMin
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Taking all the testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //Taking total number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //adding all the elements to the array
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
             
            //calling _push method of class GetMin 
            //and storing the result in a new Stack
            Stack<Integer>mys = new GetMin()._push(arr,n);
            
            //calling _getMinAtPop method of class GetMin
            new GetMin()._getMinAtPop(mys);
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class GetMin
{
        static Stack<Integer> ms = new Stack<Integer>();
        static Stack<Integer> as = new Stack<Integer>();
    //Function to push all the elements into the stack.
    public static Stack<Integer> _push(int arr[],int n)
    {
        // your code here
        ms.push(arr[0]);
        as.push(arr[0]);
        for(int i=1; i<n; i++)
        {
                ms.push(arr[i]);
                if(ms.peek() <= as.peek()){
                as.push(arr[i]);
                } else {
                    as.push(as.peek());
                }
        }
        
        /* Debugging Purpose
        
        // while(!as.isEmpty()){
        //     System.out.println(as.pop());
        // }
        
        */
        
        return ms;
    }
    
    //Function to print minimum value in stack each time while popping.
    static void _getMinAtPop(Stack<Integer>s)
    {
        // your code here
        while(!as.isEmpty()){
            System.out.print(as.pop()+" ");
        }
        
    }
}