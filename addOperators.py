def addOperators(num, target):
    result = []
    
    def backtrack(index, prev_operand, current_operand, value, expression):
        # If we have reached the end of the string, evaluate the expression.
        if index == len(num):
            if value == target and current_operand == 0:
                result.append("".join(expression[1:]))  # Skip the first dummy operator
            return
        
        # Start building the current operand by including the current digit
        current_operand = current_operand * 10 + int(num[index])
        str_operand = str(current_operand)
        
        # To avoid numbers with leading zeroes
        if current_operand > 0:
            # NO OP recursion
            backtrack(index + 1, prev_operand, current_operand, value, expression)
        
        # ADDITION
        expression.append('+')
        expression.append(str_operand)
        backtrack(index + 1, current_operand, 0, value + current_operand, expression)
        expression.pop()
        expression.pop()
        
        # We can subtract or multiply only if there is something to subtract/multiply
        if expression:
            # SUBTRACTION
            expression.append('-')
            expression.append(str_operand)
            backtrack(index + 1, -current_operand, 0, value - current_operand, expression)
            expression.pop()
            expression.pop()
            
            # MULTIPLICATION
            expression.append('*')
            expression.append(str_operand)
            backtrack(index + 1, prev_operand * current_operand, 0, value - prev_operand + (prev_operand * current_operand), expression)
            expression.pop()
            expression.pop()
    
    # Initiate backtracking with an empty expression
    backtrack(0, 0, 0, 0, [])
    return result

# Example Usage
num = "123"
target = 6
print(addOperators(num, target))  # Output: ["1+2+3", "1*2*3"]
