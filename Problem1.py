"""
TC: O(N * 2^T) {where N is the number of candidates and T is the target. This is a rough upper bound as pruning significantly reduces the search space.}
SC: O(T/min_val) {The space required for the recursion stack, where T is the target and min_val is the smallest candidate.}

Approach:

This problem is solved using a **backtracking** algorithm to find all unique combinations. We begin by sorting the `candidates` array, which is a crucial step for **pruning** the search space. The core of the solution is a recursive function that explores combinations by adding a candidate and making a recursive call. The function's `pivot` index allows for the same number to be used multiple times. If adding a candidate causes the sum to exceed the target, we stop exploring that branch. When a valid combination is found (sum equals target), we add it to our result list. After each recursive call, we backtrack by removing the last element, allowing us to explore other possibilities.

The problem ran successfully on LeetCode.
"""
from typing import List
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def backtrack(pivot, curr_sum, path):
            #base case
            if curr_sum == target:
                res.append(path[:])
                return

            #logic
            for i in range(pivot, len(candidates)):
                if curr_sum + candidates[i] > target:
                    break
                path.append(candidates[i])
                backtrack(i, curr_sum + candidates[i], path)
                path.pop()

        candidates.sort()
        res = []
        backtrack(pivot = 0, curr_sum = 0, path=[])
        return res
