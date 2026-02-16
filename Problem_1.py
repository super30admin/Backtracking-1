# // Time Complexity : O(n^t) 
# // Space Complexity : O(t)
class Solution:
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        candidates.sort()  
        self.recurse(candidates,0, target, [])
        return self.result
    
    def recurse(self, candidates,index, target, path):
        
        if(target < 0):
            return
        
        if(target == 0):
            self.result.append(path.copy())
            return


        for i in range(index,len(candidates)):
            if candidates[i] > target:  
                break
            path.append(candidates[i])
            self.recurse(candidates,i, target-candidates[i], path)
            path.pop(-1)


