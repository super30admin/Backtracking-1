"""
TC: O(2^T) T is the target value
SP: O(2^T) for creating deepcopies
"""

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        subset = []
        def dfs(i):
            if i >= len(candidates) or sum(subset) > target:
                return
            if sum(subset)==target:
                res.append(subset.copy())
                return
            subset.append(candidates[i])
            dfs(i)
            subset.pop()
            dfs(i+1)
        dfs(0)
        return res
