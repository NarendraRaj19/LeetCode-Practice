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
    
    //Method to reverse a LinkedList upto K nodes
    public ListNode reverseLinkedList(ListNode head, int k) {
    
        ListNode next = null, prev = null, curr = head;
        
        while(k > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        
        //returns the head of the reversed Linked List
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;
        
        
        ListNode ptr = head, kTail = null, newHead = null;
        
        
        while(ptr != null){
            
            int count = 0;
            
            
            while(ptr != null && count < k){
                ptr = ptr.next;
                count++;
            }
            
            //Only if there are k nodes available then we proceed and reverse them
            if(count == k){
                //
                ListNode revHead = this.reverseLinkedList(head, k);
                
                //Gets assigned the initial value of revHead
                if(newHead == null){
                    newHead = revHead;
                }
                
                //
                if(kTail != null){
                    kTail.next = revHead;
                }
                
                //kTail references the tail of the final/modified linked list
                kTail = head;
                //Updating the head after completion of reversing k nodes
                head = ptr;
                
            }
        }
        
        // attach the final, possibly un-reversed portion
        if(kTail != null){
            kTail.next = head;
        }
        
        return newHead == null ? head : newHead;
    }
}