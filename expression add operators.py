'''
Solution : DFS with backtraking
    - with each number you get try 
        - [nothing, move to next digit and make it multi digit number]
        - ' + current number'
        - ' - current number'
        - ' * current number'
        - Caveat:
            - flow of recursion: previous +/-/* currentnumber
            - So at when pivot is 0, we need to skip as we dont need
                - +1+2+3 or -1+2+3 or *1+2+3 
    - for backtracking, path is maintained inside the list else, if we just pass it as 
      string, it will be primitive variable, and will create a new copy of string-copy 
      previous string and add character to this newly created string. 
    - Operations handling: Maintain calculated & tail
        - Addition: 
            calculated = calculated + current number
            tail = current number
        - Subtraction:
            calculated = calculated - current number
            tail = -current number
        - Multiplication:
            calculated = calculated-tail + tail*current number
            tail = tail*current number
    - Edge case:
        - Zero-parsing: eg, 105, 1002, 
        - when pivot is at 0, then at this line of code,
                - current_number = int(num[pivot_index:digit_index+1]) # from string 
            - current number will be (error vs desired)
                - 0 vs 0 - OK
                - 0 vs 00 - Not OK
                - 2 vs 002 - Not OK
        - so we skip when pivot_index is at 0 and digit_index in for loop is beyond pivot 
Time Complexity: O(4^N), N =length of string
Space Complexity: O(N), height of recursive stack

'''    


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        valid_expressions = [] # to store the answer
        # for passing path string as stringbuilder, using list with 1 element. 
        self.helper(num, 0, target, 0, 0, [] ,valid_expressions)  

        return valid_expressions


    def helper(self, num, pivot_index, target, calculated_value, tail, path ,valid_expressions):
        # base
        if pivot_index==len(num):
            if calculated_value == target:
                valid_expressions.append(''.join(deepcopy(path)))
            return

        # logic
        for digit_index in range(pivot_index, len(num)):
            if num[pivot_index]=='0' and digit_index!=pivot_index: # edge case, eg. 105
                continue
            current_number = int(num[pivot_index:digit_index+1]) # from string 
            size_before_action = len(path) # for later use for backtrack

            if pivot_index == 0:
                path.append(str(current_number)) # action
                self.helper(num, digit_index+1, target, current_number, current_number, path ,valid_expressions)
                path = path[:size_before_action] # recurse for this action
            else:            
                # + sign
                path.append('+') # action
                path.append(str(current_number)) 
                self.helper(num, digit_index+1, target, calculated_value+current_number, current_number, path ,valid_expressions)
                path= path[:size_before_action] # backtrack, remove ' +current number'
                
                # - sign
                path.append('-') # action
                path.append(str(current_number)) 
                self.helper(num, digit_index+1, target, calculated_value-current_number, -current_number, path ,valid_expressions)
                path= path[:size_before_action] # backtrack, remove ' -current number'
                
                # * sign
                path.append('*') # action
                path.append(str(current_number)) 
                self.helper(num, digit_index+1, target, calculated_value-tail+tail*current_number, tail*current_number, path ,valid_expressions)
                path = path[:size_before_action] # backtrack, remove ' *current number'
                
'''
Solution2 : Passing path as string. Creates a new string at each node
            copies the previous string and append a character to it.
'''
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        valid_expressions = [] # to store the answer
        # for passing path string as stringbuilder, using list with 1 element. 
        self.helper(num, 0, target, 0, 0, "" ,valid_expressions)  

        return valid_expressions


    def helper(self, num, pivot_index, target, calculated_value, tail, path ,valid_expressions):
        # base
        if pivot_index==len(num):
            if calculated_value == target:
                valid_expressions.append(deepcopy(path))
            return

        # logic
        for digit_index in range(pivot_index, len(num)):
            if num[pivot_index]=='0' and digit_index!=pivot_index: # edge case, eg. 105
                continue
            current_number = int(num[pivot_index:digit_index+1]) # from string 
            size_before_action = len(path) # for later use for backtrack

            if pivot_index == 0:
                path+=str(current_number) # action
                self.helper(num, digit_index+1, target, current_number, current_number, path ,valid_expressions)
                path = path[:size_before_action] # recurse for this action
            else:            
                # + sign
                path+='+' # action
                path+=str(current_number) 
                self.helper(num, digit_index+1, target, calculated_value+current_number, current_number, path ,valid_expressions)
                path = path[:size_before_action] # backtrack, remove ' +current number'
                
                # - sign
                path+='-' # action
                path+=str(current_number) 
                self.helper(num, digit_index+1, target, calculated_value-current_number, -current_number, path ,valid_expressions)
                path = path[:size_before_action] # backtrack, remove ' -current number'
                
                # * sign
                path+='*' # action
                path+=str(current_number) 
                self.helper(num, digit_index+1, target, calculated_value-tail+tail*current_number, tail*current_number, path ,valid_expressions)
                path = path[:size_before_action] # backtrack, remove ' *current number'
                
                
