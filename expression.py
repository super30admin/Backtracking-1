# The addOperators method finds all valid expressions formed by adding operators (+, -, *) to a number string to meet a target value.

# Step 1: Backtracking Helper
#   - Recursively explore all possible expressions:
#       - If at the end of the string and total equals target, add the expression to results.
#       - Use operators (+, -, *) to build new expressions and update the total and last values.
#       - Stop further splitting if the current number is 0.

# Step 2: Initialization
#   - Initialize 'ans' as a set to store valid expressions.
#   - Call backtracking with initial values (index 0, total 0, and empty expression).

# Step 3: Return Results
#   - Convert 'ans' to a list and return.

# TC: O(4^n) - Each digit can branch into multiple operations.
# SC: O(n) - Space for recursion stack and expressions.


from typing import List


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        L = len(num)
        ans = set()
        
        def backtrack(i, total, last, expr):
            if i == L:
                if total == target:
                    ans.add(expr)
                return
            
            for j in range(i, L):
                n = int(num[i:j+1])
                if i == 0:
                    backtrack(j+1, n, n, str(n))
                else:
                    backtrack(j+1, total + n, n, expr + '+' + str(n))
                    backtrack(j+1, total - n, -n, expr + '-' + str(n))
                    backtrack(j+1, total - last + last * n, last * n, expr + '*' + str(n))
                if n == 0:
                    break
                    
        backtrack(0, 0, 0, '')
        return list(ans)