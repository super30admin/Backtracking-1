# Time Complexity : O(2^(m+n))
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(target, idx, path):
            if target==0:
                result.append(path.copy())
                return 
            
            if target < 0 or idx == len(candidates):
                return 
            
            path.append(candidates[idx])
            helper(target-candidates[idx], idx, path)
            path.pop()

            helper(target, idx+1, path)
        
        helper(target, 0, [])
        return result
    

#Using pivot
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(target, pivot, path):
            if target==0:
                result.append(path.copy())
                return 
            
            if target < 0:
                return 
            
            for i in range(pivot, len(candidates)):
                li = path.copy()
                li.append(candidates[i])
                helper(target-candidates[i], i, li)
        
        helper(target, 0, [])
        return result