/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    //Reverse a LinkedList upto k Nodes
    public ListNode reverseLinkedList(ListNode head, int k){
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(k > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        
        // Return the head of the reversed list
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode ptr = head;
        
        ListNode ktail = null, new_head = null;
        
        if(head == null || head.next == null) return head;
        
        while(ptr != null){
            
            int count = 0;
            
            while(ptr!= null && count < k){
                ptr = ptr.next;
                count++;
            }
            
            if(count == k){
                // Reverse k nodes and get the new head
                ListNode revHead = this.reverseLinkedList(head, k);
                
                // new_head is the head of the final linked list
                if (new_head == null)
                    new_head = revHead;
                
                // ktail is the tail of the previous block of 
                // reversed k nodes
                if (ktail != null)
                    ktail.next = revHead;
                    
                ktail = head; 
                head = ptr;
                
            }
        }
        if (ktail != null)
            ktail.next = head;
        
        return new_head == null ? head : new_head;
    }
}