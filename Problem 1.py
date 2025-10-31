class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def helper(i, sub, cursum):
            nonlocal res
            if cursum > target or i >= len(candidates):
                return
            if cursum==target:
                res.append(sub.copy())

            for c in range(i, len(candidates)):
                sub.append(candidates[c])
                helper(c, sub, cursum+candidates[c])
                sub.pop()
        helper(0, [], 0)
        return res
