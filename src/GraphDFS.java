import java.util.ArrayList;

public class GraphDFS {

    public static void runDFS(ArrayList<Integer>[] graph, int startNode) {
        if (graph == null || graph.length == 0) return;

        boolean[] visited = new boolean[graph.length];
        dfsRecursive(graph, startNode, visited);
    }

    private static void dfsRecursive(ArrayList<Integer>[] graph, int currentNode, boolean[] visited) {

        visited[currentNode] = true;

        for (int neighbor : graph[currentNode]) {

            if (!visited[neighbor]) {
                dfsRecursive(graph, neighbor, visited);
            }
        }
    }
}