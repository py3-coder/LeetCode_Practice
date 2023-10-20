/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. Approch : using set traverse the both head till end:
        // TC:   O(n+m)  SC: O(n+m)

        // 2. Approch Find len diff::
        // TC : O(n+m)+O(n+m)
        // SC :O(1)
        return interserction(headA,headB);

        //3. Two pointer Approch::
        //TC : O(n+m)
        //SC : O(1)

        



    }
    //Lets implement 2 one::
    public static ListNode interserction(ListNode headA,ListNode headB){
        //
        int lenA =length(headA);
        int lenB =length(headB);

        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
    public static int length(ListNode head){
        if(head==null) return 0;
        return 1+length(head.next);
    }
}