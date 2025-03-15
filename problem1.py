'''
// Time Complexity : O(lenth of candidates ^ target)
// Space Complexity : O(target)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(i, path, target):
            if target < 0 or i == len(candidates):
                return
            if target == 0:
                res.append(list(path))
                return
            
            for c in range(i, len(candidates)):
                cur = candidates[c]
                path.append(cur)
                dfs(c, path, target - cur)
                path.pop()

        dfs(0, [], target) 
        return res