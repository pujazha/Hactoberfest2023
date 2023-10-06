import java.util.*;

public class DFS {
    private int V;
    private LinkedList<Integer> adjList[];

    @SuppressWarnings("unchecked")
    public DFS(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    public void dfs(int start) {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        visited[start] = true;
        stack.push(start);
        
        while (!stack.isEmpty()) {
            start = stack.pop();
            System.out.print(start + " ");
            
            Iterator<Integer> iterator = adjList[start].listIterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        DFS graph = new DFS(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();
        
        for (int i = 0; i < E; i++) {
            System.out.print("Enter edge " + (i + 1) + " (source destination): ");
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = scanner.nextInt();
        
        System.out.println("Depth First Traversal (starting from vertex " + startVertex + "):");
        graph.dfs(startVertex);

        scanner.close();
    }
}
