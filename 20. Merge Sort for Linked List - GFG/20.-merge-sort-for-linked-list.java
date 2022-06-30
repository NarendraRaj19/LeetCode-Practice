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
		   
		      head = new Solution().mergeSort(head);
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
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
       if(head==null || head.next==null)return head;
       
       Node mid = findMid(head);
       Node left = head;
       Node right = mid.next;
       mid.next = null;
       
       Node ls = mergeSort(left);
       Node rs = mergeSort(right);
       return merge(ls, rs);
    }
    
    static Node findMid(Node head){
       Node slow = head;
       Node fast = head.next; //So that if there are two mids then first mid can be found
        
       while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
       }
        
       return slow;
    }
    
    //merging two sorted lists and return the head of sorted list 
    static Node merge(Node ls, Node rs){
       Node head = new Node(-1);
       Node arg = head;
        
       Node l1 = ls;
       Node l2 = rs;
       while(l1 != null && l2 != null){
          if(l1.data <= l2.data){
             arg.next = l1;
             arg = arg.next;
              
             l1 = l1.next;
          }
          else{
             arg.next = l2;
             arg = arg.next;
              
             l2 = l2.next; 
          } 
           
       }
        
        while(l1 != null){
           arg.next = l1;
           arg = arg.next;
              
           l1 = l1.next; 
        }
        
         while(l2 != null){
           arg.next = l2;
           arg = arg.next;
              
           l2 = l2.next; 
        }
        
        return head.next;
    }
}


