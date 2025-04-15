from typing import List

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        """
        Given a string 'num' containing only digits and an integer 'target', 
        this function returns all possible combinations of 'num' with binary 
        operators ('+', '-', '*') inserted between digits so that the resulting 
        expression evaluates to the target value.

        ------------------------------
        Complexity Analysis
        ------------------------------

        Let:
        - N = length of the input string `num`

        Time Complexity: O(N × 4^N)
            - At each index, we have up to 4 choices: insert '+', '-', '*', or extend the current number.
            - This forms a recursion tree with up to 4^N nodes.
            - For each valid expression, constructing the string takes O(N) time.
            - Hence, total time is O(N × 4^N).

        Space Complexity: O(N)
            - O(N) for the recursion stack depth in the worst case (one digit per level).
            - O(N) for the temporary string building (path).
            - Final result list is not included in auxiliary space.

        Note:
        - Expressions with leading zeros (e.g., "05") are skipped.
        - Multiplication is handled using a 'tail' variable to correctly apply operator precedence.
        """
        result = []

        def helper(num: str, target: int, path: str, pivot: int, tail: int, calval: int):
            # Base case: if we've consumed all digits
            if pivot == len(num):
                if calval == target:
                    result.append(path)
                return

            for i in range(pivot, len(num)):
                # Avoid numbers with leading zeros
                if i != pivot and num[pivot] == '0':
                    break

                curr_str = num[pivot:i + 1]
                curr_num = int(curr_str)

                if pivot == 0:
                    # First number in expression: no operator before it
                    helper(num, target, curr_str, i + 1, curr_num, curr_num)
                else:
                    # Addition
                    helper(num, target, path + "+" + curr_str, i + 1, curr_num, calval + curr_num)
                    # Subtraction
                    helper(num, target, path + "-" + curr_str, i + 1, -curr_num, calval - curr_num)
                    # Multiplication
                    helper(num, target, path + "*" + curr_str, i + 1, tail * curr_num, calval - tail + tail * curr_num)

        helper(num, target, "", 0, 0, 0)
        return result


from typing import List

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        """
        Given a string 'num' containing only digits and an integer 'target',
        returns all valid expressions by adding '+', '-', or '*' between the digits
        such that the expression evaluates to the target value.

        ------------------------------
        StringBuilder-style Backtracking
        ------------------------------

        Time Complexity: O(N × 4^N)
        Space Complexity: O(N)

        - This version uses a list to simulate Java's StringBuilder,
          reducing the cost of string concatenation during recursion.
        """
        result = []

        def helper(sb: List[str], pivot: int, tail: int, calval: int):
            if pivot == len(num):
                if calval == target:
                    result.append(''.join(sb))
                return

            for i in range(pivot, len(num)):
                # Skip numbers with leading zero
                if i != pivot and num[pivot] == '0':
                    break

                curr_str = num[pivot:i + 1]
                curr_num = int(curr_str)
                len_before = len(sb)

                if pivot == 0:
                    # First number, just add it
                    sb.append(curr_str)
                    helper(sb, i + 1, curr_num, curr_num)
                    del sb[len_before:]  # backtrack
                else:
                    # Addition
                    sb.append('+')
                    sb.append(curr_str)
                    helper(sb, i + 1, curr_num, calval + curr_num)
                    del sb[len_before:]  # backtrack

                    # Subtraction
                    sb.append('-')
                    sb.append(curr_str)
                    helper(sb, i + 1, -curr_num, calval - curr_num)
                    del sb[len_before:]  # backtrack

                    # Multiplication
                    sb.append('*')
                    sb.append(curr_str)
                    helper(sb, i + 1, tail * curr_num, calval - tail + tail * curr_num)
                    del sb[len_before:]  # backtrack

        helper([], 0, 0, 0)
        return result
