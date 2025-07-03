# TC: O(n^d), d = max depth of recursion stack
# SC: O(d)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res=[]
        def helper(candidates, target, pivot,  path, csum, res):
            #base
            if csum==target:
                res.append(path.copy())
            #logic
            for i in range(pivot,len(candidates)):
                #action
                if csum+candidates[i]<=target:
                    path.append(candidates[i])
                    csum+=candidates[i]
                    #recurse
                    helper(candidates,target,i,path,csum,res)
                    #backtrack
                    path.pop()
                    csum-=candidates[i]
        

        helper(candidates,target,0,[],0,res)
        return res