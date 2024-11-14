class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        
        nums = sorted(set(nums), reverse=True)
        max_num = max(nums)
        dp = [0] * (max_num + 1)  

        for num in nums:
            dp[num] = 1  
            squared_num = num * num
            if squared_num <= max_num:
                dp[num] += dp[squared_num]

        ans = max(dp)
        return ans if ans >= 2 else -1  

