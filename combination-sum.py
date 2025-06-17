# Time Complexity : O(N^target)
# Space Complexity : O(target)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def backtrack(remain, comb, start):
            if remain == 0:
                res.append(list(comb))
                return
            elif remain < 0:
                return
            for i in range(start, len(candidates)):
                comb.append(candidates[i])
                backtrack(remain - candidates[i], comb, i)
                comb.pop()
        backtrack(target, [], 0)
        return res
        