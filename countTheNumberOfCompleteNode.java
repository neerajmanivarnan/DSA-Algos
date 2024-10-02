import java.util.*;

class Solution {
    HashSet<Integer> visited = new HashSet<>();

    public int countCompleteComponents(int n, int[][] edges) {
        int count = 0;

        
        List<List<Integer>> graph = buildGraph(n, edges);

        
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                List<Integer> component = new ArrayList<>();
                if (exploreComponent(graph, i, component)) {
                    if (isCompleteComponent(component, graph)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    
    private boolean exploreComponent(List<List<Integer>> graph, int node, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        visited.add(node);
        queue.offer(node);
        component.add(node);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                    component.add(neighbor);
                }
            }
        }

        return true;
    }

    
    private boolean isCompleteComponent(List<Integer> component, List<List<Integer>> graph) {
        int size = component.size();
        for (int node : component) {
            
            if (graph.get(node).size() != size - 1) {
                return false;
            }
        }
        return true;
    }

    
    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
