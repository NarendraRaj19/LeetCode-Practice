// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

class LinkedList
{
    static  Node head;  
    static  Node lastNode;
    
    public static void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=  new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();
            
            Node head = null;
            int val = sc.nextInt();
            head = new Node(val);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                val = sc.nextInt();
                addToTheLast(new Node(val));
            }
            
            Node before[] = new Node[n];
            addressstore(before, head);
            GFG obj = new GFG();
            
            head = obj.swapkthnode(head, n, K);
        
           Node after[] = new Node[n];
          addressstore(after, head);
        
        if(check(before, after, n, K) == true)
            System.out.println("1");
        else
            System.out.println("0");
        
        }
    }
    
    static boolean check(Node before[], Node after[], int num, int K)
    {
          if(K > num)
           return true;
           
           return (before[K-1] == after[num - K]) && (before[num-K] == after[K-1]);
              
       
    }
    
    static void addressstore(Node arr[], Node head)
  {
      Node temp = head;
      int i = 0;
      while(temp != null){
        arr[i] = temp;
        i++;
        temp = temp.next;
    }
}
    
}// } Driver Code Ends


//User function Template for Java


/* Linked List Node class
   class Node  {
     int data;
     Node next;
     Node(int data)
     {
         this.data = data;
         next = null;
     }
  }
*/
class GFG
{
    //Function to swap Kth node from beginning and end in a linked list.
    Node swapkthnode(Node head, int num, int K)
    {
        // your code here
        
        
        //if k is more than number of nodes or kth node from beginning 
        //and end are same, we return the list.
        if(K > num) return head;
         //if(2*K-1 == num) return head;
    
        Node x_prev = null;
        Node x = head;
    
        Node y_prev = null;
        Node y = head;
    
        int count = K-1;
        //finding the kth node from the beginning of list. We also find node
        //previous of kth node because we need to update next pointer of 
        // the previous node.
        // while(count-- > 0){
        // x_prev = x;
        // x = x.next;
        // }
        
        for(int i = K-1; i > 0; i--)
        {
            x_prev = x;
            x = x.next;
        }
    
        count = num - K;
        //similarly, finding the kth node from end and its previous node. kth
        //node from end is (num-k+1)th node from beginning .
        while(count-- > 0){
        y_prev = y;
        y = y.next;
        }
        
        //if x_prev exists, then new next of it will be y.
        if(x_prev != null)
            x_prev.next = y;
        //if y_prev exists, then new next of it will be x.
        if(y_prev != null)
            y_prev.next = x;
        
        //we will swap the next pointers of x and y.
        Node temp = x.next;
        x.next = y.next;
        y.next = temp;
        
        //changing head pointers when k is 1 or num.
        if(K == 1)
         head = y;
        if(K == num)
            head = x;
            
        return head;    
    }
}
