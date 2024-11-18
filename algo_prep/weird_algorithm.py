

def weird_algo(n):
    if n == 1:
        print(n)
        return
    else:
        if n%2 == 0:
            print("{} ".format(n),end  = '')
            weird_algo(n//2)
        else:
            print("{} ".format(n),end = '')
            weird_algo(n*3+1)


n = int(input())
weird_algo(n)


