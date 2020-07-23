package BinaryTree;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> subList = null;
        int turn = 0;
        if(root == null)
            return list;
        queue.add(root);
        while (queue.size()!=0){
            int size = queue.size();
            subList = new ArrayList<>();

            while (size!=0){
                TreeNode node = queue.poll();
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
                subList.add(node.val);
                size = size - 1;
            }
            if(turn%2 != 0)
                Collections.reverse(subList);
            list.add(subList);
            turn++;

        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(15);
        TreeNode right1 = new TreeNode(5);
        TreeNode right2 = new TreeNode(7);
        TreeNode right = new TreeNode(20,left2,right2);
        TreeNode left = new TreeNode(9);
        TreeNode root = new TreeNode(3,left,right);

        List<List<Integer>> list = zigzagLevelOrder(root);
        for(List<Integer> s : list)
            System.out.println(s);

    }
}
