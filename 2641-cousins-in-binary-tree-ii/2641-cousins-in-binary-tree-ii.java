/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
         Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currentLevelSum = root.val;
        while (!q.isEmpty()) {
            int nextLevelSum = 0;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode n = q.poll();
                n.val = currentLevelSum - n.val;
                for (TreeNode kid : new TreeNode[]{n.left, n.right}) {
                    if (kid != null) {
                        q.offer(kid);
                        nextLevelSum += kid.val;
                    }
                }
                if (n.left != null && n.right != null) {
                    int sum = n.left.val + n.right.val;
                    n.left.val = n.right.val = sum;
                }
            }
            currentLevelSum = nextLevelSum;
        }
        return root;        
    }
}