# Time Complexity : O(2^t), where t is the target (in worst case exploring all combinations)
# Space Complexity : O(t), recursion stack depth in worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# I used backtracking to explore combinations by including or excluding each candidate

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def backtrack(start, path, total):
            if total == target:
                result.append(path[:])
                return
            if total > target:
                return

            for i in range(start, len(candidates)):
                path.append(candidates[i])
                backtrack(i, path, total + candidates[i])
                path.pop()  # backtrack

        backtrack(0, [], 0)
        return result
