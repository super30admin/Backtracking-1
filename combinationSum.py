"""
Apply DFS to check each candidate from current index
If current sum == target, add path to result
Skip if sum > target; allow reuse by not incrementing index
"""
""" 
Time Complexity: O(2^t) where t = target - exponential due to decision tree depth
Space Complexity: O(t) recursion depth
"""

from typing import List

class combinationSum:
    def combinationSums(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def backtrack(start, path, total):
            if total == target:
                result.append(list(path))
                return
            if total > target:
                return

            for i in range(start, len(candidates)):
                path.append(candidates[i])
                backtrack(i, path, total + candidates[i])
                path.pop()

        backtrack(0, [], 0)
        return result

if __name__ == "__main__":
    obj = combinationSum()
    print(obj.combinationSums([2, 3, 6, 7], 7)) 
    print(obj.combinationSums([2, 3, 5], 8)) 
