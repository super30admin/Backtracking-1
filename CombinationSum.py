# Time complexity - o(2**(m+n)) where m in length of candiates and n is target
# Space complexity - o(n) recursive stack space

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        result = []

        def helper(pivot, path, candidates, target, result):

            if pivot == len(candidates) or target<0:
                return 

            if target == 0:
                result.append(path[::])
                return

            for idx in range(pivot,len(candidates)):

                # action
                path.append(candidates[idx])

                # recurse
                helper(idx, path, candidates, target-candidates[idx], result)

                # backtracking
                path.pop()

        helper(0, [], candidates, target, result)

        return result