# Problem1: Combination Sum (https://leetcode.com/problems/combination-sum/)
# Time Complexity: O(2^(m+n)) where m = length of candidates, n = target, at every index we make 2 choices (skip or take) and this branching repeats roughly m+n times, so paths double over and over
# Space Complexity: O(n) where n = target,this is the max depth of the recursion call stack, bounded by how many times we can subtract from target before hitting 0

# Approach:
# We explore all ways to reach the target by trying each candidate at every step.
# At each step, we either skip the current number or take it (staying at the same index since numbers can be reused) then undo the take after exploring it.
# When target hits exactly 0, we save a copy of the current path as a valid combination.

class Solution:    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []        # empty list to store all valid combinations we find
        self.helper(candidates, target, 0, [])   # start recursion: at index 0, needing full target, empty path so far
        return self.result      # return all combinations collected during recursion

    def helper(self, candidates, target, i, path):
        if target < 0 or i == len(candidates):   # dead end: either we overshot the target or we have run out of candidates to try
            return

        if target == 0:         # success: the numbers in path add up exactly to target
            self.result.append(list(path))   # save a COPY of path, since path keeps changing after this
            return

        self.helper(candidates, target, i + 1, path)     # branch 1 (skip): don't take candidates[i], move to next index

        path.append(candidates[i])   # branch 2 (take): add candidates[i] to path

        self.helper(candidates, target - candidates[i], i, path)   # explore further, staying at index i since we can reuse this number
        path.pop()          # backtrack: remove candidates[i] so path is clean for the caller
