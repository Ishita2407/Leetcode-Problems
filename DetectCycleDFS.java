import java.util.*;

public class DetectCycleDFS{
    // Time complexity - O(N + 2E) + O(N)
    // Space complexity - O(N) + O(N) ~ O(N)
    public boolean dfs(int node, int parent, int visited[], ArrayList<ArrayList<Integer>> adj){
        // mark curr node as visited
        visited[node] = 1;

        // visit all the adjacent nodes
        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                if(dfs(adjNode, node, visited, adj) == true){
                    return true;
                
                } else if(adjNode != parent){ // if node is not parent and is marked that means cycle exists
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCycle(int V, ArrayList<ArrayList<Integer>> adj){
        int visited[] = new int[V];
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                if(dfs(i, -1, visited, adj) == true) return true;
            }
        }
        return false;
    }
}