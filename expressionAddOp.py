"""
For each digit, try splitting and inserting '+', '-', or '*' operators.
Check current total, previous operand (for '*'), and current expression.
Apply backtracking to explore all paths, and prune invalid ones (like leading 0s).
"""
"""
Time Complexity: O(4^n) - Each digit can branch into 3 operator options
Space Complexity: O(n) Recursion stack depth
"""

from typing import List

class expressionAddOp:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []

        def backtrack(index, path, value, prev):
            if index == len(num):
                if value == target:
                    result.append(path)
                return

            for i in range(index, len(num)):
             
                if i != index and num[index] == '0':
                    break

                curr_str = num[index:i+1]
                curr = int(curr_str)

                if index == 0:
                  
                    backtrack(i + 1, curr_str, curr, curr)
                else:
                  
                    backtrack(i + 1, path + '+' + curr_str, value + curr, curr)
                 
                    backtrack(i + 1, path + '-' + curr_str, value - curr, -curr)
                  
                    backtrack(i + 1, path + '*' + curr_str, value - prev + prev * curr, prev * curr)

        backtrack(0, "", 0, 0)
        return result

if __name__ == "__main__":
    obj = expressionAddOp()
    print(obj.addOperators("123", 6))     
    print(obj.addOperators("232", 8))     
    print(obj.addOperators("105", 5))    
    print(obj.addOperators("00", 0))      
