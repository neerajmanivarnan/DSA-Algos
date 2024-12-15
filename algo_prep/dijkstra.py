import heapq

def dijkstra(graph, source):
    n = len(graph)
    
    dist = [float('inf')] * n
    dist[source] = 0  
    
    pq = [(0, source)]  
    
    while pq:
        current_dist, current_node = heapq.heappop(pq)
        
        if current_dist > dist[current_node]:
            continue
        
        for neighbor, weight in graph[current_node]:
            new_dist = current_dist + weight
            
            if new_dist < dist[neighbor]:
                dist[neighbor] = new_dist
                heapq.heappush(pq, (new_dist, neighbor))
    
    return dist

if __name__ == "__main__":
    graph = {
        0: [(1, 2), (2, 4)],  
        1: [(2, 1), (3, 7)],  
        2: [(4, 3)],          
        3: [(4, 1)],          
        4: []                 
    }
    
    source = 0
    shortest_distances = dijkstra(graph, source)
    print(f"Shortest distances from node {source}:")
    for i, d in enumerate(shortest_distances):
        print(f"Node {i} - Distance: {d}")
