# Time Complexity : O(2 ^ (m+n)) where m is the candidates length and n is the target
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We try all combinations starting from a pivot index.
# The loop represents both choices: picking i handles the choose case, and moving i forward handles the no-choose.
# After choosing a number, we recurse with a reduced target and backtrack to explore other options.

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        self.helper(candidates, target, 0, [])
        return self.res

    def helper(self, candidates, target, pivot, path):
        if target < 0 or pivot == len(candidates):
            return

        if target == 0:
            self.res.append(list(path))
            return

        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target - candidates[i], i, path)
            path.pop()
        