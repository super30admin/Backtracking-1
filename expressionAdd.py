"""
TC: O(n*4^n-1)
At each index in the string, one can either:
Append an operator (+, -, * or Move to the next digit to form a multi-digit number.
This gives approximately 4^n-1 combinations (n-1) positions between digits.
it takes n time to evaluate expression at each combination

SP: O(n)
"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        ops = ["+", "-", "*"]  
        result = []
        def dfs(index, expression):
            # if we've reached the end of the string, evaluate the expression
            if index == len(num):
                if eval("".join(expression))== target:
                    result.append("".join(expression))
                return
            # Iterate through the remaining string and all operator options
            for i in range(index, len(num)):
                # get the current number
                current_num = num[index:i + 1]
                # Skip numbers with leading zeros
                if len(current_num) > 1 and current_num[0] == "0":
                    continue
                # no operator for the first number
                if index == 0:
                    expression.append(current_num)

                    dfs(i + 1,expression)
                    expression.pop()
                else:
                    for op in ops:
                        expression.append(op)
                        expression.append(current_num)
                        dfs(i + 1, expression)
                        expression.pop()
                        expression.pop()

        dfs(0, [])
        return result
