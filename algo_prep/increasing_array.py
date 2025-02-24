
def sorting_bubble(array):
    moves = 0 
    for i in range(0,len(array)-1):
        for j in range(0,len(array)- i - 1):
            if int(array[j]) > int(array[j+1]):
                moves+=1
    
    return moves

size = int(input())

array_line =  input()

array = array_line.split(" ")
new = [int(num) for num in array]

for num in new:
    print("{} : {}".format(num,type(num)))
# print(sorting_bubble(array))

