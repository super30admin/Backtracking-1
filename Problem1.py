## Problem1 
# Combination Sum (https://leetcode.com/problems/combination-sum/)

# Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

# The same repeated number may be chosen from candidates unlimited number of times.

# Note:

# All numbers (including target) will be positive integers.
# The solution set must not contain duplicate combinations.
# Example 1:

# Input: candidates = [2,3,6,7], target = 7,
# A solution set is:
# [
#   [7],
#   [2,2,3]
# ]
# Example 2:

# Input: candidates = [2,3,5], target = 8,
# A solution set is:
# [
#   [2,2,2,2],
#   [2,3,3],
#   [3,5]
# ]

# Method1: Using 0-1 Exhaustive Recursion with backtracking
# M -- no. of elements in the array
# N -- the target
# Time Complexity : O(2 ^ (M + N)) -- going through all the nodes
# Space Complexity : O(h) --- for storing the path and at max it would be h, where h is the height of the tree
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Using 0-1 Exhaustive Recursion, we choose a number in our or we decide to skip a number. If we choose a number, we can choose again
# At every step we have 2 choices. And max height possible is m + n. Here we assume that the final paths that we add to our result are limited.
# So we consider the time complexity for deep copy of final path list as constant

import copy
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def helper(candidates, target, idx, path):
            # base
            if(idx == len(candidates)):
                # out of bounds
                return

            if(target < 0):
                return

            if(target == 0):
                result.append(copy.deepcopy(path))
                return

            # action
            # not choose
            helper(candidates, target, idx + 1, path)
            # choose
            path.append(candidates[idx])
            helper(candidates, target - candidates[idx], idx, path)

            # backtrack
            path.pop()

        result = []
        helper(candidates, target, 0, [])
        return result
    
sol = Solution()
print("Method1: Using 0-1 Exhaustive Recursion with backtracking")
print(sol.combinationSum([2,3,6,7], 7))
print(sol.combinationSum([2,3,5], 8))
print(sol.combinationSum([2], 1))


# Method2: Using For Loop based recusrion without backtracking
# M -- no. of elements in the array
# N -- the target
# Time Complexity : O((2 ^ (M + N))   *   h) -- going through all the nodes and creating a new list at each node. h is the max length of path 
# that would be height of the tree
# Space Complexity : O(h ^ 2) = O((m + n) * h) --- At max we go (m + n) height down and max path length would be height of the tree
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here in for loop based recursion we have a pivot. At each level we have for loop running from i = pivot to i = len(candidates) - 1.
# It is exactly the same as 0-1 recursion, just the shape of tree is different. Here we are doing it without backtracking so we should
# always pass a new list as path in the further recursive calls as it is a reference. So we create a deepcopy at each node.
# One thing to note is We should not add element and then create deepcopy. It would hamper the no choose case also
# Instead we create a new reference ie new list with deepcopy first and then add the element and pass to the choose case
# In this way our path at the current level would remain same and a new reference would go to further paths

import copy
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def helper(candidates, target, pivot, path):
            # base
            # if(pivot == len(candidates)):
            #     # out of bounds
            #     return

            if(target < 0):
                return

            if(target == 0):
                # valid case
                result.append(path)

            # for loop from pivot onwards
            for i in range(pivot, len(candidates)):
                # next pivot would be i onwards
                # when we go to further levels we need to add curr element to the path
                # at the same level the path should remain same as before

                # using deepcopy path
                # if we add to the path and send, everywhere the path would get updated
                # as it is reference
                # We should not add element and then create deepcopy. It would hamper
                # the no choose case also
                # Instead we create a new reference ie new list with deepcopy first
                # and then add the element and pass to the choose case
                # In this way our path at the current level would remain same
                # And a new reference would go to further paths

                # using new path list at every recursive call
                # we create a deepcopy first to pass new reference and then add element
                # so that our current path at this level remains same
                # to avoid baby relay
                newPath = copy.deepcopy(path)
                newPath.append(candidates[i])

                # recurse
                # since we can repeat the numbers so i and not (i + 1)
                helper(candidates, target - candidates[i], i, newPath)
            

        result = []
        helper(candidates, target, 0, [])
        return result
    
sol = Solution()
print("Method2: Using For Loop based recusrion without backtracking")
print(sol.combinationSum([2,3,6,7], 7))
print(sol.combinationSum([2,3,5], 8))
print(sol.combinationSum([2], 1))


# Method3: Using For Loop based recusrion with backtracking
# M -- no. of elements in the array
# N -- the target
# Time Complexity : O(2 ^ (M + N)) -- going through all the nodes
# Space Complexity : O(h) --- for storing the path and at max it would be h, where h is the height of the tree
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The algo is same as above. Just here instead of creating a new reference at each node, we maintain the same path reference and add to it
# before going to next and pop the last element after coming back to it.

import copy
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def helper(candidates, target, pivot, path):
            # base
            # if(pivot == len(candidates)):
            #     # out of bounds
            #     return

            if(target < 0):
                return

            if(target == 0):
                # valid case
                result.append(copy.deepcopy(path))

            # for loop from pivot onwards
            for i in range(pivot, len(candidates)):
                # next pivot would be i onwards
                # when we go to further levels we need to add to the path
                # at the same level the path should remain same as before
                # if we add to the path and send, everywhere the path would get updated
                # as it is reference
                # We should not add element and then create deepcopy. It would hamper
                # the no choose case also
                # Instead we create a new reference ie new list with deepcopy first
                # and then add the element and pass to the choose case
                # In this way our path at the current level would remain same
                # And a new reference would go to further paths
                # action
                path.append(candidates[i])

                # recurse
                # since we can repeat the numbers so i and not (i + 1)
                helper(candidates, target - candidates[i], i, path)

                # if we use same reference then we need to
                # backtrack
                path.pop()
            

        result = []
        helper(candidates, target, 0, [])
        return result
    
sol = Solution()
print("Method3: Using For Loop based recusrion with backtracking")
print(sol.combinationSum([2,3,6,7], 7))
print(sol.combinationSum([2,3,5], 8))
print(sol.combinationSum([2], 1))
