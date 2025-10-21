# Time Complexity: 2 ^ n
# Space Complexity: O(h) -> height of the stack
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def rec(i, target, path): 
            if target < 0 or i == len(candidates): 
                return 
            if target == 0: 
                res.append(path[:])
                return 

            rec(i+1, target, path)
            path.append(candidates[i])
            rec(i, target - candidates[i], path)
            path.pop()

        rec(0, target, [])
        return res

"""
# Time Complexity: 2 ^ n
# Space Complexity: O(h) -> height of the stack
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def rec(pivot, target, path): 
            if target < 0 or pivot == len(candidates): 
                return 
            if target == 0: 
                res.append(path[:])
                return 

            for i in range(pivot, len(candidates)): 
                # Action
                path.append(candidates[i])

                # Recurse

                rec(i, target - candidates[i], path)

                # Backtrack
                path.pop()

            
        rec(0, target, [])
        return res

"""
# Time Complexity: 2 ^ n
# Space Complexity: O(h) -> height of the stack
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def rec(pivot, target, path): 
            if target < 0 or pivot == len(candidates): 
                return 
            if target == 0: 
                res.append(path[:])
                return 

            for i in range(pivot, len(candidates)): 
                # Action
                path.append(candidates[i])

                # Recurse

                rec(i, target - candidates[i], path)

                # Backtrack
                path.pop()

            
        rec(0, target, [])
        return res

"""
