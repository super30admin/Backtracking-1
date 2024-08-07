class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates == None or len(candidates)==0:
            return[]
        self.result = []
        # self.recurse(candidates,target,[],0)
        # self.backtrack(candidates,target,[],0)
        self.backtrack2(candidates,target,[],0)
        return self.result

    def backtrack2(self, candidates: List[int], target: int, path:List[int], indx:int) -> None:
        if target == 0:
            self.result.append(path[:])
            return
        if target < 0 :
            return
        for i in range(indx, len(candidates)):
            #action
            path.append(candidates[i])
            #recurse
            self.backtrack2(candidates,target-candidates[i],path, i)
            # backtrack
            path.pop()

    def backtrack(self, candidates: List[int], target: int, path:List[int], indx:int):
        #base case
        if target ==0:
            self.result.append(path[:])
            return
        if target <0 or indx == len(candidates):
            return
        # action
        self.backtrack(candidates,target,path,indx+1)
        path.append(candidates[indx])
        self.backtrack(candidates,target-candidates[indx],path,indx)
        #backtrack
        path.pop()
        

    def recurse(self, candidates: List[int], target: int, path:List[int], indx:int):       
        if target == 0:
            self.result.append(path)
            return 
        if indx == len(candidates) or target < 0:
            return
        # not include
        self.recurse(candidates,target,[num for num in path],indx+1)   
        path.append(candidates[indx])
        self.recurse(candidates,target-candidates[indx],[num for num in path],indx)

"""
Time Complexity: 
Recurse: O(2^N)
backtrack: O(N^2)
space:
backtrack: O(N)
"""
    
