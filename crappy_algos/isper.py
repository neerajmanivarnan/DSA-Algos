import math

def isper(n):
    num = math.sqrt(n)
    if num*num == n:
        return True
    return False

print(isper(49))
print(isper(50))
