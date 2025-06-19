# Time Complexity: O(4^n), where n is the length of the input string `num`
#   - At each digit, we branch into 3 possibilities: '+', '-', '*'
#   - Plus slicing and integer conversion cost
# Space Complexity: O(n) recursion depth and O(n) space per expression (max)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        # Functional style DFS (no mutation)
        res = []
        n = len(num)

        def dfs(index, expr, value, prev):
            if index == n:
                if value == target:
                    res.append(expr)
                return
            
            curr_num = 0
            for i in range(index, n):
                # Skip numbers with leading zero, but allow single "0"
                if i > index and num[index] == '0':
                    break

                curr_str = num[index:i+1]
                curr_num = int(curr_str)

                if index == 0:
                    dfs(i + 1, curr_str, curr_num, curr_num)
                else:
                    dfs(i + 1, expr + '+' + curr_str, value + curr_num, curr_num)
                    dfs(i + 1, expr + '-' + curr_str, value - curr_num, -curr_num)
                    dfs(i + 1, expr + '*' + curr_str, value - prev + prev * curr_num, prev * curr_num)

        dfs(0, "", 0, 0)
        return res

        # --------------------------------------
        # Alternative: Explicit backtracking with mutation (append/pop)
                # Time Complexity: O(4^n), where n is the number of digits in `num`
        #   - For each digit, we try all possible splits and operators: '+', '-', '*'
        #   - At most 3 branches per position and n possible splits → exponential combinations
        #
        # Space Complexity: 
        #   - O(n) for recursion stack (max depth = number of digits)
        #   - O(n) for building each expression (list `expr`)
        #   - Result space not included in complexity (can be large depending on output size)


        # res = []
        # def dfs(i, expr, value, prev):
        #     if i == len(num):
        #         if value == target:
        #             res.append("".join(expr))
        #         return
        #     for j in range(i, len(num)):
        #         if j > i and num[i] == '0':
        #             break
        #         curr_str = num[i:j+1]
        #         curr_num = int(curr_str)
        #         if i == 0:
        #             expr.append(curr_str)
        #             dfs(j+1, expr, curr_num, curr_num)
        #             expr.pop()
        #         else:
        #             for op in ['+', '-', '*']:
        #                 expr.append(op)
        #                 expr.append(curr_str)
        #                 if op == '+':
        #                     dfs(j+1, expr, value + curr_num, curr_num)
        #                 elif op == '-':
        #                     dfs(j+1, expr, value - curr_num, -curr_num)
        #                 else:
        #                     dfs(j+1, expr, value - prev + prev * curr_num, prev * curr_num)
        #                 expr.pop()
        #                 expr.pop()
        # dfs(0, [], 0, 0)
        # return res


if __name__ == "__main__":
    sol = Solution()
    print(sol.addOperators("123", 6))       # Output: ["1+2+3", "1*2*3"]
    print(sol.addOperators("232", 8))       # Output: ["2*3+2", "2+3*2"]
    print(sol.addOperators("105", 5))       # Output: ["1*0+5", "10-5"]
    print(sol.addOperators("00", 0))        # Output: ["0+0", "0-0", "0*0"]
    print(sol.addOperators("3456237490", 9191))  # Output: []
