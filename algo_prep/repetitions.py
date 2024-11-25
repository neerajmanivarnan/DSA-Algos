

def repetitions_calculate(string):
    count = 1
    max_count = 1 
    for i in range(1,len(string)):
        if string[i] == string[i-1]:
            count += 1 
            if count > max_count:
                max_count = count
        else:
            count = 1

    return max_count



string = input()
print(repetitions_calculate(string))


