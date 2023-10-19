/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public boolean hasCycle(ListNode head) {
        //edge case::
        if(head==null || head.next ==null) return false;

        //Two pointer Approch ::
        // TC : O(N)  SC :O(1)
        //return check(head);

        // Using Set::
        // TC : O(N) SC: O(N)
        //return solveSet(head);

        // Recursive 
        // TC : O(n)   SC:O(1)
        return solveRec(head.next,head.next.next);
    }
    public static boolean check(ListNode head){
        ListNode slow = head ,fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        
          if(fast == slow)
            return true;
        }
        return false;
    }
    public static boolean solveSet(ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        

        while(head.next!=null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head=head.next;
        }
        return false;
    }
    // Lets Try Recursion::
    // TC : O(n)  SC : O(1)
    public static boolean solveRec(ListNode slow,ListNode fast){
        if(slow == fast){
            return true;
        }
        if(fast==null || slow==null || fast.next==null) return false;
        return solveRec(slow.next,fast.next.next);
    }
}