import java.util.*;

public class AlienDictionary{
    // Topological sort concept
    // Time complexity - O(N * len) + O(K + E)
    // Space complexity - O(4K) 
    public String findOrder(String dict[], int N, int K){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());

            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        String ans = "";
        for(int it : topo){
            ans = ans + (char)(it + (int)('a'));
        }

        return ans;
    }
    public List<Integer> topoSort(int V, List<List<Integer>> adj){
        int indegree[] = new int[V];

        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0) q.add(it);
            }
        }
        return topo;
    }
}