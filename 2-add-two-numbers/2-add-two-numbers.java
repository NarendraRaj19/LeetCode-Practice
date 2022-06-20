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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l3 = new ListNode(0);
        ListNode dummy = l3;
        int carry = 0;
        int l1_value, l2_value, sum;
        
        while(l1 != null || l2 != null){
            l1_value = (l1 != null) ? l1.val : 0;
            l2_value = (l2 != null) ? l2.val : 0;
            
            sum = l1_value + l2_value + carry;
            carry = sum / 10;
            
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            
            l1 = (l1 != null) ?  l1.next : null;
            l2 = (l2 != null) ?  l2.next : null;
        }
        
        if(carry > 0){
            dummy.next = new ListNode(carry);
        }
        
        return l3.next;
    }
}