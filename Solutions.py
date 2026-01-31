## Problem1 Combination Sum (https://leetcode.com/problems/combination-sum/)
## Time Complexity : O(n * 2^(m+n))
## Space Complexity : O(n^2)

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ## backtracking approach:
        ## - I cab either choose or not choose 
        ## - If choosing adding it to the sum and recurssing
        ## - not choosing and recurssing again. 

        output = []
        def helper(idx,sm,path):
            ## boundary  conditions - if out of  bounds
            if sm > target or idx >= len(candidates):
                return 
            ## base condition  -- if sum reached the target
            if sm == target:
                output.append(path[:])
                return

            path.append(candidates[idx])
            helper(idx,sm+candidates[idx],path)
            path.pop()
            helper(idx+1,sm,path)
        
        helper(0,0,[])
        return output





## Problem2 Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)
## Time Complexity :
## Space Complexity : 

