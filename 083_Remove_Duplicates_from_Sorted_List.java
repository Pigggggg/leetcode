/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode copy = head;
        while(copy != null){
            ListNode next = copy.next;
            while(next != null && copy.val == next.val){
                next = next.next;
            }
            copy.next = next;
            copy = next;
            if(next != null){
                next = next.next;
            }
        }
        return head;
    }
}