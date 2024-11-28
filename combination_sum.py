"Time Complexity is O(2^N)"
"Space Complexity is O(target) + O(result)"

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(pivot, target, path):
            if target == 0:
                result.append(path[:])
            if target < 0:
                return 

            for i in range(pivot, len(candidates)):
                path.append(candidates[i])
                helper(i, target-candidates[i], path)
                path.pop()
        
        helper(0, target, [])
        return result

        