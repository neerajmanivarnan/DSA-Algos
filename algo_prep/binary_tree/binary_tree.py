class Node:
    def __init__(self,val):
        self.val = val
        self.right = None
        self.left = None


a = Node(340)
b = Node(401)
c = Node(278)
d = Node(185)
e = Node(500)
f = Node(831)

a.left = b 
a.right = c 
b.left = d 
b.right = e 
c.right = f

def custon():
    if not root:
        return 

#  recursive approach
def dfs_recursive(root):
    if not root:
        return

    print(root.val,end = "->")

    if root.left:
        dfs_recursive(root.left)

    if root.right:
        dfs_recursive(root.right)

# dfs(a)

def dfs_iterative(root):
    if not root:
        return
    
    stack  = [] 
    stack.append(root)
    max = 0 

    while stack:
        current = stack.pop()

        if current.val > max:
            max = current.val

        if current.right:
            stack.append(current.right)
        
        if current.left:
            stack.append(current.left)

    print(max)

print("recursive approach : ",end = " ")
dfs_recursive(a)

print()

print("iterative approach : ",end = " ")
dfs_iterative(a)

print()
