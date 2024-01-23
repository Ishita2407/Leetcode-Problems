import java.util.*;
public class TopologicalSort{
    // Dfs traversal
    // Time complexity - O(V + E) + O(V) : O(V) because there can be atmost V components 
    // Space complexity - O(N)
    public static void dfs(int node, int visited[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;

        // Traverse all the adjacent nodes
        for(int it : adj.get(node)){
            // make dfs calls for all the unvisited nodes
            if(visited[it] == 0){
                dfs(it, visited, st,adj);
            }
        }
        // add the node in the stack
        st.push(node);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int visited[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();

        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i, visited, st, adj);
            }
        }
        int ans[] = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
}