import heapq

test_cases = int(input())

stack = []
max_heap = [] 

for i in range(test_cases):
    queries = int(input())
    result = []
    
    for j in range(queries):
        instruction = input()
        if instruction.startswith("A"):
            number = int(instruction[2:])
            stack.append(number)
            heapq.heappush(max_heap,-1 * number)
            heapq.heapify(max_heap)

        elif instruction.startswith("R"):
            number_max = stack.pop()
            heapq.heapify(max_heap)
        elif instruction.startswith("Q"):
            cur = -1  * heapq.heappop(max_heap)
            heapq.heapify(max_heap)
            result.append(cur)
    
    print("Case {}".format(i+1))
    for num in result:
        print(num)
            

