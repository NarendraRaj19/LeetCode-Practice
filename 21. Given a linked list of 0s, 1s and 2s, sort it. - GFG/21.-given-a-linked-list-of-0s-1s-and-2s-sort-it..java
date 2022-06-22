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
        Node curr = head;
        
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        
        //initializing current pointers for three lists.
        Node zero = zeroD, one = oneD, two = twoD;
        
        //traversing over the list with a pointer.
        while(curr != null)
        {
            //we check data at current node and store the node in it's 
            //respective list and update the link part of that list.
            if(curr.data == 0)
            {
                zero.next = curr;
                zero = zero.next;
                curr = curr.next;
            }
            else if(curr.data == 1)
            {
                one.next = curr;
                one = one.next;
                curr = curr.next;
            }
            else
            {
                two.next = curr;
                two = two.next;
                curr = curr.next;
            }
        }
        

        //printList(twoD);
        //attaching the three lists containing 0s,1s and 2s respectively.
        zero.next = (oneD.next  != null) ? (oneD.next) : (twoD.next);
        one.next = twoD.next;
        two.next = null;
        
        //updating the head of the list.
        
        return zeroD.next;
        
    
    }
    
    static void printList(Node n){
        
        while(n != null){
            System.out.println("Data:: "+n.data);
            n = n.next;
        }
    }
}


