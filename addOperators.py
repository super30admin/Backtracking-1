# Time Complexity : O(4^n), where n is the length of the string `num`
# Space Complexity : O(n), for the recursion stack and path building
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, handling multiplication required keeping track of previous operand

# I used backtracking to explore all possible ways to insert '+', '-', and '*' between digits.
# At each step, I tracked the current value, the last operand (to handle '*'), and the expression string so far.
# I also made sure to skip numbers with leading zeros.
# When I reached the end of the string, I checked if the expression evaluated to the target.

from typing import List

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []

        def backtrack(index, path, curr_val, prev_operand):
            if index == len(num):
                if curr_val == target:
                    result.append(path)
                return

            for i in range(index, len(num)):
                # Skip numbers with leading zeros
                if i != index and num[index] == '0':
                    break

                curr_str = num[index:i + 1]
                curr_num = int(curr_str)

                if index == 0:
                    # First number, just start the expression
                    backtrack(i + 1, curr_str, curr_num, curr_num)
                else:
                    # Addition
                    backtrack(i + 1, path + '+' + curr_str, curr_val + curr_num, curr_num)

                    # Subtraction
                    backtrack(i + 1, path + '-' + curr_str, curr_val - curr_num, -curr_num)

                    # Multiplication
                    backtrack(i + 1, path + '*' + curr_str,
                              curr_val - prev_operand + prev_operand * curr_num,
                              prev_operand * curr_num)

        backtrack(0, '', 0, 0)
        return result
