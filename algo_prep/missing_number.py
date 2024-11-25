


def calculate_missing_number(n):
    sum_to_be = (n*(n+1))//2
    sum = 0
   
    string = input()
    numbers = string.split(' ')

    for number in numbers:
        sum+=int(number)

    return sum_to_be- sum


n = int(input())



print(calculate_missing_number(n))
