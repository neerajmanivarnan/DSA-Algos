class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dict = {}

        for num in nums:
            if num not in dict:
                dict[num] = 0
            dict[num]+=1

        max_keys = []

        for i in range(k):
            max_key = max(dict,key=dict.get)
            dict.pop(max_key)
            max_keys.append(max_key)
        
        return max_keys
