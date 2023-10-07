#include <iostream>
#include <vector>
#include <algorithm>

struct Edge {
    int src, dest, weight;
};

class Graph {
private:
    int V; // Number of vertices
    std::vector<Edge> edges; // Edges of the graph

public:
    Graph(int V);
    void addEdge(int src, int dest, int weight);
    void kruskalMST();
};

Graph::Graph(int V) : V(V) {}

void Graph::addEdge(int src, int dest, int weight) {
    edges.push_back({src, dest, weight});
}

bool compareEdges(Edge a, Edge b) {
    return a.weight < b.weight;
}

void Graph::kruskalMST() {
    // Sort edges by weight in non-decreasing order
    std::sort(edges.begin(), edges.end(), compareEdges);

    // Parent array for disjoint set (to detect cycles)
    std::vector<int> parent(V, -1);

    std::cout << "Minimum Spanning Tree using Kruskal's algorithm:\n";
    for (const auto &edge : edges) {
        int u = edge.src;
        int v = edge.dest;
        int weight = edge.weight;

        int uParent = u;
        int vParent = v;

        while (parent[uParent] != -1)
            uParent = parent[uParent];

        while (parent[vParent] != -1)
            vParent = parent[vParent];

        if (uParent != vParent) {
            std::cout << u << " - " << v << " (weight: " << weight << ")\n";
            parent[vParent] = uParent; // Union
        }
    }
}

int main() {
    Graph graph(5); // Graph with 5 vertices

    // Adding edges (src, dest, weight)
    graph.addEdge(0, 1, 2);
    graph.addEdge(0, 3, 1);
    graph.addEdge(1, 2, 3);
    graph.addEdge(1, 3, 2);
    graph.addEdge(2, 3, 5);
    graph.addEdge(2, 4, 4);
    graph.addEdge(3, 4, 7);

    graph.kruskalMST();

    return 0;
}
