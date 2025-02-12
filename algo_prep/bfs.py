import heapq 
from collections import deque

# graph = {
#     'A': ['B', 'C'],
#     'B': ['A', 'D', 'E'],
#     'C': ['A', 'F'],
#     'D': ['B'],
#     'E': ['B'],
#     'F': ['C']
# }

graph_matrix = [
    [0, 1, 1, 0, 0],  # Node 0 is connected to 1, 2
    [1, 0, 0, 1, 1],  # Node 1 is connected to 0, 3, 4
    [1, 0, 0, 0, 0],  # Node 2 is connected to 0
    [0, 1, 0, 0, 0],  # Node 3 is connected to 1
    [0, 1, 0, 0, 0]   # Node 4 is connected to 1
]

 = [
    [0, 1, 1, 0, 0],  # Node 0 is connected to 1, 2
    [1, 0, 0, 1, 1],  # Node 1 is connected to 0, 3, 4
    [1, 0, 0, 0, 0],  # Node 2 is connected to 0
    [0, 1, 0, 0, 0],  # Node 3 is connected to 1
    [0, 1, 0, 0, 0]   # Node 4 is connected to 1
]

def convertMatrix(matrix):
    adjacency_list = {i: [] for i in range(len(matrix))}

    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if matrix[i][j] == 1:
                adjacency_list[i].append(j) 
    return adjacency_list
        

def bfs(graph,start):
    queue = deque([start])
    visited = set([start])

    while queue:
        node = queue.popleft()
        print(node, end = "->")

        for neighbor in graph[node]:
            if neighbor not in visited:
                queue.append(neighbor) 
                visited.add(neighbor)

graph = convertMatrix(graph_matrix)
print("---Actual adjacency list---")
print(graph)
print("---After BFS---")
bfs(graph,0)
