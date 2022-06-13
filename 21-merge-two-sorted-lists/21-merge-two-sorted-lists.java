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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode currA = list1, currB = list2;
        ListNode head;
        ListNode tail;
        
        
        if(currA.val <= currB.val){
            head = tail = currA;   
            currA = currA.next;
        } else {
            head = tail = currB;
            currB = currB.next;
        }
        
        while(currA != null && currB != null){
           if(currA.val <= currB.val){
                tail.next = currA;
                tail = currA;
                currA = currA.next;
            } else {
                tail.next = currB;
                tail = currB;
                currB = currB.next;
            } 
        }
        
        if(currA == null) tail.next = currB;
        else tail.next = currA;
        
        return head;
    }
}