
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

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        
        q.offer(source);
        visited.add(source);

        while (!q.isEmpty()) {
            int current = q.poll();

            
            if (current == destination) return true;

            
            for (int nei : graph.get(current)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.offer(nei);
                }
            }
        }

        return false; 
    }
}

