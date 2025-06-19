# Time Complexity : O(2^t), where t is the target value
#   - In the worst case, every candidate can be repeatedly used to form the target.
# Space Complexity : O(t), for recursion stack and storing current combination
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # Backtracking approach
        res = []

        def dfs(i: int, curr: List[int], total: int):
            if total == target:
                res.append(curr.copy())
                return

            if i >= len(candidates) or total > target:
                return 

            # Choose the current candidate
            curr.append(candidates[i])
            dfs(i, curr, total + candidates[i])
            curr.pop()  # backtrack

            # Skip the current candidate
            dfs(i + 1, curr, total)

        dfs(0, [], 0)
        return res


        # -----------------------------------------
        # Non-backtracking version (pure recursion with copies)
        # Time Complexity : O(2^t * k), where t = target, k = average length of combination
        #   - 2^t because of choice at each candidate (take or skip)
        #   - k factor because we copy the current combination list at each valid leaf
        # Space Complexity : O(t * k)
        #   - Recursion stack up to depth t (target)
        #   - Each recursive call creates a new list copy of size up to k

        # res = []
        # def dfs(i, curr, total):
        #     if total == target:
        #         res.append(curr.copy())
        #         return
        #     if i >= len(candidates) or total > target:
        #         return 
        #     new_temp = curr[:]
        #     new_temp.append(candidates[i])
        #     dfs(i, new_temp, total + candidates[i])
        #     dfs(i + 1, curr, total)
        # dfs(0, [], 0)
        # return res


if __name__ == "__main__":
    sol = Solution()
    print(sol.combinationSum([2,3,6,7], 7))      # Output: [[2,2,3],[7]]
    print(sol.combinationSum([2,3,5], 8))        # Output: [[2,2,2,2],[2,3,3],[3,5]]
    print(sol.combinationSum([2], 1))            # Output: []
    print(sol.combinationSum([1], 1))            # Output: [[1]]
    print(sol.combinationSum([1], 2))            # Output: [[1,1]]
