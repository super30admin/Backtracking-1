## Problem1 
'''Combination Sum (https://leetcode.com/problems/combination-sum/) '''

'''
TC = O(2^t) = choose or no choose case , t = target
SC = O(T + C + L) , target + combination + len of each combination
Approach implemented = Backtracking /DFS
'''

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def backtrack(start, current, total):
            if total == target:
                result.append(current[:])
            if total > target:
                return
            for i in range(start, len(candidates)):
                current.append(candidates[i])
                backtrack(i, current, total + candidates[i])
                current.pop()

        backtrack(0, [], 0)
        return result    
