# // Time Complexity :O(2^n) 2 choices
# // Space Complexity :O(n) recursion stack size
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# forloop recursion: pivot backtracking
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        def helper(candidates, target, pivot, path):            # pivot index becomes the new start at every recursive call
            #base
            if target == 0:                                     # if target reached
                result.append(path[:])
                return

            if len(candidates) == pivot or target < 0 :         # if out of bounds or Target negative 
                return

            #logic
            for i in range(pivot,len(candidates)):              # for loop starts from pivot 
                path.append(candidates[i])                      # update path
                helper(candidates,target-candidates[i],i,path)  # update pivot in recursion*****************
                path.pop()                                      # backtrack
                
        helper(candidates,target,0,[])
        return result

#standard recursion"0-1": backtracking
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        def helper(candidates, target, i, path):
            #base
            if target == 0:
                result.append(path[:])                      #add deepcopy
                return

            if len(candidates) == i or target < 0 :
                return

            #logic

            #chose
            path.append(candidates[i])
            helper(candidates,target-candidates[i],i,path)  # decrement target
            path.pop()                                      # bakctrack path 

            #no choose
            helper(candidates,target,i+1,path)              
            
        helper(candidates,target,0,[])
        return result