package greedy_and_dynamic_programming;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int v;
    int cost;

    public Pair(int v, int c) {
        this.v = v;
        cost = c;
    }

    @Override
    public int compareTo(Pair p2) {
        return this.cost - p2.cost;
    }
}

class WeightedGraph {
    int v;
    ArrayList<ArrayList<HashMap<Integer, Integer>>> adj;

    WeightedGraph(int v) {
        this.v = v;
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new HashMap<>());
        adj.get(u).get(adj.get(u).size() - 1).put(v, weight);
        adj.get(v).add(new HashMap<>());
        adj.get(v).get(adj.get(v).size() - 1).put(u, weight);
    }
}

class Prims {
    static int spanningTree(int v, ArrayList<ArrayList<HashMap<Integer, Integer>>> adj) {
        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int ans = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.remove();
            int u = cur.v;
            if (visited[u]) {
                continue;
            }
            ans += cur.cost;
            visited[u] = true;
            ArrayList<HashMap<Integer, Integer>> neighbours = adj.get(u);
            for (HashMap<Integer, Integer> map : neighbours) {
                for (int vertex : map.keySet()) {
                    int cost = map.get(vertex);
                    if (!visited[vertex]) {
                        pq.add(new Pair(vertex, cost));
                    }
                }
            }
        }
        return ans;
    }
}

public class Prblm2 {
    public static void main(String[] args) {
        int v = 8;
        WeightedGraph graph = new WeightedGraph(v);
        graph.addEdge(0, 1, 25);
        graph.addEdge(0, 5, 5);
        graph.addEdge(1, 2, 12);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 16);
        graph.addEdge(3, 6, 14);
        graph.addEdge(4, 5, 20);
        graph.addEdge(6, 4, 18);
        graph.addEdge(1, 0, 25);
        graph.addEdge(5, 0, 5);
        graph.addEdge(2, 1, 12);
        graph.addEdge(3, 2, 8);
        graph.addEdge(4, 3, 16);
        graph.addEdge(6, 3, 14);
        graph.addEdge(5, 4, 20);
        graph.addEdge(4, 6, 18);

        ArrayList<ArrayList<HashMap<Integer, Integer>>> adj = graph.adj;
        System.out.println(Prims.spanningTree(v, adj));
    }
}
