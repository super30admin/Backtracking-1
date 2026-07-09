## Problem1 
# Combination Sum (https://leetcode.com/problems/combination-sum/)
import copy
from typing import List

class Solution:    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Regular Recursive Solution:
    
        TIME COMPLEXITY: O(2^(T/M))
        - Let T be the target value and M be the minimum value among the candidates.
        - In the worst-case scenario (e.g., target = 10, candidates = [1]), the recursion tree 
        can go as deep as T/M. At each step in our backtracking, we make 2 decisions 
        (include or exclude). This leads to a loose upper bound of O(2^(T/M)) operations.
        
        SPACE COMPLEXITY: O(T/M)
        - The maximum depth of the recursive call stack is T/M (if we keep subtracting 
        the smallest element). 
        - The `path` array will also store at most T/M elements at any given time.
        - Note: This space complexity excludes the space required to hold the final `result` output.
        """
        result = []
        
        def helper(target, path, index):
            nonlocal result, candidates
            
            # --- BASE CASES ---
            # If target perfectly reaches 0, we found a valid combination.
            if target == 0:
                # We must append a copy of the path. 
                # Tip: Using `list(path)` or `path[:]` is slightly faster and standard 
                # compared to `copy.deepcopy(path)`.
                result.append(copy.deepcopy(path))
                return
            
            # If we've run out of candidates to check OR the target becomes negative 
            # (meaning our current sum exceeds the target), prune this branch.
            if index == len(candidates) or target < 0:
                return
                
            # --- LOGIC (BACKTRACKING) ---
            
            # Case 1: EXCLUDE the element at the current index.
            # We skip the current candidate entirely and move on to explore the `index + 1`.
            # Target and path remain unchanged.
            helper(target, path, index + 1)
            
            # Case 2: INCLUDE the element at the current index.
            # We add the current candidate to our path.
            path.append(candidates[index])
            
            # We subtract the candidate's value from the target.
            # Notice we pass `index` (not `index + 1`) because we are allowed 
            # to choose the same candidate an unlimited number of times.
            helper(target - candidates[index], path, index)
            
            # BACKTRACK: Remove the candidate we just added to clean up the `path` 
            # state before returning to the previous recursive frame.
            path.pop()

        # Initiate the recursive backtracking with the initial target, empty path, and starting index 0
        helper(target, [], 0)
        
        return result



        """
        For-Loop Based Recursive Solution (Backtracking):
        
        TIME COMPLEXITY: O(N^(T/M))
        - Let N be the number of candidates, T be the target, and M be the minimum candidate value.
        - The maximum depth of our recursion tree is T/M (which happens if we repeatedly pick the smallest element).
        - At each level of the tree, the for-loop branches out up to N times. 
        - This provides a loose upper bound of O(N^(T/M)). In reality, it runs much faster because the target shrinks and the number of iterations decreases as the `pivot` moves forward.
        
        SPACE COMPLEXITY: O(T/M)
        - The recursive call stack goes as deep as the maximum length of a combination, which is T/M.
        - The `path` list will also hold at most T/M elements at any given time.
        - Note: This space complexity excludes the memory required to hold the final `result` arrays.
        """
        # result = []
        
        # def helper(target, pivot, path):
        #     # --- BASE CASES ---
        #     # If the target is exactly 0, the current path sums up to the initial target perfectly.
        #     if target == 0:
        #         # We append a deepcopy of the path so that subsequent `pop()` operations 
        #         # don't alter the result we just saved.
        #         result.append(copy.deepcopy(path))
        #         return
            
        #     candidatesLen = len(candidates)
        #     # If our current sum exceeded the target (target < 0) or we are out of bounds, 
        #     # we simply prune this branch and stop exploring.
        #     if pivot == candidatesLen or target < 0:
        #         return

        #     # --- LOGIC (FOR-LOOP BACKTRACKING) ---
        #     # The `pivot` ensures we only pick candidates from the current index onwards.
        #     # This is crucial for avoiding duplicate combinations (e.g., picking [2,3] then [3,2]).
        #     for i in range(pivot, candidatesLen):
                
        #         # 1. CHOOSE: Add the current candidate to our combination path
        #         path.append(candidates[i])
                
        #         # 2. EXPLORE: Recurse downwards with the newly reduced target.
        #         # Notice we pass `i` as the next pivot, NOT `i + 1`. This is the key to 
        #         # allowing the same candidate to be chosen an unlimited number of times.
        #         helper(target - candidates[i], i, path)
                
        #         # 3. BACKTRACK: Pop the last candidate off the path so we can cleanly
        #         # move on to the next candidate `candidates[i+1]` in the next iteration of the loop.
        #         path.pop()

        # # Initiate the recursive helper with the initial target, starting pivot index 0, and an empty path
        # helper(target, 0, [])
        
        # return result