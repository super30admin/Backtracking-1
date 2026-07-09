## Problem2
# Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)
class Solution:
    """
    Time Complexity: O(N * 4^N)
    - For a string of length N, there are N-1 spaces between digits.
    - At each space, we can make 1 of 4 choices: No operator (extend the number), '+', '-', or '*'.
    - This gives an upper bound of 4^(N-1) valid expressions.
    - At each step, string concatenation takes O(N) time.
    - Thus, the total time complexity is bounded by O(N * 4^N).

    Space Complexity: O(N) auxiliary space
    - The maximum depth of the recursion tree is N (when we process one digit at a time).
    - At each recursive call, the intermediate string `path` takes O(N) space.
    - (Note: If we count the memory required to store the final `result` array, 
      the total space would be O(N * 4^N) in the worst case).
    """
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        
        # pivot: the current index in 'num' we are processing
        # path:  the string expression we have built so far
        # calc:  the total evaluated value of the 'path' expression
        # tail:  the last term added to 'calc' (needed to respect multiplication precedence)
        def helper(pivot, path, calc, tail):
            
            # Base Case: We have consumed all digits in the string
            if pivot == len(num):
                # If the evaluated expression matches our target, add it to results
                if calc == target:
                    result.append(path)
                return
            
            # Try exploring all possible next numbers by slicing from 'pivot' to 'i'
            for i in range(pivot, len(num)):
                
                # Logic: Prevent numbers with leading zeros (e.g., "05", "00")
                # If the slice starts with '0' and we try to extend it beyond length 1, 
                # it's invalid. We break because any longer slice will also be invalid.
                if i > pivot and num[pivot] == '0':
                    break
                    
                # Extract the current substring and convert it to an integer
                currStr = num[pivot:i+1]
                currInt = int(currStr)
                
                # Logic: If we are at the very start of the string, we can't place 
                # an operator before the first number. We just initialize the state.
                if pivot == 0:
                    helper(i + 1, currStr, currInt, currInt)
                else:
                    # Choice 1: Addition
                    # Add currInt to the total calculation. The new tail is just currInt.
                    helper(i + 1, path + "+" + currStr, calc + currInt, currInt)
                    
                    # Choice 2: Subtraction
                    # Subtract currInt from the calculation. The new tail is -currInt.
                    helper(i + 1, path + "-" + currStr, calc - currInt, -currInt)
                    
                    # Choice 3: Multiplication
                    # Multiplication has higher precedence! We must "undo" the last addition/subtraction
                    # by subtracting 'tail' from 'calc', then we add the multiplied result of (tail * currInt).
                    # The new tail for the next operation becomes (tail * currInt).
                    helper(i + 1, path + "*" + currStr, (calc - tail) + (tail * currInt), tail * currInt)

        # Edge Case: Only start backtracking if the input string is not empty
        if num:
            helper(0, "", 0, 0)
            
        return result