"Time Complexity is O(4^N)"
"Space Complexity is O(N)"

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []

        def helper(index, prev_operand, current_value, path):
            # Base case: if we've processed the entire string
            if index == len(num):
                # If the current value equals the target, add the expression to result
                if current_value == target:
                    result.append(path)
                return

            # Logic: iterate through the string and form numbers
            for i in range(index, len(num)):
                # Skip numbers with leading zeros
                if i > index and num[index] == '0':
                    break

                # Extract the current number
                current_num = int(num[index:i+1])

                if index == 0:
                    # First number in the expression, no operator needed
                    helper(i + 1, current_num, current_num, path + str(current_num))
                else:
                    # Addition
                    helper(i + 1, current_num, current_value + current_num, path + "+" + str(current_num))

                    # Subtraction
                    helper(i + 1, -current_num, current_value - current_num, path + "-" + str(current_num))

                    # Multiplication
                    helper(i + 1, prev_operand * current_num, current_value - prev_operand + (prev_operand * current_num), path + "*" + str(current_num))

        # Start the recursion
        helper(0, 0, 0, "")
        return result
