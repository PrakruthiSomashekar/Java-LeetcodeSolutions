package BinaryTree;

// Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

public class Cousins {

    public static void main(String[] args) {
        // write your code here
        Cousins m = new Cousins();
        TreeNode r2 = new TreeNode(5);
        TreeNode r1 = new TreeNode(3,null,r2);
        TreeNode l2 = new TreeNode(4);
        TreeNode l1 = new TreeNode(2,null,l2);
        TreeNode root = new TreeNode(1,l1,r1);
        System.out.println(m.isCousins(root,4,5));
    }

    TreeNode xParent = null, yParent = null;
    int xDepth = -1, yDepth = -2;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }
    void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
        if (root == null) return;
        if (x == root.val) {
            xParent = parent;
            xDepth = depth;
        } else if (y == root.val) {
            yParent = parent;
            yDepth = depth;
        } else {
            // if we found x node or found y node then we don't need to dfs deeper
            //     because x and y must be the same depth
            dfs(root.left, root, x, y, depth + 1);
            dfs(root.right, root, x, y, depth + 1);
        }
    }
}
