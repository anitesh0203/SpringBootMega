package bind75.graph;

import java.util.*;

public class Dfs {
    // use dfs to travel the graph and copy the nodes one by one
    public Node dfs(Node node) {
        Stack<Node> stack = new Stack<>();

        boolean visited[] = new boolean[100];
        //copy when you visit
        stack.push(node);
        visited[node.val] = true;
        System.out.println("Visiting== /t"+node.val);
        while(!stack.empty()) {
            Node current = stack.peek();
            Node neighbour = getNotVisitedNeighbour(current, visited);
            if(neighbour != null){
                visit(neighbour,visited);
                System.out.println("Visiting== /t"+neighbour.val);
                stack.push(neighbour);
            } else {
                stack.pop();
            }
        }
        return node;
    }


    private Node getNotVisitedNeighbour(Node current, boolean[] visited) {
        for (Node temp : current.neighbors) {
            if (!visited[temp.val]) {
                return temp;
            }
        }
        return null;
    }

    private void visit(Node node, boolean[] visited) {
        visited[node.val] = true;
        Node copy = new Node(node.val);
        for(Node neighbour: node.neighbors) {
            Node copied = neighbour;
            copy.neighbors.add(copied);
        }
    }



    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);

        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n2.neighbors.add(n6);

        n3.neighbors.add(n1);
        n3.neighbors.add(n2);
        n3.neighbors.add(n6);

        n4.neighbors.add(n1);
        n4.neighbors.add(n5);

        n5.neighbors.add(n4);

        n6.neighbors.add(n2);
        n6.neighbors.add(n3);


        Dfs dfs = new Dfs();
        dfs.dfs(n1);

    }

}
