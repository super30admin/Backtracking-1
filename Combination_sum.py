# Approach:
# Use a backtracking algorithm to explore all possible combinations of candidates that sum to the target.
# For each candidate, either include it (allowing repetition) or skip it.
# Stop the recursion when the target becomes zero (valid combination) or negative (invalid path).

# Time Complexity:
# O(2^t * k), where t is the target value and k is the average length of combinations.
# Space Complexity:
# O(t) for the recursion stack, where t is the target value.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(start, target, path):
            # Base case: if target is zero, add the current path to results
            if target == 0:
                result.append(list(path))
                return
            # Iterate over the candidates starting from the current index
            for i in range(start, len(candidates)):
                # If the candidate exceeds the target, skip it
                if candidates[i] > target:
                    continue
                # Include the candidate and recurse with the reduced target
                path.append(candidates[i])
                backtrack(i, target - candidates[i], path)
                # Backtrack by removing the last candidate added
                path.pop()
        
        # Result list to store all valid combinations
        result = []
        # Start backtracking with an empty path
        backtrack(0, target, [])
        return result
