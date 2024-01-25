import java.util.*;
public class ShortestPathUGwithUnitWt{
    // BFS traversal + shortest path algorithm
    public int[] shortestPath(int edges[][], int n, int m, int src){
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        // Undirected graph have edges - bidirectional
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // Create distance arr
        int dist[] = new int[n];

        // Initialize all the distances to infinity or very large number
        for(int i = 0; i < n; i++){
            dist[i] = (int)1e9;
        }

        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        
        q.add(src);
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int it : adj.get(node)){
                if(dist[node] +  1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
}