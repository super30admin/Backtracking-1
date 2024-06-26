# Time Complexity : O(4^n)
# Space Complexity : O(n)
class Solution:
    def addOperators(self, num: str, target: int):
        def recurse(num, target, index, calc, tail, path):
            # base case
            if index == len(num):
                if calc == target:
                    result.append("".join(path))
                return

            # logic
            for i in range(index, len(num)):
                # Preceding zero case
                if num[index] == '0' and index != i:
                    continue

                cur = int(num[index:i + 1])
                len_path = len(path)

                if index == 0:
                    path.append(str(cur))
                    recurse(num, target, i + 1, cur, cur, path)
                    path.pop()  # backtrack
                else:
                    # Addition
                    path.append("+")
                    path.append(str(cur))
                    recurse(num, target, i + 1, calc + cur, cur, path)
                    path.pop()  # backtrack operator
                    path.pop()  # backtrack

                    # Subtraction
                    path.append("-")
                    path.append(str(cur))
                    recurse(num, target, i + 1, calc - cur, -cur, path)
                    path.pop()  # backtrack operator
                    path.pop()  # backtrack

                    # Multiplication
                    path.append("*")
                    path.append(str(cur))
                    recurse(num, target, i + 1, calc - tail + tail * cur, tail * cur, path)
                    path.pop()  # backtrack operator
                    path.pop()  # backtrack

        result = []
        if not num:
            return result

        recurse(num, target, 0, 0, 0, [])
        return result

# Example usage:
solution = Solution()

# Example 1
num1 = "123"
target1 = 6
print(solution.addOperators(num1, target1))
# Output: ["1+2+3", "1*2*3"]

# Example 2
num2 = "232"
target2 = 8
print(solution.addOperators(num2, target2))
# Output: ["2*3+2", "2+3*2"]

# Example 3
num3 = "105"
target3 = 5
print(solution.addOperators(num3, target3))
# Output: ["1*0+5", "10-5"]

# Example 4
num4 = "3456237490"
target4 = 9191
print(solution.addOperators(num4, target4))
# Output: []