#The function combinationSum takes a list of candidates and a target sum as input and returns all unique combinations of candidates that sum up to the target. The backtrack function is used to explore possible combinations recursively. Starting with an empty list curr, the function adds candidates one by one, ensuring that the sum of the current combination does not exceed the target. If the sum matches the target, the current combination is added to the result list. If the sum exceeds the target, the function returns. The process continues by adding each candidate and recursively calling backtrack with the updated list. After exploring each possibility, the last added candidate is removed (backtracking) to explore other combinations. The complexity of this algorithm is O(N^(T/M)) in the worst case, where N is the number of candidates, T is the target value, and M is the smallest candidate value. The space complexity is O(T/M) due to the depth of the recursion stack.

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def backtrack(curr, first_idx):

            if sum(curr) == target:
                result.append(curr[:])
            
            if sum(curr)>target:
                return

            for idx in range(first_idx, len(candidates)):
                curr.append(candidates[idx])
                backtrack(curr, idx) 
                curr.pop()
            
            return
        
        result = []
        backtrack([], 0)
        return result

        