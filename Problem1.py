# 39. Combination Sum
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        pivot = 0
        i = 0
        result = []
        n = len(candidates)

        def helper(pivot,candidates,target,path):
            for i in range(pivot,n):
                if target == 0:
                    result.append(list(path))
                    return 

                if target < 0:
                    return

                path.append(candidates[i])
                helper(i,candidates,target-candidates[i],path)
                path.pop()

        helper(0,candidates,target,[])
        return result
        