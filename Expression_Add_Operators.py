# Approach: 
# We use a backtracking approach to explore all possible combinations of operators (+, -, *) between the digits. 
# We recursively try every operator between the digits and calculate the result of the expression. 
# We need to ensure that we handle the multiplication operator with precedence over addition and subtraction.
# We also need to take care not to have leading zeros in any operand.

# Time Complexity: O(4^N) where N is the length of the input string (since we have 3 choices for each space between digits).
# Space Complexity: O(N) where N is the length of the input string (used for recursion stack and result storage).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No major issues, but handling multiplication with precedence was tricky.

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []  # This will store the final valid expressions

        # Helper function to perform backtracking
        def backtrack(index, prev_operand, current_operand, value, expression):
            # Base case: if we've processed all digits, check if the value matches the target
            if index == len(num):
                if value == target:
                    result.append(expression)
                return
            
            # Recursive case: try all possible operators at the current position
            for i in range(index + 1, len(num) + 1):
                # Extract the current substring
                curr = num[index:i]
                
                # Skip substrings that have leading zeros
                if len(curr) > 1 and curr[0] == '0':
                    continue
                
                # Convert current substring to integer
                current_num = int(curr)
                
                # Case 1: Addition
                if index == 0:
                    backtrack(i, current_num, 0, current_num, curr)  # No operator at the start
                else:
                    # Case 2: Addition
                    backtrack(i, current_num, 0, value + current_num, expression + '+' + curr)
                    # Case 3: Subtraction
                    backtrack(i, -current_num, 0, value - current_num, expression + '-' + curr)
                    # Case 4: Multiplication
                    backtrack(i, prev_operand * current_num, current_operand * current_num, value - prev_operand + prev_operand * current_num, expression + '*' + curr)

        # Start backtracking from the first digit
        backtrack(0, 0, 0, 0, "")
        return result
