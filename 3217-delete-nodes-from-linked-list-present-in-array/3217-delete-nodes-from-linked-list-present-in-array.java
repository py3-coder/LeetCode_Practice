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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }
        ListNode temp = new ListNode(-1);
        ListNode t = temp;
        
        
        while (head != null) {
            if (!set.contains(head.val)) {
                t.next = head;
                t = t.next;
            }
            head = head.next;
        }
        
        t.next = null;
        return temp.next;
    }
}