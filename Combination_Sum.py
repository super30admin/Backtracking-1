# Time Complexity :  O(2^(m + n)) In 2^(m + n) 2 is present as each option has 2 choices and the totla height of the tree will be m + n.
# Space Complexity : O(n) As maximum no of calls on the heap stack can be n
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach:  This code finds all unique combinations of candidates whose sum equals target using backtracking. It builds each combination in path, starting from a given pivot index to avoid reusing earlier candidates and prevent duplicate permutations, and backtracks by removing the last number after exploring each choice. When target becomes exactly 0, it appends a copy of path to result; if target goes negative, that branch stops immediately.

def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return []
        result = []
        self.helper(result, candidates, [], 0, target)
        return result
    
    def helper(self, result, candidates, path, pivot, target):
        if target < 0:
            return
        if target == 0:
            result.append(path[:])
        
        for i in range(pivot, len(candidates)):
                path.append(candidates[i])
                self.helper(result, candidates, path, i, target - candidates[i])
                path.pop()