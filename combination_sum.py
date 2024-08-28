# Time: O(n)
# space: O(H)

class Solution(object):
    result = []
    def combinationSum(self, candidates, target):
        # choose or dont choose
        # maintain the index
        # reove chosen elemtn after you are done
        # while adding the path to result, add a copy bcoz lists are added by reference
        self.result = []
        path = []
        self.helper(candidates, 0, path, target)
        return self.result

    def helper(self, candidates, index, path, target):
        if target == 0:
            to_add = []
            to_add += path
            self.result.append(to_add)
            return
        if target < 0 or index >= len(candidates):
            return
        
        # dont choose
        self.helper(candidates, index + 1, path, target)
        # choose 
        path.append(candidates[index])
        self.helper(candidates, index, path, target - candidates[index])
        path.pop()