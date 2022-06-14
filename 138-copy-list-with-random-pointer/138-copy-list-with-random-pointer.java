/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return head;
        Node next,temp;
        
        //Creating Copy Nodes for each original Node
        for(Node curr=head;curr!=null;){
            next=curr.next;
            curr.next=new Node(curr.val);
            curr.next.next=next;
            curr=next;
        }
        
        //Attaching Random Pointers to Copy Nodes
        for(Node curr=head;curr!=null;curr=curr.next.next){
            curr.next.random=(curr.random!=null)?(curr.random.next):null;
        }
        
        
        //Detaching Copy Nodes from Original Linked List
        Node original = head, copy = head.next; 
      
        temp = copy; 
      
        while (original!=null && copy!=null) 
        { 
            original.next = 
             original.next!=null? original.next.next : original.next; 
      
            copy.next = copy.next!=null?copy.next.next: copy.next; 
            original = original.next; 
            copy = copy.next; 
        } 
      
        return temp;
    }
}