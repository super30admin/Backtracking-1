class Solution(object):
    result = []
    def combinationSum(self, candidates, target): #T.C -> O(2^N), S.C -> O(N)
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.result = []
        self.helper(candidates,target,0,[])
        return self.result
    def helper(self,candidates,target,pivot,path):
        #base case
        if target < 0:
            return
        if target == 0:
            self.result.append(path)
            return
        #logic
        for i in range(pivot,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,target-candidates[i],i,copy.deepcopy(path))
            path.pop()
        
        