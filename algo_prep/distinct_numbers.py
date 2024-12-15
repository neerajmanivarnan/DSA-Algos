test_cases = int(input())

numbers = input()

arr = numbers.split(' ')

dict = {}
count = 0

for num in arr:
    if num not in dict:
        dict[num] = 1
        count+=1

print(count)


