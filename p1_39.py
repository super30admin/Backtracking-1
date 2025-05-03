# 39. Combination Sum

# TC : O(N^target) where N is the number of candidates. In the worst case, each candidate could be used target/min(candidates) times.
# SC : O(target/min(candidates)) for the recursion stack. The maximum depth of recursion is bounded by the target divided by the smallest candidate.
# Did this code successfully run on Leetcode : Yes

# Approach :
# Using a backtracking algorithm to find all unique combinations that sum to the target:
    # Backtracking Function: The core of the solution is the backtrack helper function that explores all possible combinations.
    # Parameters:
        # start: The index in the candidates array to start considering elements from
        # current_combination: The combination being built
        # remaining_target: The remaining sum needed to reach the target
    # Base Cases:
        # If the remaining target is 0, we've found a valid combination
        # If the remaining target is negative, the current path won't work
    # Recursive Exploration:
        # For each candidate from the starting index, we:
            # Add it to the current combination
            # Recursively explore with the updated remaining target
            # Start from the same index again (since we can reuse elements)
            # Backtrack by removing the element before trying the next one
    # Uniqueness:
        # By only considering candidates from the start index onward, we ensure that combinations with the same elements in different orders are not counted as distinct.
    # Examples:
        # For candidates = [2,3,6,7] and target = 7:
            # The function will find [2,2,3] and [7]
        # For candidates = [2,3,5] and target = 8:
            # The function will find [2,2,2,2], [2,3,3], and [3,5]


from ast import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # Initialize the result list to store all valid combinations
        result = []
        
        # Define the backtracking helper function
        def backtrack(start, current_combination, remaining_target):
            # Base cases
            if remaining_target == 0:
                # We found a valid combination, add a copy to the result
                result.append(current_combination.copy())
                return
            
            if remaining_target < 0:
                # Invalid combination, stop exploring this path
                return
            
            # Try each candidate from the start position
            for i in range(start, len(candidates)):
                # Take the current candidate
                current_combination.append(candidates[i])
                
                # Recursively explore with the current candidate included
                # We start from i (not i+1) because we can reuse the same element
                backtrack(i, current_combination, remaining_target - candidates[i])
                
                # Backtrack: remove the current candidate to try the next one
                current_combination.pop()
        
        # Start the backtracking process
        backtrack(0, [], target)
        
        return result
        