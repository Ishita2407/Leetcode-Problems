import java.util.*;
public class KahnsAlgo{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        // BFS traversal with modifications
        // Time complexity - O(V + E)
        // Space complexity - O(N) + O(N)

        int indegree[] = new int[V];

        // Calculate the indegree for all the nodes
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){ // atleast 1 element will have indegree 0, add it in queue
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++] = node;

            // if a node has indegree 0 , add it in the queue
            // Once node is added in topo sort , reduce its indegree by 1
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
}