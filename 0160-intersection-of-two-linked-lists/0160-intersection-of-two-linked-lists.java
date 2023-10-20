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
        // Iterative/ Recursive just add aux space O(n+m) for func call:
        // TC : O(n+m)+O(n+m) ~ O(n+m)
        // SC :O(1)
        //return intersection1(headA,headB);

        //3. Two Traversal::
        //TC : O(n+m)
        //SC : O(1)
        return intersection(headA,headB);

    }
    //Lets implement 2 one:: this can also done with recursion::
    // simple aaproch think bit you will get it.
    public static ListNode intersection1(ListNode headA,ListNode headB){
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

    //Approch 3:
    // two iteration :: Imp
    public static ListNode intersection(ListNode headA,ListNode headB){
        //edge
        if(headA==null || headB==null){
            return null;
        }
        ListNode A =headA;
        ListNode B =headB;
        //diff len : need 2 iteration:
        while(A!=B){
            //after the first traversal ::
            // just change the A - point B head and B -point A head
            // Math :: len(A) = n+c  
            //      len(B) =m+c
            // n+c+m+c == m+c+n+c :: if there is intersection they must meet in second iteration 
            // else they meet at null pointer:)
            A = (A==null)?headB:A.next;
            B = (B==null)?headA:B.next;
        }
        return A;
    }
    
}