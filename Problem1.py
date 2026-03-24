#39. Combination Sum

from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]

        self.helper(0, candidates, target, [])
        return self.result


    def helper(self, index, candidates, target, potentialCand):

        if target==0:
            self.result.append(potentialCand[:])
            return

        if index == len(candidates) or target<0:
            return
        

        #no choose:
        self.helper(index+1, candidates, target, potentialCand)

        #choose candidate
        potentialCand.append(candidates[index])
        self.helper(index, candidates, target-candidates[index], potentialCand)
        potentialCand.pop()

sol = Solution()
print(sol.combinationSum([2], 1))