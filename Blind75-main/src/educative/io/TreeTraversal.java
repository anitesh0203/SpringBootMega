package educative.io;

import java.util.Arrays;
import java.util.List;

public class TreeTraversal {
    public static void printNodes(BinaryTreeNode root) {
        if (root==null) {
            return;
        }
        if(root.left != null) {
            printNodes(root.left);
        }
        System.out.println(root.data);

        if(root.right != null) {
            printNodes(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(100);
        BinaryTreeNode node1 = new BinaryTreeNode(50);
        BinaryTreeNode node2 = new BinaryTreeNode(25);
        BinaryTreeNode node3 = new BinaryTreeNode(125);
        BinaryTreeNode node4 = new BinaryTreeNode(200);
        BinaryTreeNode node5 = new BinaryTreeNode(350);

        root.left = node1;
        root.right = node4;

        node1.left = node2;

        node4.right = node5;
        node4.left = node3;

        printNodes(root);



    }
}
