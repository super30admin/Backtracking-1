class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []

        def dfs(index, prev_operand, current_operand, value, expression):
            # Base case: if we've reached the end of the string
            if index == len(num):
                if value == target:
                    res.append(expression)
                return

            for i in range(index + 1, len(num) + 1):
                # Get the current operand
                curr_str = num[index:i]
                # Avoid numbers with leading zeroes, except for "0"
                if len(curr_str) > 1 and curr_str[0] == '0':
                    continue

                curr_num = int(curr_str)

                # Perform addition
                if index == 0:
                    # The first number does not need an operator before it
                    dfs(i, curr_num, curr_num, curr_num, curr_str)
                else:
                    # Recursively handle addition, subtraction, and multiplication
                    dfs(i, curr_num, current_operand + curr_num, value + curr_num, expression + '+' + curr_str)
                    dfs(i, -curr_num, current_operand - curr_num, value - curr_num, expression + '-' + curr_str)
                    dfs(i, prev_operand * curr_num, current_operand * curr_num, value + prev_operand * (curr_num - 1), expression + '*' + curr_str)

        dfs(0, 0, 0, 0, "")
        return res
