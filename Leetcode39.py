# Time Complexity  = O(2^n) Exponential time(not sure need help with time and space for this question)
# Space Complexity = O(2^n)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def backtrack(i,curr,total):
            #base case 
            if total == target:
                res.append(curr.copy())
                return
            if i >= len(candidates) or total > target: # If we go out of bound or total > target
                return
            curr.append(candidates[i]) # Action
            backtrack(i,curr,total + candidates[i])# i is same because we can choose duplicate,
            curr.pop() # Undo action
            backtrack(i+1,curr,total) # when we dont choose and move to next position
        backtrack(0,[],0)
        return res

