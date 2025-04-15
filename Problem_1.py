from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Finds all unique combinations of candidates where the chosen numbers sum to the target.
        Each candidate may be chosen an unlimited number of times.

        ------------------------------
        Complexity Analysis (Non-Backtracking)
        ------------------------------

        Let:
        - N = number of candidates
        - T = target value
        - M = smallest candidate value among candidates

        Time Complexity: O(N^(T / M) * (T / M))
            - The recursive tree can grow up to N^(T / M) nodes in the worst case.
            - At each node, we create a new copy of the current path, which can be up to O(T / M) in length.
            - Hence, total time complexity is O(N^(T / M) * (T / M)).

        Space Complexity: O(T / M)
            - Maximum recursion depth is O(T / M), when repeatedly choosing the smallest candidate.
            - We exclude the space used for input and output (e.g., the result list) in this analysis.

        """
        result = []

        def helper(cand, targ, path, idx):
            if targ == 0:
                result.append(path)
                return
            if targ < 0 or idx == len(cand):
                return

            # Not choose current candidate
            helper(cand, targ, path[:], idx + 1)

            # Choose current candidate
            helper(cand, targ - cand[idx], path[:] + [cand[idx]], idx)

        helper(candidates, target, [], 0)
        return result


from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Finds all unique combinations of candidates where the chosen numbers sum to the target.
        Each candidate may be chosen an unlimited number of times.

        ------------------------------
        Complexity Analysis (Backtracking)
        ------------------------------

        Let:
        - N = number of candidates
        - T = target value
        - M = smallest candidate value among candidates

        Time Complexity: O(N^(T / M))
            - The recursive tree can grow up to N^(T / M) nodes in the worst case.
            - Unlike the non-backtracking version, we do not create a new list at each level.
            - Therefore, each recursive step takes constant time, excluding result construction.

        Space Complexity: O(T / M)
            - Maximum recursion depth is O(T / M), when repeatedly choosing the smallest candidate.
            - We reuse the same `path` list and only track a single path at a time (backtracking).
            - Output/result space is excluded from complexity analysis.

        Note:
        - This version uses backtracking by modifying and reverting a shared path list (append → recurse → pop).
        - It is more space- and time-efficient than the version that copies the list at every level.
        """
        result = []

        def helper(cand, targ, path, idx):
            # Base case
            if targ == 0:
                result.append(path[:])  # Copy current valid path
                return
            if targ < 0 or idx == len(cand):
                return

            # Not choose the current candidate
            helper(cand, targ, path, idx + 1)

            # Choose the current candidate
            path.append(cand[idx])                 # Action
            helper(cand, targ - cand[idx], path, idx)  # Recurse
            path.pop()                             # Backtrack

        helper(candidates, target, [], 0)
        return result
