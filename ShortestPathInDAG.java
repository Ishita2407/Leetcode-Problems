import java.util.*;
public class ShortestPathInDAG{
    // Time complexity - O(N + M)
    // Space complexity - O(N) + O(N) + O(N) + O(N + 2M)
    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st){
        // DFS implementation

        vis[node] = 1; // mark visited

        // Traverse for all the adjacent nodes
        for(int i = 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if(vis[i] == 0){
                topoSort(i, adj, vis, st);
            }
        }
        st.add(node);  // add the node in the stack
    }

    public int[] shortestPath(int n, int m, int edges[][]){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int u = edges[i][0];  // src
            int v = edges[i][1]; // dest
            int wt = edges[i][2]; // weight
            adj.get(u).add(new Pair(v, wt));  // stores dest and weight of the edge
        }
        int vis[] = new int[n]; // visited arr

        Stack<Integer> st = new Stack<>(); // stack

        // check for all the components
        for(int i = 0; i < n; i++){
            // for all the unvisited nodes call the topological sort
            if(vis[i] == 0){
                topoSort(i, adj, vis, st);
            }
        }

        // distance arr
        int dist[] = new int[n];
        // initialize all the values with infinity initially
        for (int i = 0; i < n; i++) {
            dist[i] = (int)(1e9);
        }

        
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            // traverse for all the adjacent nodes
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}