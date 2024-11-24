class Solution:
    def minimumMountainRemovals(self, nums):
        n = len(nums)
        left = [1] * n  
        right = [1] * n  

        
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    left[i] = max(left[i], left[j] + 1)

        
        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                if nums[i] > nums[j]:
                    right[i] = max(right[i], right[j] + 1)

        max_mountain_length = 0

        
        for i in range(n):
            if left[i] > 1 and right[i] > 1:  
                max_mountain_length = max(max_mountain_length, left[i] + right[i] - 1)

        
        return n - max_mountain_length

