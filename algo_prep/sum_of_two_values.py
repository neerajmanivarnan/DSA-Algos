

def two_sum(input_list,x):
    dic = {}

    for i in range(0,len(input_list)):
        compliment = x - input_list[i]
        if compliment in dic:
            return [i,dic[compliment]]
        dic[input_list[i]] = i



first_io = input()
first_io_array = first_io.split(' ') 

n = first_io_array[0]
x = first_io_array[1]

input_array = input()

input_list = input_array.split(' ')

for num in input_list:
    num = int(num)

new_list = (two_sum(input_list,x))

for num in new_list:
    num += 1


string_return = ' '.join(new_list)
