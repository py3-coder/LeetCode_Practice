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
    public ListNode rotateRight(ListNode head, int k) {
        //edge 

        if(head==null || head.next==null) return head;
        if(k==0) return head;
        int len=0;
        ListNode curr =head;
        while(curr.next!=null){
            len++;
            curr =curr.next;
        }
        len+=1;
        if(k==len) return head;
        k=k%len;
        if(k==0) return head;
        ListNode dummy=head;
        k=len-k;
        while(k-1>0){
            dummy =dummy.next;
            k--;
        }

        ListNode newHead =dummy.next;
        dummy.next =null;
        curr.next =head;
        return newHead;

    }
}