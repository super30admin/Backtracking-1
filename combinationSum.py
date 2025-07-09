# Time Complexity : O(2^t), where t is the target value. The tree grows exponentially in the worst case.
# Space Complexity : O(t), for the recursion stack (maximum depth can be target when using smallest candidate repeatedly)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used backtracking to explore all possible combinations that sum up to the target.
# At each recursive call, I chose a candidate (can be reused), subtracted it from the target,
# and continued the search. I only added combinations to the result when the target became 0.
# I also made sure to not go backwards in the candidate list to avoid duplicate combinations.

from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def backtrack(start, path, remaining):
            if remaining == 0:
                result.append(path[:])
                return
            if remaining < 0:
                return

            for i in range(start, len(candidates)):
                path.append(candidates[i])
                backtrack(i, path, remaining - candidates[i])  # not i+1 because I can reuse same element
                path.pop()

        backtrack(0, [], target)
        return result
