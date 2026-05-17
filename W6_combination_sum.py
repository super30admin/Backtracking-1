class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, target, 0, [])
        return self.result 

    def helper(self, candidates, target, i, path):
        if target < 0 or i == len(candidates):
            return
        
        if target == 0:
            self.result.append(list(path)) 
            return
        
        # Don't Choose
        self.helper(candidates, target, i + 1, path) # Deep copy path list

        # Choose
        path.append(candidates[i])

        self.helper(candidates, target - candidates[i], i, path) # Deep copy path list

        path.pop()

# Time complexity: O(2 ^ (m+n))
# Space complexity: O(n)

