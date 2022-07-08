// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    
    public static int precedenceValue(char c){
        
        if(c == '^') return 3;
        else if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return -1;
    }
    
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st = new Stack<>();
        String ans = "";
        
        for(char c : exp.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                ans += c;
            }
            else if(c =='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.pop();
                }
                
                if(!st.isEmpty()){
                    st.pop();
                }
            } else {
              while(!st.empty() && precedenceValue(st.peek()) >= precedenceValue(c)){
                   ans+=st.pop();
               }
               
               st.push(c);
           }
        }
        while(!st.empty()){
           ans+=st.pop();
       }
       return ans;
        
     } 
}