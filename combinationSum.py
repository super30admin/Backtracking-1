# BT approach --
# 1. We use choose/do-not-choose approach along with BT action-recurse-backtrack approach
# 2. In this approach we try all combinations and every time a combination does not work, we pop the combination elements
# 3. We then try another combination elements
# 4. We continue this till all elements are processed and all combinations are tried
# 5. We use different base cases to decide when a combination does not work --
#     a. If the achieved sum is negative
#     b. If we reach the end of list


class Solution:
    def __init__(self):
        self.rtnData = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates is None or len(candidates) == 0: return None

        self.helper(candidates, 0, [], target)

        return self.rtnData

    def helper(self, candidates, index, path, target):
        # base
        if target < 0 or index == len(candidates):
            return

        if target == 0:
            self.rtnData.append(path.copy())
            return

        # logic
        # case 0 or do not choose
        self.helper(candidates, index + 1, path, target)

        # case 1 or choose
        path.append(candidates[index])  # action
        self.helper(candidates, index, path, target - candidates[index])  # recurse
        path.pop()  # backtrack

