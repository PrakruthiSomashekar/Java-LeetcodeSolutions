// Sum of Left Leaves
// Find the sum of all left leaves in a given binary tree.
package BinaryTree;

public class SumOfLeftLeaves {
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        return getSum(root.left, true) + getSum(root.right, false);
    }

    private int getSum(TreeNode node, boolean isLeft) {
        if (node == null)
            return 0;
        if(node.left==null && node.right==null && isLeft)
            return node.val;
        return getSum(node.left, true) + getSum(node.right, false);
    }

    public static void main(String[] args) {
        TreeNode l = new TreeNode(9);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode r = new TreeNode(20,rl,rr);
        TreeNode root = new TreeNode(3,l,r);
        SumOfLeftLeaves leftLeaves = new SumOfLeftLeaves();
        System.out.println(leftLeaves.sumOfLeftLeaves(root));
    }
}
