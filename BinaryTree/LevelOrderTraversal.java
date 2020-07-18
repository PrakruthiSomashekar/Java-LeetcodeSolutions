package BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len-- > 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal l = new LevelOrderTraversal();
        TreeNode root = null;
        root = l.createTree(root, 0);
        List<List<Integer>> result = l.levelOrder(root);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    public TreeNode createTree(TreeNode root, int i) {

      if (i<10){
            TreeNode temp = new TreeNode(i);
            root = temp;
            root.left = createTree(root.left, 2*i+1);
            root.right = createTree(root.right, 2*i+2);
        }
        return root;
    }

}

