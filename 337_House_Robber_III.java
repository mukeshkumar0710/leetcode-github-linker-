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
    public int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    // Returns int[]{robThisNode, notRobThisNode}
    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        // Case 1: Rob this node -> cannot rob left or right children
        int rob = root.val + left[1] + right[1];

        // Case 2: Do not rob this node -> can either rob or not rob each child
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}