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
    public ListNode detectCycle(ListNode head) {
        if(head == null||head.next == null) return null;
        HashSet<ListNode> st=new HashSet<>();
        while(head != null) {
        if(st.contains(head)) return head;
        st.add(head);
        head = head.next;
        }
    return null;
        // HashMap<ListNode, Integer> map = new HashMap<>();
        // ListNode temp =head;
        // while(temp!=null){
        //     if(map.containsKey(temp)){
        //         return temp;
        //     }
        //     map.put(temp,1);
        //     temp =temp.next;
        // }
        // return null;
    }
}