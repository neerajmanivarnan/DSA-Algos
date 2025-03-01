# recursive and memoized solution
# def count_ways(number,memory):
#     if number in memory:
#         return memory[number]
#     if number < 0 : 
#         return 0 
#
#     if number == 0:
#         return 1
#
#     total = 0 
#     for i in range(1,7):
#         total += count_ways(number - i,memory)
#
#     memory[number] = total
#     return total
#

MOD = (10**9) + 7
def count_ways(number):
    dp = [0] * (number+1)
    dp[0] = 1
    
    for i in range(1,number + 1):
        for j in range(1,7):
            if i - j >= 0: 
                dp[i] =  (dp[i] + dp[i-j]) % MOD

    return dp[number]



number = int(input())
print(count_ways(number))
