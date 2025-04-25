//package bind75;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//
//public class CourseSchedule {
//
//    List<LinkedList<Integer>> adjList;
//    public boolean ans = true;
//    // intialize the list
//    public void intialise(int v) {
//        adjList = new ArrayList<>();
//        for (int i=0 ; i<v; i++) {
//            //assuming that nodes starts from 0 we can track it
//            LinkedList<Integer> linkedList = new LinkedList<>();
//            adjList.add(linkedList);
//        }
//    }
//    // add an edge
//    public void addEdge(int [][] preReq) {
//        for (int i=0 ;i<preReq.length;i++) {
//            int edge [] = preReq[i];
//            adjList.get(edge[0]).add(edge[1]);
//        }
//    }
//
//    // detect cycles DFS traversal should not return same node.
//    void detectCycle(int v, boolean visited[]) {
//        if (visited[v]) {
//            ans = false;
//            return;
//        }
//        visited[v] = true;
//
//        Iterator<Integer> i = adjList.get(v).listIterator();
//        while (i.hasNext()) {
//            int n = i.next();
//            detectCycle(n, visited);
//        }
//    }
//
//    public boolean detectCycle_BFS() {
//
//    }
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        intialise(numCourses);
//        boolean visited[] = new boolean[numCourses];
//        //add edges
//        addEdge(prerequisites);
//        detectCycle(0, visited);
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        int[][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
//        CourseSchedule courseSchedule = new CourseSchedule();
//        boolean ans = courseSchedule.canFinish(20,prerequisites);
//        System.out.println(ans);
//    }
//}
