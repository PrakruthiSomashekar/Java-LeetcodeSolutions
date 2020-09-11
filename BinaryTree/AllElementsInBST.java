// All Elements in Two Binary Search Trees
// Given two binary search trees root1 and root2.
//Return a list containing all the integers from both trees sorted in ascending order.
package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInBST {

    public static void main(String[] args) {

        TreeNode root1R = new TreeNode(8);
        TreeNode root1 = new TreeNode(1,null,root1R);
        TreeNode root2L = new TreeNode(1);
        TreeNode root2 = new TreeNode(8,root2L,null);
        getAllElements(root1,root2);
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        inorder(result,root1);
        inorder(result,root2);
        Collections.sort(result);
        return result;
    }

    private static void inorder(List<Integer> result, TreeNode root1) {
        if(root1==null)
            return;
        inorder(result, root1.left);
        result.add(root1.val);
        inorder(result, root1.right);
    }
}
