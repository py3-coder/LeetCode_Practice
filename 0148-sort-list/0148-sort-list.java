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
    public ListNode sortList(ListNode head) {
        //Brute Force ::
        ListNode temp = head;
        ArrayList<Integer> lis = new ArrayList<>();
        while(temp!=null){
            lis.add(temp.val);
            temp=temp.next;
        }
        temp=head;
        Collections.sort(lis);
        for(int val:lis){
            temp.val =val;
            temp=temp.next;
        }
        return head;
        // TC : O(n)+O(nlogn)+O(n)
        //SC : O(n)
    }
}