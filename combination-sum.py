# Time Complexity: O(2^(m+n)) 
# Space Complexity: O(m+n) 
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        path=[]

        def helper(pending_target,i,path):
            #base            
            if pending_target<0 or i==len(candidates):
                return
            
            if pending_target==0:
                res.append(list(path))
                return

            #logic
            helper(pending_target,i+1,path)

            path.append(candidates[i])
            helper(pending_target-candidates[i],i,path)
            path.pop()
        
        helper(target,0,path)
        return res