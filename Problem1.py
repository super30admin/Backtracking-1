"""
I implemented the solution using the 0-1 recursion technique, where at each step, I either choose the current candidate or skip it. This allows me to explore all possible combinations by branching on every decision. Since each candidate creates two recursive paths, the total number of recursive calls grows exponentially. 
Time Complexoty: O(2^n)
Space COmplesicty: O(2^n)
"""
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(i: int, amount: int, path: List[int]):
            # base case
            if amount == 0:
                result.append(path)
                return
            if amount < 0 or i == len(candidates):
                return

            # choose
            helper(i, amount - candidates[i], path + [candidates[i]])

            # not choose
            helper(i + 1, amount, list(path))

        helper(0, target, [])
        return result