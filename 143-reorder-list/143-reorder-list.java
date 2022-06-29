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
    public void reorderList(ListNode head) {
        
        if(head == null) return;
        
        //Find the midddle of the Linked List
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second part of the linked list
        // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
        // reverse the second half in-place
        ListNode prev = null, curr = slow, temp;
        
        while(curr != null){
            temp = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        // merge two sorted linked lists [Problem 21]
        // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
        
        ListNode first = head, second = prev, tmp;
        while (second.next != null) {
          tmp = first.next;
          first.next = second;
          first = tmp;

          tmp = second.next;
          second.next = first;
          second = tmp;
        }
        
    }
}