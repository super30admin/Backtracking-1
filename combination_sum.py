# Time Complexity: exponential
# Space Complexity: O(T/M)
class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        result = []
        self.combinationSumHelper([], 0, result, 0, target, candidates)
        return result

    def combinationSumHelper(self, current: list[int], start: int, result: list[list[int]], sum_val: int, target: int, candidates: list[int]):
        if sum_val > target:
            return
        if sum_val == target:
            result.append(current[:])
            return
        for i in range(start, len(candidates)):
            current.append(candidates[i])
            self.combinationSumHelper(current, i, result, sum_val + candidates[i], target, candidates)
            current.pop()
