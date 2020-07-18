package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree l = new InvertBinaryTree();
        TreeNode root = null;
        root = l.createTree(root, 0);
        TreeNode node = l.invertTree(root);
        l.print(node);
    }

    private void print(TreeNode node) {
        if (node==null)
            return;
        print(node.left);
        System.out.println(node.val);
        print(node.right);

    }

    private TreeNode createTree(TreeNode root, int i) {

        if (i<10){
            TreeNode temp = new TreeNode(i);
            root = temp;
            root.left = createTree(root.left, 2*i+1);
            root.right = createTree(root.right, 2*i+2);
        }
        return root;
    }
}
