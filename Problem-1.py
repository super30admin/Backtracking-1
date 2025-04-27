'''
    Time Complexity: O(n)
    Space Complexity: O(n)
'''
class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, 0, [], target)
        return self.result
        
    def helper(self, candidates, i, path, target):
        # base case
        if target == 0:
            self.result.append(path[:])
            return
        
        if i == len(candidates) or target < 0:
            return

        # logic
        case0 = self.helper(candidates, i+1, path, target)

        path.append(candidates[i])
        case1 = self.helper(candidates, i, path, target - candidates[i])
        path.pop()