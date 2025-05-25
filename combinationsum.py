# approach: exhaustive recurssion(pick/skip)
# TC: O(2^(m+n)), branching at each step and unlimited reuse
# SC:O(T)(recurssion) + O(k*L) (resultant array)
from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def helper(candidates, target, i, path):
            # base case
            if target < 0 or i == len(candidates):
                return

            if target == 0:
                result.append(path[:])
                return

            # no choose
            helper(candidates, target, i + 1, path)

            # choose
            path.append(candidates[i])
            helper(candidates, target - candidates[i], i, path)
            path.pop()

        result = []
        path = []
        helper(candidates, target, 0, path)
        return result

    # Approach: For-loop based (pivot style)
    # TC: O(2^(m+n)), branching at each step and unlimited reuse
    # SC:O(T)(recurssion) + O(k*L) (resultant array)
    def combinationSum_pivot(
        self, candidates: List[int], target: int
    ) -> List[List[int]]:
        def helper2(candidates, target, pivot, path):
            if target < 0:
                return
            if target == 0:
                result2.append(path[:])
                return
            for i in range(pivot, len(candidates)):
                path.append(candidates[i])
                helper2(candidates, target - candidates[i], i, path)
                path.pop()

        result2 = []
        helper2(candidates, target, 0, [])
        return result2


sol = Solution()
array = [2, 2, 3, 1, 6]
print(sol.combinationSum(array, 7))
print(sol.combinationSum_pivot(array, 7))
