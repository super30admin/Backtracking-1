# Time Complexity : O(2^(m+n)) where m is the length of candidates and n is the target
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The approach is to do exhaustive solution to find all the path that match the target. Once we find the target
# then add it to the result.

class Solution:
    def combinationSum01Recursion(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, idx, path, target):
        # Base case
        if idx == len(candidates) or target < 0:
            return
        if target == 0:
            self.result.append(list(path))
            return
        # Logic
        # 0
        self.helper(candidates, idx + 1, path, target)
        # 1
        path.append(candidates[idx])
        self.helper(candidates, idx, path, target - candidates[idx])
        # backtracking
        path.pop()

# Time Complexity : O(2^(m+n)) where m is the length of candidates and n is the target
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Almost similar approach as 01 with backtracking. Here we run a loop with a pivot and then chose the candidates and add to the path
# and then subtract from the target for the next recursion step.

class Solution:
    def combinationSumIterativeRecursion(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, pivot, path, target):

        if target < 0:
            return

        if target == 0:
            self.result.append(path.copy())

        for i in range(pivot, len(candidates)):
            # action
            path.append(candidates[i])
            # recurse
            self.helper(candidates, i, path, target - candidates[i])
            # backtrack
            path.pop()