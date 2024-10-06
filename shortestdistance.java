import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayList;

class res{
  String node;
  int distance;

  res(String node, int distance){
      this.node =  node;
      this.distance = distance;
  }
}

class Source {
  public static int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
    HashMap<String,List<String>> graph = buildGraph(edges);
    int distance;

    Queue<res> q = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();
    visited.add(nodeA);
    q.offer(new res(nodeA,0));

    while(!q.isEmpty()){

      res current = q.poll();

      if(current.node.equals(nodeB) ) return current.distance;

      for(String nei:graph.get(current.node)){
        res c = new res(nei,current.distance+1);
        if(!visited.contains(nei)){
          visited.add(nei);
          q.offer(c);
          
        }
      }
      
      
    }

    return -1;
    
  }

  public static HashMap<String, List<String>> buildGraph(List<List<String>> edges) {
    HashMap<String, List<String>> graph = new HashMap<>();


    for (List<String> edge : edges) {
      String nodeA = edge.get(0);
      String nodeB = edge.get(1);

      
      graph.putIfAbsent(nodeA, new ArrayList<>());
      graph.get(nodeA).add(nodeB);

      
      graph.putIfAbsent(nodeB, new ArrayList<>());
      graph.get(nodeB).add(nodeA);
    }
    return graph;
  }


}
