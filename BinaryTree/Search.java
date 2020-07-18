package BinaryTree;

// Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST
// that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
public class Search {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode res = root;
        if(root == null)
            return res;
        while (res!=null){
            if (res.val == val)
                return res;
            else if(res.val<val)
                res = res.right;
            else res = res.left;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2,n1,n3);
        TreeNode n7 = new TreeNode(7);
        TreeNode root = new TreeNode(4,n2,n7);
        Search search = new Search();
        TreeNode result = search.searchBST(root,2);
    }
}
