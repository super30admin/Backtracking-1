# Time Complexity : O(2^n (target/min(candidates))
# Space Complexity : O((target/min(candidates))
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Combination Sum

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, target, 0, [])
        return self.result
    
    def helper(self,candidates: List[int], target: int, i: int, path: List[int]):
        # base case
        if target == 0:
            self.result.append(path[:])
        if target < 0 or i == len(candidates):
            return 

        # logic
        # No Choose
        path.append(candidates[i])
        self.helper(candidates, target, i + 1, path)
        path.pop()
        # Choose
       
        self.helper(candidates, target - candidates[i], i, path)
        path.pop()
