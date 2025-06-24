
# Approach:
# - Use backtracking to explore every possible way to insert '+', '-', '*'.
# - At each step:
#     - Take the current number slice (avoid leading zeros).
#     - Recursively explore adding each operator with updated path and cumulative value.
#     - Handle multiplication carefully with a `prev_operand` to apply precedence.

# Time Complexity:
# - Worst case: O(4^n), since each digit may branch into 3 operations (plus, minus, multiply)

# Space Complexity:
# - O(n) for recursion stack and path

class Solution:
    def addOperators(self, num, target):
        res = []

        def backtrack(index, path, calc, tail):
            if index == len(num):
                if calc == target:
                    res.append(path)
                return

            for i in range(index, len(num)):
                if i != index and num[index] == '0':
                    break

                curr_str = num[index:i+1]
                curr_num = int(curr_str)

                if index == 0:
                    backtrack(i+1, curr_str, curr_num, curr_num)
                else:
                    backtrack(i+1, path + "+" + curr_str, calc + curr_num, curr_num)
                    backtrack(i+1, path + "-" + curr_str, calc - curr_num, -curr_num)
                    backtrack(i+1, path + "*" + curr_str, calc - tail + (tail * curr_num), tail * curr_num)

        backtrack(0, "", 0, 0)
        return res

def main():
    sol = Solution()
    num = "123"
    target = 6
    print(f"Expressions for num = '{num}', target = {target}:")
    print(sol.addOperators(num, target))  # ['1+2+3', '1*2*3']

if __name__ == "__main__":
    main()
