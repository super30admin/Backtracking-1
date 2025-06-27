# Time Complexity : O(4^n), where n is the length of the string (each position can branch with +, -, *, or no op)
# Space Complexity : O(n), for recursion depth and path storage
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Handling multiplication precedence and avoiding leading zeros

# Your code here along with comments explaining your approach

# I used backtracking to try all possible partitions and insert operators
# Tracked cumulative value and last multiplied operand to handle operator precedence

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []

        def backtrack(index, path, value, last):
            if index == len(num):
                if value == target:
                    result.append(path)
                return

            for i in range(index, len(num)):
                # Avoid numbers with leading zero
                if i != index and num[index] == '0':
                    break

                curr_str = num[index:i+1]
                curr = int(curr_str)

                if index == 0:
                    backtrack(i + 1, curr_str, curr, curr)
                else:
                    backtrack(i + 1, path + "+" + curr_str, value + curr, curr)
                    backtrack(i + 1, path + "-" + curr_str, value - curr, -curr)
                    backtrack(i + 1, path + "*" + curr_str, value - last + last * curr, last * curr)

        backtrack(0, "", 0, 0)
        return result
