from collections import defaultdict


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


def dfs(graph,visited,root):
    if root in visited:
        return

    print(root)

    for neighbor in graph[root]:
        if neighbor not in visited:
            dfs(graph,visited,neighbor)

for u, v in edges:
    graph[u].append(v)
    graph[v].append(u)

visited = set()
graph  = (dict(graph))



dfs(graph,visited,1)

print("Number of connected components : {}".format(count))

