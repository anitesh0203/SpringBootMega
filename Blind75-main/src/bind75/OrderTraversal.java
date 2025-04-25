package bind75;

import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
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

public class OrderTraversal {

    public void preorder(TreeNode root, int valueSubRoot, TreeNode answer) {
        if(root==null) {
            return;
        }
        if(root.val==valueSubRoot) {
            answer = root;
            return;
        }
        preorder(root.left, valueSubRoot, answer);
        preorder(root.right, valueSubRoot, answer);
    }

    public boolean ans (TreeNode root, TreeNode subRoot) {
        if(root.val!=subRoot.val) {
           return false;
        }
        ans(root.left,subRoot.left);
        ans(root.right, subRoot.right);
        return true;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode node = new TreeNode();
        preorder(root, subRoot.val, node);
        if(node.val==0) {
            return false;
        }
        System.out.println(node.val);
        return ans(node,subRoot);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> megaList = new ArrayList<>();

            List<Integer> list = null;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty())    {
                list = new ArrayList<>();

                for(int i=0 ; i< queue.size(); i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                megaList.add(list);
            }
            return megaList;
    }


    List<Integer> list = new ArrayList<>();
    public void addInOrder(TreeNode node) {
        if(node==null) {
            return;
        }
        addInOrder(node.left);
        list.add(node.val);
        addInOrder(node.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        addInOrder(root);
        return list.get(k);
    }

    public int hammingWeight(int n) {
        String num = String.valueOf(n);
        char[] charArray = num.toCharArray();
        int i=0;
        int sum =0 ;
        while (i<charArray.length) {
            if(charArray[i]==1) {
                sum++;
            }
        }
        return sum;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        int n = intervals.length;
        for (int i=0 ; i< n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    //swap
                    int temp[] = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }
        List<int[]> list = new ArrayList();

        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size()-1)[1]>=intervals[i][0]) {
                int temp[] = new int [2];

                temp[0] = list.get(list.size()-1)[0];


                if(list.get(list.size()-1)[1]>=intervals[i][1]) {
                    temp[1] = list.get(list.size()-1)[1];

                } else {
                    temp[1] = intervals[i][1];

                }
                list.set(list.size()-1,temp);
            } else {
                list.add(intervals[i]);
            }
        }

        int [][] answer = new int [list.size()][2];
        for (int i = 0 ; i< list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length < 1) {
            int ann[][] = new int[1][2];
            ann[0] = newInterval;
            return ann;
        }

        int [][] intervalsNew = new int [intervals.length+1][2];
        int k=0;
        for (int [] temp : intervals) {
            intervalsNew[k++] = temp;
        }
        intervalsNew[k] = newInterval;
        intervalsNew[intervals.length] = newInterval;


        int n = intervalsNew.length;
        for (int i=0 ; i< n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intervalsNew[j][0] > intervalsNew[j + 1][0]) {
                    //swap
                    int temp[] = intervalsNew[j];
                    intervalsNew[j] = intervalsNew[j + 1];
                    intervalsNew[j + 1] = temp;
                }
            }
        }
        List<int[]> list = new ArrayList();

        list.add(intervalsNew[0]);
        for (int i = 1; i < intervalsNew.length; i++) {
            if (list.get(list.size()-1)[1]>=intervalsNew[i][0]) {
                int temp[] = new int [2];

                temp[0] = list.get(list.size()-1)[0];


                if(list.get(list.size()-1)[1]>=intervalsNew[i][1]) {
                    temp[1] = list.get(list.size()-1)[1];

                } else {
                    temp[1] = intervalsNew[i][1];

                }
                list.set(list.size()-1,temp);
            } else {
                list.add(intervalsNew[i]);
            }
        }

        int [][] answer = new int [list.size()][2];
        for (int i = 0 ; i< list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        int n = intervals.length;
        for (int i=0 ; i< n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    //swap
                    int temp[] = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }
        int count =0 ;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<intervals[i-1][1] && intervals[i][1]<=intervals[i+1][1]) {
                count++;
            }
        }
        return count;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int temp : nums) {
            if(map.get(temp)==(null)) {
                map.put(temp,1);
            } else {
                int val = map.get(temp);
                map.put(temp,++val);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        int []  ans = new int [k];
        for (int i=0 ;i<k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }


    public static void main(String[] args) {
        int [][] ip = {{1,5}};
        int i[] = {4,1,-1,2,-1,2,3};
        int jk [][]= {{1,2},{2,3},{3,4},{1,3}};
        OrderTraversal ot = new OrderTraversal();
        ot.topKFrequent(i,2);
    }

}
