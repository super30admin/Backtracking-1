from typing import List
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []

        def helper(i, curr, calc, tail, path):
            if i == len(num):
                if calc == target and curr == 0:
                    self.result.append(path)
                return

            curr = curr * 10 + int(num[i])

            if curr > 0:
                helper(i + 1, curr, calc, tail, path)

            if not path:
                helper(i + 1, 0, curr, curr, path + str(curr))
            else:
                helper(i + 1, 0, calc + curr, curr, path + "+" + str(curr))
                helper(i + 1, 0, calc - curr, -curr, path + "-" + str(curr))
                helper(i + 1, 0, calc - tail + (tail * curr), tail * curr, path + "*" + str(curr))

        helper(0, 0, 0, 0, "")
        return self.result

# TC - O(4^n)
# SC - O(n)