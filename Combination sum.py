#// Time Complexity : o(2^n)
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        path = []
        result = []

        def helper(candidates,target,pivot,path):
            if target == 0:
                result.append(path.copy())
            if target < 0:
                return
            for i in range(pivot,len(candidates)):
                path.append(candidates[i])
                helper(candidates,target-candidates[i],i,path)
                path.pop()
        
        helper(candidates,target,0,path)
        return result
            
    
# Approach:
# 1. We will use backtracking to solve this problem. We will use a helper function to solve
# this problem.
# 2. We will pass the candidates, target, pivot and path as arguments to the helper function.
# 3. We will check if the target is 0, if yes, we will append the path
# 4. We will check if the target is less than 0, if yes, we will return
