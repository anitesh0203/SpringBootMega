package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Zigzag {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode node = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(node);
        List<List<Integer>> ans  = new ArrayList<>();
        boolean lr = true;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> treeNodes = new ArrayList<>();
            Deque<Integer> mainTea = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode elemet = deque.poll();
                treeNodes.add(elemet);
                mainTea.add(elemet.val);
            }
            for (TreeNode n:treeNodes) {
                if(n !=null) {
                    if(n.left!=null)
                        deque.add(n.left);
                    if(n.right!=null)
                        deque.add(n.right);
                }
            }
            if(lr) {
                while (!mainTea.isEmpty()){
                    list.add(mainTea.poll());
                }
                lr = false;
            } else {
                while (!mainTea.isEmpty()){
                    list.add(mainTea.pollLast());
                }
                lr=true;
            }

            ans.add(list);
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20,t4,t5);
        TreeNode t1 = new TreeNode(3,t2,t3);
        Zigzag zigzag = new Zigzag();
        System.out.println(zigzag.zigzagLevelOrder(t1));
    }
 }


