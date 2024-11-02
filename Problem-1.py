#Approach
#We will loop the through selecting each element and adding it to the list if target is eqaol action is add to the list and do the recursion
# add poop the added elemnent for not selecting  this is called back tracking


#Complexities
#Time 0(2^N)
#Space O(N)




from typing import List


# 0-1 Recurssion
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        path = []
        self.helper(candidates, target, result, path, 0, 0)

        return result

    def helper(self, candidates, target, result, path, currSum, index):
        if currSum == target:
            result.append(path.copy())
            return
        if index >= len(candidates) or currSum > target:
            return
        path.append(candidates[index])
        self.helper(candidates, target, result, path, currSum + candidates[index], index)
        path.pop(-1)

        self.helper(candidates, target, result, path, currSum, index + 1)

# for loop based Recursion
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        path = []
        self.helper(candidates, target, result, path, 0, 0)

        return result

    def helper(self, candidates, target, result, path, currSum, pivot):
        if currSum == target:
            result.append(path.copy())
            return
        if pivot >= len(candidates) or currSum > target:
            return

        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target, result, path, currSum + candidates[i], i)
            path.pop(-1)

        # self.helper(candidates,target,result,path,currSum,index+1)







