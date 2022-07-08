// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    
    //Functions to handle operators
    public static int add(int a, int b ){
        //System.out.println("Addition! ");
        return a+b;
    }
    
    public static int subtract(int a, int b ){
        //System.out.println("subtract! ");
        return a-b;
    }
    
    public static int multiply(int a, int b ){
        //System.out.println("multiply! ");
        return a*b;
    }
    
    public static int divide(int a, int b ){
        //System.out.println("divide! ");
        return a/b;
    }
    
    public static int power(int a, int b ){
        //System.out.println("power! ");
        return a^b;
    }
    
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        
        for(char c : S.toCharArray())
        {
            if(Character.isLetterOrDigit(c)){
                st.push(Character.getNumericValue(c));
            } else {
                // while(!st.isEmpty()){
                //     System.out.println("Elements "+st.pop());
                // }
                
                int op1 = st.pop();
                int op2 = st.pop();
                
                
                //System.out.println("Operands are: "+(op1 - '0')+" && "+(op2 - '0'));
                int result;
                //(op2 - '0'), (op1 - '0')
                
                if(c == '+') result = add(op2, op1);
                else if(c == '*') result = multiply(op2, op1);
                else if(c == '/') result = divide(op2, op1);
                else if(c == '-') result = subtract(op2, op1);
                else if(c == '^') result = power(op2, op1);
                else result = -1;
                
                //System.out.println("Result: "+result);
                //char cr=(char)(result+'0'); 
                //System.out.println("Result Pushed: "+cr);
                st.push(result);
            }
        }
        //char ans = st.pop();
        //System.out.println("Answer: "+st.peek());
        
        return st.pop();
    }
}