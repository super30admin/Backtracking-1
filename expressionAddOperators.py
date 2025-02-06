class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        # T: O(4 ** n), S: O(n)
        res = []

        def backtrack(index, expr, curr_val, last_operand):
            # Base case: If all digits are used
            if index == len(num):
                if curr_val == target:
                    res.append(expr)
                return

            # Try all possible number partitions
            for i in range(index, len(num)):
                # Avoid numbers with leading zeros
                if i > index and num[index] == "0":
                    break

                # Convert substring to integer
                val = int(num[index : i + 1])
                if index == 0:
                    # First number, just take it
                    backtrack(i + 1, expr + str(val), val, val)
                else:
                    # Addition
                    backtrack(i + 1, expr + "+" + str(val), curr_val + val, val)
                    # Subtraction
                    backtrack(i + 1, expr + "-" + str(val), curr_val - val, -val)
                    # Multiplication (adjust previous operand)
                    backtrack(
                        i + 1,
                        expr + "*" + str(val),
                        curr_val - last_operand + last_operand * val,
                        last_operand * val,
                    )

        backtrack(0, "", 0, 0)
        return res
