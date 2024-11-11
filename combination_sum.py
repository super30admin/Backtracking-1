class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # exhaustive way

        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, i, path):
        if target == 0:
            self.result.append(path)
            return
        if target < 0 or i == len(candidates):
            return

        # choose
        temp_path = [candidates[i]] + path
        self.helper(candidates, target - candidates[i], i, temp_path)

        # no choose
        self.helper(candidates, target, i + 1, path)

    # time complexity is O(n*2^m+n)
    # space complexity is O(n*2^m+n)


class Solution:
    # O-1 recursion
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, i, path):
        if target == 0:
            self.result.append(path.copy())
            return
        if target < 0 or i == len(candidates):
            return

        # choose
        path.append(candidates[i])
        self.helper(candidates, target - candidates[i], i, path)
        path.pop()

        # no choose
        self.helper(candidates, target, i + 1, path)


# time complexity is O(2^m+n)
# space complexity is O(m+n)


# different way of recursion with pivot and for loop where i moves
class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, pivot, path):

        if target < 0 or pivot == len(candidates):
            return
        if target == 0:
            self.result.append(path.copy())
        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(
                candidates, target - candidates[i], i, path
            )  # i remains same since it can be chosen with repitition
            path.pop()


# time complexity is O(2^m+n)
# space complexity is O(2^m+n)
