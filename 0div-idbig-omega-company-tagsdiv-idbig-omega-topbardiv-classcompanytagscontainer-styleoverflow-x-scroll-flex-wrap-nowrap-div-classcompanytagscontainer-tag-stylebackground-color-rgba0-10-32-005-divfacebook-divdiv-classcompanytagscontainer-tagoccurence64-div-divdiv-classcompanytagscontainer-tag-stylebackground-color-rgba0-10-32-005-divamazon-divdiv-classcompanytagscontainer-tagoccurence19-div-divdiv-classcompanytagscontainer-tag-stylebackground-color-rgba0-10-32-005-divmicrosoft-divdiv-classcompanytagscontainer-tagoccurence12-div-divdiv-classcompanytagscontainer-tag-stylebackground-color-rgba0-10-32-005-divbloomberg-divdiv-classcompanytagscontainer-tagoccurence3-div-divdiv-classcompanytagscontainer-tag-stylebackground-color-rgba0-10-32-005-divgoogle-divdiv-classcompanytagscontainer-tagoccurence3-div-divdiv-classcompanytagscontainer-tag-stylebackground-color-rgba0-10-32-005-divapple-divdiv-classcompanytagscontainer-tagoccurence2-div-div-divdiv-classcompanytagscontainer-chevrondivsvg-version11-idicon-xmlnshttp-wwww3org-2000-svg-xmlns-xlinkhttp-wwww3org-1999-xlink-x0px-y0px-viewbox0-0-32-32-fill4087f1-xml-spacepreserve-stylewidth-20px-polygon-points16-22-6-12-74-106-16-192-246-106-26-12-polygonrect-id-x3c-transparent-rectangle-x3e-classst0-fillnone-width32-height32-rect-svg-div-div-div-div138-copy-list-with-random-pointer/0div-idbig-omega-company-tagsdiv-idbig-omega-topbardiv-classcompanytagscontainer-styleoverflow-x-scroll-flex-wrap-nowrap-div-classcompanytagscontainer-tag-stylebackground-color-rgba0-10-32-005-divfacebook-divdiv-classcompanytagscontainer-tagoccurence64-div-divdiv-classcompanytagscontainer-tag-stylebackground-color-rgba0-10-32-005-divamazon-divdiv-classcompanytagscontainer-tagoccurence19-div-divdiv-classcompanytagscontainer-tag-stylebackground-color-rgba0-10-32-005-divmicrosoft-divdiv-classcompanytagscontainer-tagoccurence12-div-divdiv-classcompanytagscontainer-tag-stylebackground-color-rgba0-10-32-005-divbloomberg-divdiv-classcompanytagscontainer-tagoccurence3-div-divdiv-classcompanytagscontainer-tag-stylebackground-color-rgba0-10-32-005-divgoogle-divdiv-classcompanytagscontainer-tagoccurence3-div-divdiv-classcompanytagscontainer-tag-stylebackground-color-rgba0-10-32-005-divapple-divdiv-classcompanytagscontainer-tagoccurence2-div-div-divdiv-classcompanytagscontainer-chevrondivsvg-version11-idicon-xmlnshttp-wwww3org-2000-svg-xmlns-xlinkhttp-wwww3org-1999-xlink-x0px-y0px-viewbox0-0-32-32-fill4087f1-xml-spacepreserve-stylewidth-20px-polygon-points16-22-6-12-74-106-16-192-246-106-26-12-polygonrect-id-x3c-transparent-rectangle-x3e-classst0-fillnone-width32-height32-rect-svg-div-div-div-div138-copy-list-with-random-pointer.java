/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
//         HashMap<Node, Node> oldToNew = new HashMap<>();
//         Node curr = head;
//         while (curr != null) {
//             oldToNew.put(curr, new Node(curr.val));
//             curr = curr.next;
//         }
//         curr = head;
//         while (curr != null) {
//             oldToNew.get(curr).next = oldToNew.get(curr.next);
//             oldToNew.get(curr).random = oldToNew.get(curr.random);
//             curr = curr.next;
//         }
        
//         return oldToNew.get(head);
        
        // Seen striver video :: Optimal Approch :::
       //Step 1 :: Create new next to each original node::
       Node temp =head;
       while(temp!=null){
           Node var = new Node(temp.val);
           var.next =temp.next;
           temp.next =var;
           temp =temp.next.next;
       }
       //Step 2:: Make random link as in original for Copied new Nodes
       Node iter =head;
       while(iter!=null){
           if(iter.random!=null){
               iter.next.random =iter.random.next;
           }
           iter =iter.next.next;
       }
       
       //Step 3:: Make the sorted out form each other that retrive orignal and copied with proper link
       Node dummy =new Node(0);
       iter =head;
       temp =dummy;
       Node fast;
       while(iter!=null){
           fast =iter.next.next;
           temp.next =iter.next;
           iter.next =fast;
           temp =temp.next;
           iter=fast;
       }
       return dummy.next;

       //TC :  O(n)
       //Sc : O(1)
    }
}