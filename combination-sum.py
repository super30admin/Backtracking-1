# Time Complexity : O(2^(m+n)) - n is the number of elements and m is the target sum
# Space Complexity : O(m + n) - n is the number of of elements and m is the target sum
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""

Recursion

0-1 recursion
For loop based recursion

"""

# 0-1 based recursion
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        self.result = []
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, index, paths):
        if target < 0 or index == len(candidates):
            return

        if target == 0:
            self.result.append(list(paths))
            return

        paths.append(candidates[index])
        self.helper(candidates, target - candidates[index], index, paths)
        paths.pop()
        self.helper(candidates, target, index + 1, paths)

# for loop based recursion
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        self.result = []
        self.helper(candidates, 0, target, [])
        return self.result

    def helper(self, candidates, pivot, target, paths):
        if target < 0 or pivot == len(candidates):
            return

        if target == 0:
            self.result.append(list(paths))
            return

        for i in range(pivot, len(candidates)):
            paths.append(candidates[i])
            self.helper(candidates, i, target - candidates[i], paths)
            paths.pop()



