# Time Complexity : O(4^n) nested recursion
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The approach is to split the numbers first and then for each number we have 3 options(+,- and *).
# To do the calculation as runtime, we can use calc and tail which is the previous change to have the consideration of multiplication
# as we have to give precedence to * before + and -


class Solution:
    def addOperatorsRecursion(self, num: str, target: int) -> List[str]:
        result = []

        def helper(pivot, calc, tail, path):

            if pivot == len(num):
                if target == calc:
                    result.append(path)
                return
            # logic
            for i in range(pivot, len(num)):
                # Preceding 0
                if (i != pivot and num[pivot] == '0'): continue
                curr = int(num[pivot:i + 1])
                if (pivot == 0):
                    helper(i + 1, curr, curr, path + str(curr))
                else:
                    # three options
                    # +
                    helper(i + 1, calc + curr, +curr, path + "+" + str(curr))
                    # -
                    helper(i + 1, calc - curr, -curr, path + "-" + str(curr))
                    # *
                    helper(i + 1, calc - tail + tail * curr, tail * curr, path + "*" + str(curr))

        helper(0, 0, 0, "")

        return result

# The time and space complexity is same. Just a bit of optimization using the path as list and later join before adding it to the result
# Also because of that we have to do backtracking.
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []

        def helper(pivot, calc, tail, path):
            # Base case
            if pivot == len(num):
                if target == calc:
                    result.append("".join(path))
                return
            # logic
            for i in range(pivot, len(num)):
                # Preceding 0
                if (i != pivot and num[pivot] == '0'): continue
                curr = int(num[pivot:i + 1])
                if (pivot == 0):
                    path.append(str(curr))
                    helper(i + 1, curr, curr, path)
                    path.pop()
                else:
                    # three options
                    # +
                    path.append("+")
                    path.append(str(curr))
                    helper(i + 1, calc + curr, +curr, path)
                    path.pop()
                    path.pop()
                    # -
                    path.append("-")
                    path.append(str(curr))
                    helper(i + 1, calc - curr, -curr, path)
                    path.pop()
                    path.pop()
                    # *
                    #action
                    path.append("*")
                    path.append(str(curr))
                    #recurse
                    helper(i + 1, calc - tail + tail * curr, tail * curr, path)
                    #backtrack
                    path.pop()
                    path.pop()

        helper(0, 0, 0, [])

        return result