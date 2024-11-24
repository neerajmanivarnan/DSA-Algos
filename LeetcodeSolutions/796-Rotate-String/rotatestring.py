# my solution 
class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        i = 0 
        n = len(s)

        if len(s)!= len(goal):
            return False

        new = s
        current = s
        while i < n:
            new = current[1:] + current[0]
            current = new
            if new == goal:
                return True
            i+=1
            new=""

        return False
            
# # optimised solution        
# class Solution:
#     def rotateString(self, s: str, goal: str) -> bool:
#         if len(s) != len(goal):
#             return False
#
#         return goal in s+s
#
