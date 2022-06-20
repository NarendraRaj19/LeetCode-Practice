// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    
    static Node reverseLinkedList(Node head){
    
        Node curr = head, prev = null;
        
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
        
    }
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        
        Node l1 = reverseLinkedList(first);
        Node l2 = reverseLinkedList(second);
        Node dummy = null;
        
        int current_sum = 0, carry = 0;
        
        while(l1 != null || l2 != null){
            int l1_val = (l1 != null)? l1.data : 0;
            int l2_val = (l2 != null)? l2.data : 0;
            
            current_sum = l1_val + l2_val + carry;
            carry = current_sum / 10;
            
            Node l3 = new Node((current_sum % 10));
            
            //System.out.println("The created Node is:: "+(current_sum % 10));
            l3.next = dummy;
            dummy = l3;
            
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        
        // while(dummy != null){
        //     //System.out.println("The current Node is:: "+ dummy.data);
        //     dummy = dummy.next;
        // }
        
        if(carry > 0){
            Node l3 = new Node(carry);
            l3.next = dummy;
            dummy = l3;
        }
        return dummy;
    }
}