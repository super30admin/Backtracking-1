# https://leetcode.com/problems/combination-sum/

#Time Complexity- O(n*2^(m+n)) Self Complexity- O(n2)

class Solution:
    def combinationSum(self, candidates, target):
        # initialise the result set to store the combinations
        self.result = []
        # call the helper function
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, pivot, path):
        # base case 1: when the sum is bigger than target
        if target < 0:
            return
        # base case 2: when amount become zero add the path to result
        if target == 0:
            # append that path to result
            self.result.append(list(path))
            return
        # use the for loop to choose the combination 
        # for first iteration the pivot will be at 0th index 
        for i in range(pivot, len(candidates)):
            # create a new list 
            new_path = list(path)
            # add the element to that list
            new_path.append(candidates[i])
            # recurse if the target is still not achieved return to for loop
            self.helper(candidates, target - candidates[i], i, new_path)

solution = Solution()
print(solution.combinationSum([2,3,6,7],7))