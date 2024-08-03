# Time = O(2**N)
# Space = O(N)

class Solution:
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return []
        self.recurse(candidates, target, 0, [])
        return self.result 
    def recurse(self, candidates, target, index, path):
        # base case 
        if target < 0 or index == len(candidates):
            return
        if target == 0:
            self.result.append(list(path))
            return
        for i in range(index, len(candidates)):
            #action
            path.append(candidates[i])
            # recurse
            self.recurse(candidates, target - candidates[i], i, path)
            # backtrack
            path.pop()

        