'''
1. We are using a for loop to iterate over the array. Since we have unlimited supply of numbers, we can use the same number again and again.
2. Recurse with same index and target - current number. Once a path is found, we backtrack and try with the next number. 
3. We break from a path if the target becomes negative. If target becomes 0, we have found a valid path and we add it to the result.

N = len(candidates), M = target, min_cand = min(candidates)
TC: O(N^(M/min_cand)) Since each candidate can produce a max depth of M/min_candidate length path and we have n such candidates
SC: O(M/min_cand) - recursion depth
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates or len(candidates) == 0:
            return []
        self.res = []

        self.recurse(candidates, 0 ,target, [])
        return self.res



    def recurse(self, candidates, index, target, path):
        # Base
        if target < 0:
            return
        if target == 0:
            self.res.append(path.copy())
            return


        # Logic
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.recurse(candidates,i,target-candidates[i], path)
            # Back track
            path.pop()

            




        