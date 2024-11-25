"""

h = 4
w = 8

########
########
########
########

"""

def draw(h,w):
    if w > 0:
        print('#',end='')
        draw(h,w-1)
    elif w == 0 and h >0:
        print('\n')
        drawZZ

