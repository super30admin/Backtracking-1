# time: O(n**(target/min(n)))
# space: O(n**(target/min(n)))
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def helper(start, cursum, temp):
            if start>=len(candidates) or cursum>target:
                return
            
            if cursum==target:
                res.append(temp.copy())
                return 
            
            for i in range(start, len(candidates)):
                temp.append(candidates[i])
                helper(start, cursum+candidates[i], temp)
                temp.pop()
            
        helper(0,0,[])
        return res