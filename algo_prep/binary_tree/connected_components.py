from collections import defaultdict

# Sample n x 2 matrix (edges)
edges = [
    [1, 2],
    [2, 3],
    [3, 4],
    [4, 1],
    [2, 4],
    [5, 6],
    [6, 7],

]

graph = defaultdict(list)

def dfs(graph,root,visited):
    if root in visited:
        return  
   
    print(root)
    visited.add(root)

    for neighbor in graph[root]:
        if neighbor not in visited:
            dfs(graph,neighbor,visited)

for u, v in edges:
    graph[u].append(v)
    graph[v].append(u)

visited = set()
count = 0
graph  = (dict(graph))

for node in graph:
    if node not in visited:
        count+=1
        dfs(graph,node,visited)

print("Number of connected components : {}".format(count))
