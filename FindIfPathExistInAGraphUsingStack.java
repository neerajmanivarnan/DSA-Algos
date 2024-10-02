import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();

        st.push(source);
        visited[source] = true;

        while (!st.isEmpty()) {
            int current = st.pop();

            
            if (current == destination) return true;

            
            for (int nei : graph.get(current)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    st.push(nei);
                }
            }
        }

        return false; 
    }

}


