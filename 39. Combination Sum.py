# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(N^(T/M​+1)) | N be the number of candidates, T be the target value, and M be the minimal value among the candidate
# Space Complexity : Average : O(T/M)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Didn't consider target <0 in base condition 
# and missed copying path value to result 

# 1:
class Solution:
    '''
    0/1 recursion with backtracking
    '''
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        path = []
        result = []
        result = self.helper(candidates, target, path, 0, result )
        return result

    def helper(self, candidates, target, path, index, result):
        if index >= len(candidates) or target < 0:
            return
        if target == 0:
            result.append(path.copy())
            return
        # not accept
        self.helper(candidates, target, path,    + 1, result)
        #accept
        path.append(candidates[index])
        self.helper(candidates, target - candidates[index], path, index, result)

        # backtracking
        path.pop()
        return result

# 2:
class Solution:
    '''
    - For Loop recursion based solution
    - mostly same as previous one
    - recursive case of when number no chose, covered by loop
    '''
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) < 0:
            return []
        result = []
        
        def helper(candidates, target, pivot, path):
            # base case
            if target < 0:
                return
            if target == 0:
                result.append(copy.deepcopy(path))
                return
            for i in range(pivot, len(candidates)):
                path.append(candidates[i])
                helper(candidates, target - candidates[i],i, path)
                path.pop()

        helper(candidates, target, 0, [])
        return result   