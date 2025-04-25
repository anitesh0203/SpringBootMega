package practice;

import java.util.*;

public class MetaKaBeta {
   static public class TreeNode {
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
     
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode,Integer> map = new LinkedHashMap<>();
        queue.add(root);
        map.put(root,0);
        while(!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            //visit
            while(!queue.isEmpty()) {
                //visit here the current level
                TreeNode node = queue.poll();
                int value = map.get(node);
                if(node.left != null){
                    list.add(node.left);
                    map.put(node.left,value-1);
                }
                if(node.right != null){
                    list.add(node.right);
                    map.put(node.right,value+1);
                }
            }
            for(TreeNode n : list) {
                queue.add(n);
            }
        }


        Map<Integer,List<TreeNode>> lelo = new LinkedHashMap<>();

        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            if(lelo.get(entry.getValue())==null) {
                List<TreeNode> temp = new ArrayList<>();
                temp.add(entry.getKey());
                lelo.put(entry.getValue(),temp);
            } else {
                List<TreeNode> temp = lelo.get(entry.getValue());
                temp.add(entry.getKey());
                lelo.put(entry.getValue(),temp);
            }
        }

        lelo.entrySet()
                .stream()
                .sorted(new Comparator<Map.Entry<Integer, List<TreeNode>>>() {
                    @Override
                    public int compare(Map.Entry<Integer, List<TreeNode>> o1, Map.Entry<Integer, List<TreeNode>> o2) {
                        if(o1.getKey()>o2.getKey())
                            return 1;
                        else
                            return -1;
                    }
                })
                .forEach(x-> {
                    List<Integer> li = new ArrayList<>();
                    for(TreeNode val :x.getValue()){

                        li.add(val.val);
                    }
                    ans.add(li);
                });

        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right= n3;
        n3.left = n4;
        n3.right = n5;
        MetaKaBeta metaKaBeta = new MetaKaBeta();
        System.out.println(metaKaBeta.verticalOrder(n1));


    }
}
