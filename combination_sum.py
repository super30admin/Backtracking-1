"""
Approach1: choose- not choose recursive approach.  Where you include the ith index in the path and call the helper.
since the numbers can be repeated, the index remains the same. For the not choose case nothing is added to the path,
 and the index is incremented.
Note: finding the sum of numbers in path on every recursive call is compute intensive. Thus, substract the ith index
number from the target.
Include the target < 0 into the base case, else error max depth recursion reached.

Path is going in as a reference, thus there are 2 ways to handel it: create a deep copy of the path at every recursive call.
OR use backtracking. There are 2 ways to create a deep copy: deep copy while passing in arguments and first create
deep copy and then pass it as argument.
creating a deep copy is compute and space intensive.

TC: O(2^(m+n))

approach2: for loop based recursion
the not choose case is taken care by "for idx in range(pivot, len(candidates)): when idx goes to idx+1".
"""


class Solution_for_lopp_based:

    def helper(self, candidates, pivot, path, target):

        # base case
        if target < 0:
            return

        # logic
        if target == 0:
            self.ans.append(path[:])

        for idx in range(pivot, len(candidates)):
            path.append(candidates[idx])
            # the number can be repeated then thus idx remain same 
            self.helper(candidates, idx, path, target - candidates[idx])
            path.pop()

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.ans = []
        self.helper(candidates, 0, [], target)
        return self.ans


class Solution_choose_not_choose_backtracking:

    def helper(self, candidates, idx, path, target):

        # base case
        if idx >= len(candidates) or target < 0:
            return

        # logic
        if target == 0:
            temp = path[:]
            self.ans.append(temp)
            return

            # not choose
        self.helper(candidates, idx + 1, path, target)

        # choose
        path.append(candidates[idx])
        self.helper(candidates, idx, path, target - candidates[idx])
        path.pop()

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.ans = []
        self.helper(candidates, 0, [], target)
        return self.ans


class Solution_choose_not_choose_no_backtrack:

    def helper(self, candidates, idx, path, target):

        # base case
        if idx >= len(candidates) or target < 0:
            return

        # logic
        if target == 0:
            self.ans.append(path)
            return

            # not choose
        temp_path = path[:]
        self.helper(candidates, idx + 1, temp_path, target)

        # choose
        temp_path.append(candidates[idx])
        self.helper(candidates, idx, temp_path, target - candidates[idx])

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.ans = []
        self.helper(candidates, 0, [], target)
        return self.ans

