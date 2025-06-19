"""
Problem: combinationSum
Approach: Choose candidates[i] and maybe choose again else never use again. Can be solved using recursion.
t.c. => O(2^(target + n)) where n = len(candidates)
s.c. => O(target) for recursion stack
"""
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        path = []
        n = len(candidates)
        def helper(index, target):
            if target == 0:
                res.append(path.copy())
                return 
            if index == n:
                return 
            if target < 0:
                return

            helper(index + 1, target)

            path.append(candidates[index])
            helper(index, target - candidates[index])
            path.pop()
            
            
        helper(0, target)
        return res