#include <iostream>
#include <vector>
#include <limits.h>

struct Edge {
    int src, dest, weight;
};

class Graph {
    int V, E;
    std::vector<Edge> edges;

public:
    Graph(int V, int E);
    void addEdge(int src, int dest, int weight);
    void bellmanFord(int src);
};

Graph::Graph(int V, int E) : V(V), E(E) {}

void Graph::addEdge(int src, int dest, int weight) {
    edges.push_back({src, dest, weight});
}

void Graph::bellmanFord(int src) {
    std::vector<int> dist(V, INT_MAX);
    dist[src] = 0;

    // Relax all edges V-1 times
    for (int i = 0; i < V - 1; ++i) {
        for (const auto &edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;
            if (dist[u] != INT_MAX && dist[u] + w < dist[v])
                dist[v] = dist[u] + w;
        }
    }

    // Check for negative-weight cycles
    for (const auto &edge : edges) {
        int u = edge.src;
        int v = edge.dest;
        int w = edge.weight;
        if (dist[u] != INT_MAX && dist[u] + w < dist[v]) {
            std::cerr << "Graph contains a negative-weight cycle" << std::endl;
            return;
        }
    }

    // Print the distances
    for (int i = 0; i < V; ++i)
        std::cout << "Distance from source to vertex " << i << " is " << dist[i] << std::endl;
}

int main() {
    int V = 5;  // Number of vertices
    int E = 8;  // Number of edges

    Graph graph(V, E);
    graph.addEdge(0, 1, -1);
    graph.addEdge(0, 2, 4);
    graph.addEdge(1, 2, 3);
    graph.addEdge(1, 3, 2);
    graph.addEdge(1, 4, 2);
    graph.addEdge(3, 2, 5);
    graph.addEdge(3, 1, 1);
    graph.addEdge(4, 3, -3);

    int source = 0;  // Source vertex

    graph.bellmanFord(source);

    return 0;
}
