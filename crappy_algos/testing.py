from heapq import heappop, heappush

def k_largest(nums, k):
    # fill in
    k_lgst_nums = []
    max_heap = []
    for num in nums:
      heappush(max_heap,-num)

    for i in range(k):
      ele = -heappop(max_heap)
      k_lgst_nums.append(ele)
      
    return k_lgst_nums


array = [5, 16, 7, 9, -1, 4, 3, 11, 2]

print(k_largest(array,3))
