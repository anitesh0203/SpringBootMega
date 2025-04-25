package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NRP {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            List<Node> list = new ArrayList<>();
            while(!queue.isEmpty()) {
                list.add(queue.poll());
            }
            if(list.size()>1) {
                list.get(0).next = list.get(1);
                for (int j = list.size()-2; j >=1;j--) {
                    list.get(j).next = list.get(j+1);
                }
            }
            for (int i=0 ;i<list.size(); i++) {
                if(null != list.get(i).left)
                    queue.add(list.get(i).left);
                if(null != list.get(i).right)
                    queue.add(list.get(i).right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.left=n2;
        n1.right=n3;
        NRP nrp = new NRP();
        System.out.println(nrp.connect(n1));
    }
}