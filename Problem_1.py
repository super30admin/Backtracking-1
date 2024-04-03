'''
Time Compelxity - O(2^n)
Space Complexity - O(n) recrusive stack space.

Works on Leetcode
'''
class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, [],0, target)
        return self.result
    def helper(self,candidates, path, pivot, target):
        if target < 0:
            #return if the sum is exceeding the target
            return
        if target == 0:
            #When sum matches the target
            self.result.append(path[:])
            return 
        for i in range(pivot,len(candidates)):
            #choose not choose
            path.append(candidates[i])
            self.helper(candidates, path, i, target-candidates[i])
            path.pop()


        