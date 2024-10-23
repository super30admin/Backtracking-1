# T.C = O(K^t)  S.C = O(K^t)
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.result = []
        self.helper(candidates,target,0,[])
        return self.result

    def helper(self,candidates,target,pivot,path):
        if(target == 0):
            self.result.append(copy.deepcopy(path))
            return
        
        if(target<0):
            return
            
        for i in range(pivot,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,target-candidates[i],i,path)
            path.pop(len(path)-1)
        

        