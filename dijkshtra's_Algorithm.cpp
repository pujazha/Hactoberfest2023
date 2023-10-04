#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max();

// Class to represent edges in the graph
class Edge {
public:
    int destination;
    int weight;

    Edge(int dest, int w) : destination(dest), weight(w) {}
};

// Class to represent the graph using an adjacency list
class Graph {
public:
    int numVertices;
    vector<vector<Edge>> adjList;

    Graph(int V) : numVertices(V), adjList(V) {}

    // Add an edge to the graph
    void addEdge(int src, int dest, int weight) {
        adjList[src].emplace_back(dest, weight);
        adjList[dest].emplace_back(src, weight);  // For undirected graph
    }
};

void dijkstra(Graph& graph, int startVertex) {
    int numVertices = graph.numVertices;
    vector<int> dist(numVertices, INF); // Initialize distances with infinity
    dist[startVertex] = 0; // Distance from the source vertex to itself is 0

    // Priority queue to store vertices and their distances
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    pq.push(make_pair(0, startVertex));

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        // Visit each neighbor of u and relax the edges
        for (const Edge& edge : graph.adjList[u]) {
            int v = edge.destination;
            int weight = edge.weight;

            if (dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                pq.push(make_pair(dist[v], v));
            }
        }
    }

    // Print the shortest distances from the startVertex
    for (int i = 0; i < numVertices; ++i) {
        cout << "Shortest distance from " << startVertex << " to " << i << " is: " << dist[i] << endl;
    }
}

int main() {
    Graph graph(6); // Example graph with 6 vertices

    // Adding edges and their weights
    graph.addEdge(0, 1, 5);
    graph.addEdge(0, 2, 1);
    graph.addEdge(1, 3, 3);
    graph.addEdge(1, 4, 7);
    graph.addEdge(2, 4, 1);
    graph.addEdge(2, 5, 5);

    int startVertex = 0; // Starting vertex for Dijkstra's algorithm

    cout << "Dijkstra's Algorithm:" << endl;
    dijkstra(graph, startVertex);

    return 0;
}
