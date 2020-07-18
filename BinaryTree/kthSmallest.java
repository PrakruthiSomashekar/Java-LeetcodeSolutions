package BinaryTree;

import java.util.LinkedList;

public class kthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true){
            while (root!=null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0)
                return root.val;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4,null,node4);
        TreeNode node3 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1,null,node3);
        TreeNode root = new TreeNode(3,node1,node2);
        kthSmallest k = new kthSmallest();
        System.out.println(k.kthSmallest(root,4));
    }
}

// Time complexity : O(H+k), where H is a tree height.
//This results in O(logN+k) for the balanced tree and O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
// Space complexity : O(H+k), the same as for time complexity, O(N+k) in the worst case, and O(logN+k) in the average case.