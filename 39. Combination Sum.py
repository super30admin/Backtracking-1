#Space: O(height of recursion stack)
#Time: O(n)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.final= list(list())
        self.recurse(candidates, target,list(),0)
        return self.final

    def recurse(self, candidates, target, path, index):
        if target < 0 or index == len(candidates):
            return
        
        if target==0:
            self.final.append(path.copy())
            return 
        #recurse
        self.recurse(candidates, target, path, index+1)
        #action
        path.append(candidates[index])
        self.recurse(candidates, target- candidates[index], path, index)
        #backtrack
        path.pop()
        
        return

        
