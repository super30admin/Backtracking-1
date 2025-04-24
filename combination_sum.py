# This is a backtracking solution that explores all combinations by recursively adding candidates to the current path.
# The recursion continues as long as the remaining target is non-negative, and we reuse the same index to allow unlimited use of each number.
# Time Complexity: O(2^t), where t is the target value; Space Complexity: O(t) due to recursion stack and current path storage.

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(target, pivot, path):
            if(target == 0):
                result.append(path[:])

            if(target < 0):
                return

            for i in range(pivot, len(candidates)):
                # action
                path.append(candidates[i])
                # recurse
                helper(target - candidates[i], i, path)
                path.pop()

        helper(target, 0, [])
        return result
