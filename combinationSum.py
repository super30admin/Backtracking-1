# Time Complexity : O(2^m+n), where m is the number of candidates and n is the target.
# Space Complexity : O(2^m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : difficulty understanding for-loop based recursion

# Approach: For loop based recursion
# We will use a recursive function to generate all possible combinations of the input list.
# Here, the no choose case is handled by the for loop.
# If we do not want to include the current element in the combination, we will not call the recursive function.
# If we want to include the current element in the combination, we will call the recursive function with the next index.
# After processing the current element, we will backtrack by removing it from the current combination.

from collections import copy
class Solution:
    def combinationSum(self, candidates, target):
        # Initialize an empty list to store the result
        res = []

        # Define a recursive function to generate all possible combinations
        # pivot: determines the starting index of the substring
        def dfs(pivot, currSum, path):
            # base case
            # If the current sum is equal to the target, we have found a valid combination, so we will append it to the result list
            if currSum == target:
                res.append(copy.copy(path))
                return
            # If the current sum is greater than the target, we will not proceed further as we have exceeded the target
            if currSum > target:
                return
            # Loop through the input list starting from the pivot index
            for i in range(pivot, len(candidates)):
                # action
                # If we want to include the current element in the combination, we will add it to the current combination
                path.append(candidates[i])
                # recurse
                # And go to the next index, with the current index as the new pivot
                dfs(i, currSum+candidates[i], path)
                # backtrack
                # Remove the current element from the current combination
                path.pop()
        # Start the recursive function with the initial values
        dfs(0, 0, [])
        # Return the result list
        return res

# Approach : DFS + Backtracking
# We will use a recursive function to generate all possible combinations of the input list.
# At each recursive call, we will have two choices:
# 1. Include the current element in the combination
# 2. Exclude the current element from the combination
# We will explore both choices and generate all possible combinations.
# After processing a choice, we will backtrack to explore the other choice.
# Time Complexity : O(2^m+n), where m is the number of candidates and n is the target.
# Space Complexity : O(2^m+n)
class Solution:
    def combinationSum(self, candidates, target):
        # Initialize an empty list to store the result
        res = []

        def dfs(i, currSum, path):
            # base case
            # If we have reached the end of the candidates list, we will check if the current sum is equal to the target
            if i == len(candidates):
                # If the current sum is equal to the target, we have found a valid combination, so we will append it to the result list
                if currSum == target:
                    res.append(copy.copy(path))
                return
            # If the current sum is greater than the target, we will not proceed further as we have exceeded the target
            if currSum > target:
                return

            # no choose
            # If we do not want to include the current element, we will call the recursive function with the next index
            dfs(i+1, currSum, path)

            # choose
            # action
            # If we want to include the current element in the combination, we will add it to the current combination
            currSum += candidates[i]
            # And go to the next index, with the current index as the new pivot
            path.append(candidates[i])
            # recurse
            # Call the recursive function with the same index, since we are allowed to use the same element multiple times
            dfs(i, currSum, path)
            # backtrack
            # Remove the current element from the current combination
            path.pop()
        # Start the recursive function with the initial values
        dfs(0, 0, [])
        # Return the result list
        return res