
def count(string):
    max = 1
    current = 1 

    for i in range(1,len(string)):
        if string[i] == string[i- 1]:
            current += 1
        
            if current > max:
                max = current

        else:
            current = 1 

    return max

sttring = input()
if not sttring:
    print(0)
else:
    print(count(sttring))

        
