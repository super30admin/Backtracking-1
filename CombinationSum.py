# Time Complexity: Exponential, 2^(target+candidates)
# Space Complexity: O(target + candidates)
#DFS - 01 Based BackTracking Solution 
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        self.helper(0, target, [], result, candidates)
        return result
    def helper(self, i, target, path, result, candidates):
        # Base case: if amount is 0, we found a valid combination
        if target == 0:
            result.append(path)
            return
        # Invalid case: if amount is negative or we have considered all candidates
        if target < 0 or i == len(candidates):
            return
        
        # Choose case: include the current candidate
        self.helper(i, target - candidates[i], path + [candidates[i]], result, candidates)
        # Not choose case: skip the current candidate and move to the next
        self.helper(i + 1, target, path, result, candidates)



# Time Complexity: Exponential, 2^(target+candidates)
# Space Complexity: O(target + candidates)
# For loop based BackTracking Solution
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0: return []
        result = []
        self.helper(result, candidates, [], target, 0)
        return result
    
    def helper(self, result, candidates, path, target, index):
        # Base Case
        if target == 0:
            result.append(path[:])
        # Logic
        for i in range(index, len(candidates)):
            if candidates[i] <= target:
                path.append(candidates[i])
                self.helper(result, candidates, path, target - candidates[i], i)
                path.pop()