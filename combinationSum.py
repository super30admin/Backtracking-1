class Solution:
    # backtrack approach
    def recurse(self,candidates: List[int],target: int,idx: int,path: List[int]):
        # base
        if target < 0:
            return
        if target == 0:
            self.res.append(path[:])
            return
        # logic
        for i in range(idx,len(candidates)):
            path.append(candidates[i])
            self.recurse(candidates,target-candidates[i],i,path)
            path.pop()
            
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0 or candidates is None:
            return []
        self.res = []
        self.recurse(candidates,target,0,[])
        return self.res
        