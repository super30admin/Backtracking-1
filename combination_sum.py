class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        result = []
        n = len(candidates)


        def summation(candidates, idx, n, val, path):
             if val == 0:
                 result.append(list(path))
                 return # dont miss the return here
             if val < 0 or idx == n:
                 return
            
             for i in range(idx, n):
                 # action
                 path.append(candidates[i])
                 #recurse
                 summation(candidates, i, n, val - candidates[i], path) 
                 # backtrack 
                 path.pop()      
             # case1 = summation(candidates, idx+1, n, val, path)
            # # For permutions change idx in below line to 0
            # case2 = summation(candidates, idx, n, val - candidates[idx], path + [candidates[idx]])

        summation(candidates, 0, n, target, [])
      
        return result









