package practice;

import java.util.HashMap;
import java.util.Map;

public class CopyNode {

    public Node copyRandomList(Node head) {
        // take the head
        Node copy = head;
        //insert the fake nodes in between
        while (copy != null) {

            Node  node = new Node(copy.val);
            node.next = copy.next;
            copy.next = node;
            copy = copy.next.next;

        }
        //copy the elements random nos
        Node janam = head;
        while (janam !=null) {
            janam.next.random = (janam.random!=null)?janam.random.next:null;
            janam = janam.next.next;
        }

        // deassciation
        Node nisar = head;
        Node and = head.next;
        Node ans = head.next;
        while(nisar != null) {
            nisar.next = nisar.next.next;
            and.next = and.next!=null?and.next.next:null;
            nisar=nisar.next;
            and = and.next;
        }
        return ans;
    }



    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n1.random = n3;
        n3.random = n2;
        CopyNode copyNode = new CopyNode();
        copyNode.copyRandomList(n1);
    }
    static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
