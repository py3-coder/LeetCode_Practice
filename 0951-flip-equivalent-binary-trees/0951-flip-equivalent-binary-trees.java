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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode curr1 = queue.poll();
            TreeNode curr2 = queue.poll();

            if (curr1 == null && curr2 == null) {
                continue;
            }
            if (!isEquals(curr1, curr2)) {
                return false;
            }
            if (isEquals(curr1.left, curr2.left) && isEquals(curr1.right, curr2.right)) {
                queue.offer(curr1.left);
                queue.offer(curr2.left);
                queue.offer(curr1.right);
                queue.offer(curr2.right);
            } else if (isEquals(curr1.left, curr2.right) && isEquals(curr1.right, curr2.left)) {
                queue.offer(curr1.left);
                queue.offer(curr2.right);
                queue.offer(curr1.right);
                queue.offer(curr2.left);
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isEquals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null && root1.val == root2.val) {
            return true;
        } else {
            return false;
        }
    }
}