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
    public ListNode reverseList(ListNode head){
        return solveRec(head);
    }
    //Iterative::
    public static ListNode reverse(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next =curr.next;
            curr.next =prev;
            prev =curr;
            curr=next;
        }
        if(prev.next!=null){
            head=prev;
        }
        return head;
    }
    // Recursive::
    public static ListNode solveRec(ListNode head){
        //Base Case ::
        if(head==null || head.next==null) return head;

        ListNode newhead =solveRec(head.next);
        head.next.next =head;
        head.next=null;
        return newhead;
    }
}