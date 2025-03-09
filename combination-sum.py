# Time O(2^(m+n)) m: target, n : length of candidates
# Space O(m+n)
import copy
class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.dfs(candidates, target, 0, [])
        return self.result

    def dfs(self, candidates: List[int], target: int, i: int, path: List[int]) -> None:
        if target < 0 or i >= len(candidates): return
        if target == 0:
            self.result.append(copy.deepcopy(path))
            return
        # Not choose
        self.dfs(candidates, target, i+1, path)

        # Choose
        path.append(candidates[i])
        self.dfs(candidates, target - candidates[i], i, path)
        path.pop() 


# Time O(2^(m+n)) m: target, n : length of candidates
# Space O(m+n)
import copy
class Solution:
    def __init__(self):
        self.result = []
        self.n = 0

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.n = len(candidates)
        for i in range(self.n):
            self.dfs(candidates, target - candidates[i], i, [candidates[i]])
        return self.result

    def dfs(self, candidates: List[int], target: int, pivot: int, path: List[int]) -> None:
        if target < 0 or pivot >= len(candidates): return
        if target == 0:
            self.result.append(copy.deepcopy(path))
            return
        
        for i in range(pivot, self.n):
            path.append(candidates[i])
            self.dfs(candidates, target - candidates[i], i, path)
            path.pop()

# All Permutations
# Time O(2^(m+n)) m: target, n : length of candidates
# Space O(m+n)
import copy
class Solution:
    def __init__(self):
        self.result = []
        self.n = 0

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.n = len(candidates)
        for i in range(self.n):
            self.dfs(candidates, target - candidates[i], i, [candidates[i]])
        return self.result

    def dfs(self, candidates: List[int], target: int, pivot: int, path: List[int]) -> None:
        if target < 0 or pivot >= len(candidates): return
        if target == 0:
            self.result.append(copy.deepcopy(path))
            return
        
        for i in range(self.n):
            path.append(candidates[i])
            self.dfs(candidates, target - candidates[i], i, path)
            path.pop()
