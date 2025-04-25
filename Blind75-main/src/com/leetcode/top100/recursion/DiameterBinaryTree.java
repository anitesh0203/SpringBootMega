package com.leetcode.top100.recursion;

import org.w3c.dom.Node;

public class DiameterBinaryTree {
    Node root;

    static class  Node {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public int findDiameter(Node node, int max) {
        // base condition when root hits null.
        if(node==null) {
            return 0;
        }
        //hypothesis : find length of left subtree
        int l = findDiameter(node.left, max);
        //hypothesis : find length of right subtree
        int r = findDiameter(node.right, max);

        //assume that this node just gives the best from its child to parent node.
        int temp = Math.max(l,r)+1;
        //find max from the node assuming reached root
        int ans = Math.max(temp, 1+l+r);
        // final max answer computed from all nodes
        max = Math.max(max,ans);
        return max;
    }

    public static void main(String[] args) {
        // creating a binary tree and entering the nodes
        DiameterBinaryTree tree = new DiameterBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Function Call
        System.out.println(
                "The diameter of given binary tree is : "
                        + tree.findDiameter(tree.root, -9999));
    }
}
