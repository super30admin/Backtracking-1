# Problem 1 : Combination Sum
# Time Complexity : O(n^t) where n is the number of candidates and t is the target
# Space Complexity : O(target)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # if the lenght of the candidates is zero then return empty list
        if len(candidates) == 0:
            return []
        # define the result variable for storing the list of the combination of candidates whose sum is target
        result = []

        # recursive function 
        def helper(candidates: List[int], result: List[List[int]], current: List[int], target: int, index: int) -> None:
            # base case, if the target is zero then append the copy of the current to the result
            if target == 0:
                result.append(current.copy())
            # loop from the index to length of the candidates
            for i in range(index, len(candidates)):
                # if the value of element at ith position of candidates is less than the target
                if candidates[i] <= target:
                    # add the value to the current list of candidates
                    current.append(candidates[i])
                    # call helper function with target as target-candidates[i] and pivot value as i
                    # since the numbers can be repeated
                    helper(candidates, result, current, target-candidates[i], i)
                    # backtracking ie. removing the last element from the current list
                    current.pop()
        # call helper function with empty current list, pivot element as 0
        helper(candidates, result, [], target, 0)
        return result