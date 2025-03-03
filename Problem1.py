# 0-1 recursion with backtracking
# TC: Exponential
# SC: Exponential

class Solution:
    res = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return []
        path = []
        self.res = []
        self.dfs(candidates, target, 0, path)
        return self.res

    def dfs(self,candidates, target, index, path):
        if index >= len(candidates) or target < 0:
            return
        if target == 0:
            self.res.append(path[:])
            return
            # Zero
        self.dfs(candidates, target, index + 1, path)

        path.append(candidates[index])
        self.dfs(candidates, target - candidates[index], index, path)
        path.pop()
