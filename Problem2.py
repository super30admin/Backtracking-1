# This is a bactracking approach where I am checking all operators and recursively calling and bactracking
# TC: O(4 ^ N) - exponential
# SC: O(N) - recursion stack space


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []
        if len(num) == 0:
            return []

        def recurse(num, target, index, calc, tail, path):
            # Base
            if index == len(num):
                if calc == target:
                    res.append(path)
                return


            # Logic
            for i in range(index, len(num)):
                curr_str = num[index:i + 1]

                if len(curr_str) > 1 and curr_str[0] == '0':
                    continue

                curr = int(curr_str)

                if index == 0:
                    recurse(num, target, i + 1, curr, curr, path + curr_str)
                else:
                    # +
                    recurse(num, target, i + 1, calc + curr, +curr, path + "+" + curr_str)
                    # -
                    recurse(num, target, i + 1, calc - curr, -curr, path + "-" + curr_str)
                    # *
                    recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr_str)

        recurse(num, target, 0, 0, 0, "")
        return res
