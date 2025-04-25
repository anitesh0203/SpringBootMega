package bind75.graph;

import java.util.*;

public class ClonedGraph {
    public Node cloneGraph(Node node) {
        Map<Node,Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            for(Node neighbor: curr.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                map.get(curr).neighbors.add(neighbor);
            }
        }
        return map.get(node);
    }

}
