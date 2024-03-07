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
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) return head;

        return solveRec(head,head);
        
    }
    public static ListNode solveIter(ListNode head){
        ListNode fast=head;
        ListNode slow =head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode solveRec(ListNode slow,ListNode fast){
        if(fast==null || fast.next==null ) return slow;
        return solveRec(slow.next,fast.next.next);
    }
}