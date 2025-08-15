# Time Complexity :  O(4ⁿ * n) — new copy of path at each of 4ⁿ calls.
# Space Complexity : O(n²) in the worst case for all path strings on the stack at once.
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach: This code generates all possible expressions by inserting +, -, or * between digits in num so that the evaluated result equals target. It uses backtracking, tracking the current calculation (calc), the last operand (tail) to handle multiplication precedence, and the expression string (path) being built.Leading zeros are avoided by breaking when a number chunk starts with "0", and valid expressions are added to self.result when all digits are used (pivot == len(num)) and calc equals target.

def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []

        def helper(num, target, pivot, calc, tail, path):
            if pivot == len(num):
                if calc == target:
                    self.result.append(path)

            for i in range(pivot, len(num)):
                if num[pivot] == "0" and i != pivot:
                    break
                curr = int(num[pivot: i + 1])

                if pivot == 0:
                    helper(num, target, i + 1, curr, curr, path + str(curr))
                else:
                    helper(num, target, i + 1, calc + curr, curr, path + "+" + str(curr))
                    helper(num, target, i + 1, calc - curr, -curr, path + "-" + str(curr))
                    helper(num, target, i + 1, calc - tail + (curr * tail), curr * tail, path + "*" + str(curr))


        helper(num, target, 0, 0, 0, "")
        return self.result 