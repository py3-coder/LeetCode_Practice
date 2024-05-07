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

// Otimal Process :-
/// TC : O(N) + O(N ) +O(N) 
/// SC : O(1)
class Solution {
    
    // TC : O(n)
    // SC :O(1);
    
    // Copied Idea ::-
    public ListNode doubleIt(ListNode head) {
        if (head.val > 4)
            head = new ListNode(0, head);
        for(ListNode node = head; node != null; node = node.next) {
            node.val = (node.val * 2) % 10;
            if (node.next != null && node.next.val > 4)
                node.val++;
        }
        return head;
    }
//     public ListNode doubleIt(ListNode head) {
//         ListNode  revhead = reverse(head);
        
//         int carry=0;
//         ListNode master = new ListNode(-1);
//         ListNode temp  = master;
//         while(revhead!=null){
//             int v = revhead.val*2+carry;
//             carry  = v/10;
//             v= v%10;
//             ListNode node = new ListNode(v);
//             master.next = node;
//             revhead = revhead.next;
//             master = master.next;
//         }
//         if(carry>0){
//             ListNode due = new ListNode(carry);
//             master.next = due;
//         }
        
//         return reverse(temp.next);
//     }
//     public ListNode reverse(ListNode head){
//         if(head==null || head.next==null) return head;
        
//         ListNode curr = head;
//         ListNode prev =null;
//         ListNode next;
        
//         while(curr!=null){
//             next = curr.next;
            
//             curr.next = prev;
//             prev =curr;
//             curr = next;
//         }
//         if(prev.next!=null){
//             head = prev;
//         }
//         return head;
//     }
}