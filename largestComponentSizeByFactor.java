import java.util.Map;
import java.util.List;
import java.util.HashSet;

public class largestComponentSizeByFactor {
    public static void main(String[] args) {
      
    } 
}


class Source {
  static HashSet<Integer> visited = new HashSet<>();
  public static int largestComponent(Map<Integer, List<Integer>> graph) {

    int largest = 0;

    for(int node : graph.keySet()){
      if(!visited.contains(node)){
        int currentSize = explore(graph,node);
        largest = currentSize > largest?currentSize:largest;
      }
    }
    
    return largest;
  }

  public static int explore(Map<Integer, List<Integer>> graph,Integer node){

      if(visited.contains(node)) return 0;

      visited.add(node);

     int size = 1;
    
      for(int neighbor:graph.get(node)){
        size += explore(graph,neighbor);
      }

    return size;
  }

  public static void run() {
    // this function behaves as `main()` for the 'run' command
    // you may sandbox in this function , but should not remove it
  }
}
