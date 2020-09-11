// Sum of Root To Leaf Binary Numbers
// Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with
// the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
//For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
//Return the sum of these numbers.
package BinaryTree;

public class SumOfRootToLeaf {

    public static int sumRootToLeaf(TreeNode root) {
        return getSum(root, 0);

    }

    public static int getSum(TreeNode node, int sum){
        if(node == null)
            return 0;
        sum = (sum<<1) + node.val;
        if(node.left == null && node.right == null){
            return sum;
        }
        return getSum(node.left, sum) + getSum(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode l = new TreeNode(0);
        TreeNode rl = new TreeNode(0);
        TreeNode rr = new TreeNode(1);
        TreeNode r = new TreeNode(1,rl,rr);
        TreeNode root = new TreeNode(1,l,r);
        System.out.println(sumRootToLeaf(root));
    }
}
