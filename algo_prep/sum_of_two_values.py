

def two_sum(input_list,x):
    dic = {}

    for i in range(0,len(input_list)):
        compliment = x - input_list[i]
        if compliment in dic:
            return [i,dic[compliment]]
        dic[input_list[i]] = i


first = input()

first_io_array = first.split()
length = first_io_array[0]
sum = first_io_array[1]

second = input()
arr = second.split()

result_array = two_sum(arr,sum)

if result_array:
    print(result_array)
else:
    print("IMPOSSIBLE")

