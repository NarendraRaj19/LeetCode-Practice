// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
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
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
    //     Node curr = head;
        
    //     Node resultList = null;
    //     Node output = null;
    //     boolean flag = false;
        
    //     //Add Zero Nodes to new Linked List
    //     while(curr != null){
    //         if(curr.data == 0){
                
    //             if(flag != true) {
    //                 System.out.println("Enters Condition!!");
    //                 flag = true;
    //                 resultList = curr;
    //                 output = resultList;
    //             } else {
    //                 resultList.next = curr;
    //             }
    //         }
    //         curr = curr.next;
    //     }
        
    //     curr = head;
    //   //Add One Nodes to new Linked List 
    //     while(curr != null){
    //         if(curr.data == 1){
    //             resultList.next = curr;
    //             //resultList = resultList.next;
    //         }
    //         curr = curr.next;
    //     }
        
        
    //     curr = head;
    //   //Add Two Nodes to new Linked List 
    //     while(curr != null){
    //         if(curr.data == 2){
    //             resultList.next = curr;
    //             //resultList = resultList.next;
    //         }
    //         curr = curr.next;
    //     }
        
    //     return output;
    
    Node h0 = new Node(-1);
       Node zr = h0;
       
       Node h1 = new Node(-1);
       Node on = h1;
       
       Node h2 = new Node(-1);
       Node tw = h2;
       
       Node curr = head;
       while(curr != null){
         if(curr.data == 0){
            zr.next = curr;
            zr = zr.next;
         }
         else if(curr.data == 1){
            on.next = curr;
            on = on.next;
         }
         else{
            tw.next = curr;
            tw = tw.next; 
         }
         
         curr = curr.next;
       }
       
       if(h0.next==null){
          if(h1.next==null)head = h2.next;
          else head = h1.next;
       }
       else head = h0.next;
       
       zr.next = h1.next == null ? h2.next : h1.next;
       on.next = h2.next;
       tw.next = null;
       
       return head;
    }
}


