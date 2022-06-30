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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int length = lists.length;
        
        for(int i=0; i<length; i++){
            ListNode head = lists[i];
            ListNode curr = head;
            while(curr != null){
                pq.add(curr.val);
                curr = curr.next;
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        
        while(!pq.isEmpty()){
            ListNode newNode = new ListNode(pq.poll());
            dummy.next = newNode;
            dummy = dummy.next;
        }
        
        return ans.next;
        
        
    }
}