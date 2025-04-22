# Time Complexity: O(2^m+n)
# Space Complexity: O(2^m+n)
# Does this code run on Leetcode: Yes
# Did you face any problems while coding this: No
from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return []
        result = []
        self.helper(candidates, target, result, 0, [])
        return result
    def helper(self, candidates, target, result, pivot, path):
        if target == 0:
            result.append(path[:])
        for i in range(pivot, len(candidates)):
            if candidates[i] <= target:
                # action
                path.append(candidates[i])
                # recurse
                self.helper(candidates, target-candidates[i], result, i, path)
                # backtrack
                path.pop()