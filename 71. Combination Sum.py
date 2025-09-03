class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # Initializing result list to store valid combinations and sol list for current combination
        result, sol = [], []
        nums = candidates
        n = len(nums)

        # Defining backtracking function to explore all possible combinations
        def backtrack(i, current_sum):
            # Checking if current_sum equals target, then adding current combination to result
            if current_sum == target:
                result.append(sol[:])
                return
            # Returning if current_sum exceeds target or all candidates are considered
            if current_sum > target or i == n:
                return 

            # Skipping current candidate and moving to next
            backtrack(i+1, current_sum)

            # Including current candidate and recursively calling backtrack
            sol.append(nums[i])
            backtrack(i, current_sum+nums[i])
            # Removing last candidate to backtrack
            sol.pop()

        # Starting backtracking from index 0 and sum 0
        backtrack(0, 0)
        return result

# Time Complexity (TC): O(2^n * k), where n is the number of candidates and k is the average length of each combination.
# Space Complexity (SC): O(k * m), where m is the number of valid combinations and k is the average length of each combination.
