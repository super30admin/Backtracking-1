from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return []
        result = []

        def recurse(candidates, target, index, path):

            # base case
            if target< 0:
                return
            if target == 0:
                result.append(list(path))
                return
            for i in range(index, len(candidates)):
                path.append(candidates[i])
                recurse(candidates, target - candidates[i], i, path)
                path.pop()