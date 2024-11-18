
def count_ways(n,memo = None):
    if memo is None:
        memo = {}
    if n == 0:
        return 1
    if n < 0:
        return 0

    if n in memo:
        return memo[n]

    memo[n] = (count_ways(n-1) + count_ways(n-2) + count_ways(n-3) + count_ways(n-4) + count_ways(n-5) + count_ways(n-6))
    return memo[n]

n = int(input())

print(count_ways(n))
