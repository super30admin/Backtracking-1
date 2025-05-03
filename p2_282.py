# 282. Expression Add Operators

# TC : O(4^n), where n is the length of the input string. For each position between digits, we have 4 choices: no operator, +, -, or *.
# SC : O(n) for the recursion stack and to store the expressions.
# Did this code successfully run on Leetcode : Yes

# Approach :
# This is a classic backtracking problem where we explore all possible ways to insert operators between digits.
# We use a recursive helper function backtrack with these parameters:
    # index: Current position in the input string
    # expr: Expression built so far
    # curr_val: Current calculated value of the expression
    # last_term: The last term added/subtracted (needed for handling multiplication precedence)
# Key aspects of the solution:
    # We handle operands without leading zeros as required.
    # We carefully manage operator precedence, especially for multiplication.
    # For multiplication, we need to undo the last addition/subtraction and apply the multiplication first.
    # We handle the first digit as a special case, since no operator is needed before it.
# The backtracking approach systematically explores all possible expressions and collects those that evaluate to the target value.

from ast import List


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        
        def backtrack(index, expr, curr_val, last_term):
            # Base case: if we've processed all digits
            if index == len(num):
                # Check if the expression evaluates to the target
                if curr_val == target:
                    result.append(expr)
                return
            
            # Get the current digit or sequence of digits
            for i in range(index, len(num)):
                # Skip leading zeros (avoid operands with leading zeros)
                if i > index and num[index] == '0':
                    break
                    
                # Extract the current operand as string and convert to int
                curr_str = num[index:i+1]
                curr_int = int(curr_str)
                
                # Case 1: First digit, no operator to add
                if index == 0:
                    backtrack(i+1, curr_str, curr_int, curr_int)
                else:
                    # Case 2: Add '+'
                    backtrack(i+1, expr + '+' + curr_str, curr_val + curr_int, curr_int)
                    
                    # Case 3: Add '-'
                    backtrack(i+1, expr + '-' + curr_str, curr_val - curr_int, -curr_int)
                    
                    # Case 4: Add '*' (handle multiplication precedence)
                    # We need to undo the last addition/subtraction and apply multiplication
                    # For example, if we have "2+3" and now add "*4", we get "2+3*4" = "2+(3*4)"
                    new_val = curr_val - last_term + (last_term * curr_int)
                    backtrack(i+1, expr + '*' + curr_str, new_val, last_term * curr_int)
        
        backtrack(0, "", 0, 0)
        return result