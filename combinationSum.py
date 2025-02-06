class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # T: O(2 ** t), S: O(h)
        res = []

        def dfs(cur, i, total):
            # Base
            if total == target:
                res.append(cur.copy())
                return
            if i >= len(candidates) or total > target:
                return
            # Recursive
            # Include
            cur.append(candidates[i])
            dfs(cur, i, total + candidates[i])
            # Backtrack
            cur.pop()
            # Exclude
            dfs(cur, i + 1, total)

        dfs([], 0, 0)

        return res
