import java.util.*;

public class Dijkstra {
    public static void dijkstra(int source, List<List<Node>> graph, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        
        dist[source] = 0; 
        pq.add(new Node(source, 0)); 
        
        while (!pq.isEmpty()) {
            Node current = pq.poll(); 
            
            for (Node neighbor : graph.get(current.node)) {
                int newDist = dist[current.node] + neighbor.distance; 
                
                if (newDist < dist[neighbor.node]) {
                    dist[neighbor.node] = newDist;
                    pq.add(new Node(neighbor.node, newDist));
                }
            }
        }
        
        System.out.println("Shortest distances from source node " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " - Distance: " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int n = 5; 
        List<List<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        graph.get(0).add(new Node(1, 2)); 
        graph.get(0).add(new Node(2, 4)); 
        graph.get(1).add(new Node(2, 1)); 
        graph.get(1).add(new Node(3, 7)); 
        graph.get(2).add(new Node(4, 3)); 
        graph.get(3).add(new Node(4, 1)); 
        
        int source = 0; 
        dijkstra(source, graph, n);
    }
}

class Node {
    int node;      
    int distance;  
    
    Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
