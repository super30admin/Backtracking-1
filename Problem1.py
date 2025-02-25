class Solution:
    def __init__(self):
        self.result = []
        self.path = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates,0,self.path,target)
        return self.result
    
    def helper(self, candidates: List[int],idx: int,path: List[int], target: int):
        #base case
        if target < 0 or idx == len(candidates):
            return
        if target == 0:
            self.result.append(list(path))
            return

        #logic
        # 0 case
        self.helper(candidates, idx+1,path, target)


        #1 case
        path.append(candidates[idx])
        self.helper(candidates, idx, path,target-candidates[idx])
        path.pop()
        

#for loop based recursion
class Solution:
    def __init__(self):
        self.result = []
        self.path = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates,0,self.path,target)
        return self.result
    
    def helper(self, candidates: List[int],pivot: int,path: List[int], target: int):
        #base case
        if target < 0 or pivot == len(candidates):
            return
        if target == 0:
            self.result.append(list(path))
            return

        for i in range(pivot,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,i,path,target-candidates[i])
            path.pop()

        