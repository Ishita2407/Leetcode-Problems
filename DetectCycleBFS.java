import java.util.*;

public class DetectCycleBFS{
    public static boolean checkCycle(ArrayList<ArrayList<Integer>> adj, boolean visited[], int parent[], int src){
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, -1));   // add starting node in queue, with its parent as -1
        visited[src] = true;   // visit the node

        while(!q.isEmpty()){
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // visit the adjacent nodes according to adjacency list
            for(Integer it : adj.get(node)){
                if(visited[it] == false){
                    q.add(new Node(it, node));
                    visited[it] = true;
                } else if(par != it){    // if curr node is not parent that means we have found another path
                    return true;  // cycle exists
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);  // initially no node is visited
        
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        for(int i = 0; i< V; i++){
            if(vis[i] == false){
                if(checkCycle(adj, vis, parent, i)){
                    return true;
                }
            }
        }
        return false;
    }
}