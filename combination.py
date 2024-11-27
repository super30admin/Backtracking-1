# The combinationSum method finds all unique combinations of candidates that sum up to the target.
# Each candidate can be used unlimited times.

# Step 1: Backtracking Helper
#   - The backtrack function explores all possible combinations:
#       - If remaining is 0, add the current combination to the result.
#       - If remaining is negative, terminate the current path.
#       - Iterate through candidates starting from the current index to avoid duplicates.
#       - Add the candidate to the combination, recursively call backtrack with the updated remaining, and backtrack by removing the last added element.

# Step 2: Initialization
#   - Initialize 'result' to store valid combinations.
#   - Start backtracking with the target, an empty combination, and the index 0.

# Step 3: Return Result
#   - Return 'result', which contains all valid combinations.

# TC: O(2^t) - Depends on the target (t) and the size of candidates due to the exploration of combinations.
# SC: O(t) - Space for recursion stack and temporary combinations.


from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(remaining, combination, start):
            if remaining == 0:
                result.append(list(combination))
                return
            if remaining < 0:
                return

            for i in range(start, len(candidates)):
                combination.append(candidates[i])
                backtrack(remaining - candidates[i], combination, i)
                combination.pop()

        result = []
        backtrack(target, [], 0)
        return result