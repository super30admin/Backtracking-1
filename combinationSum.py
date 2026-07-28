class Solution:
    def combinationSum(self, candidates, target):
        self.result = []
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, pivot, path):
        #base case
        if target < 0 or pivot == len(candidates):
            return

        if target == 0:
            self.result.append(list(path))
            return

        for i in range(pivot, len(candidates)):
            #action
            path.append(candidates[i])
            #recurse
            self.helper(candidates, target - candidates[i], i, path)
            #backtrack
            path.pop()

# TC - O(2 ^ (m+n)) where m is the candidates length and n is the target
# SC - O(n)