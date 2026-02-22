''' 
Time Complexity: O(N^(T/M))
Where N is the number of candidates, T is the target, and M is the minimum candidate value. 

Space Complexity:  
Auxillary Space: O(D) 
Where D is the depth of the recursion stack. D = target / min(candidates) 
Output Space: O(K) 
Where K is the number of valid combinations.
'''

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        path = []
        res = []        

        def solve(sum, index):

            if sum > target:
                return

            if sum == target:
                res.append(path.copy())
                return

            for i in range(index, len(candidates)):
                if candidates[i] + sum <= target:
                    path.append(candidates[i])
                    solve(sum + candidates[i], i)
                    path.pop()

        solve(0,0)

        return res
