# Time Complexity: O(3^N * N)
# Space Complexity: O(N)

class Solution:
    def addOperators(self, num: str, target: int) -> list[str]:
        result = []
        num_length = len(num)

        def helper(start: int, expression: list[str], current_value: int, previous_value: int):
            # Base case: if we've processed the entire number
            if start >= num_length:
                if current_value == target:
                    result.append("".join(expression))
                return

            # Handle the first number
            if start == 0:
                if num[start] == '0':
                    helper(start + 1, expression + ['0'], 0, 0)
                else:
                    for i in range(start, num_length):
                        helper(i + 1, expression + [num[start:i + 1]], int(num[start:i + 1]), int(num[start:i + 1]))

            # Handle subsequent numbers
            else:
                if num[start] == '0':
                    helper(start + 1, expression + ['+'] + ['0'], current_value, 0)
                    helper(start + 1, expression + ['-'] + ['0'], current_value, 0)
                    helper(start + 1, expression + ['*'] + ['0'], current_value - previous_value, 0)
                else:
                    for i in range(start, num_length):
                        current_num = int(num[start:i + 1])
                        helper(i + 1, expression + ['+'] + [num[start:i + 1]], current_value + current_num, current_num)
                        helper(i + 1, expression + ['-'] + [num[start:i + 1]], current_value - current_num, -current_num)
                        helper(i + 1, expression + ['*'] + [num[start:i + 1]], current_value - previous_value + previous_value * current_num, previous_value
