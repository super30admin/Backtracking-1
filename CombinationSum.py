# Time Complexity : O(2^n)
# Space Complexity : O(n)
class Solution:
    def combinationSum(self, candidates, target):
        def recurse(candidates, target, index, path):
            # base
            if target < 0:
                return
            if target == 0:
                result.append(list(path))
                return
            # Logic
            for i in range(index, len(candidates)):
                path.append(candidates[i])
                recurse(candidates, target - candidates[i], i, path)
                # backtrack
                path.pop()

        result = []
        if not candidates:
            return result

        recurse(candidates, target, 0, [])
        return result

# Example usage:
solution = Solution()

# Example 1
candidates1 = [2, 3, 6, 7]
target1 = 7
print(solution.combinationSum(candidates1, target1))
# Output: [[2, 2, 3], [7]]

# Example 2
candidates2 = [2, 3, 5]
target2 = 8
print(solution.combinationSum(candidates2, target2))
# Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

# Example 3
candidates3 = [2]
target3 = 1
print(solution.combinationSum(candidates3, target3))
# Output: []