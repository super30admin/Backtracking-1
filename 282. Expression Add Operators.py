# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(2^n)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - each expression will be added recursively
    - and then backtracked after using it in combination
    - fourth criteria be added to handle multiple digits
    '''
    def addOperators(self, num: str, target: int) -> List[str]:
        output = []
        N = len(num)

        def backtracking(index, prev, curr, value, expr):
            if index == N:
                # If the final value == target expected AND
                # no operand is left unprocessed
                if value == target and curr == 0 :
                    output.append("".join(expr[1:]))
                return
            curr = (curr * 10) + int(num[index])
            currStr = str(curr)
            # to handle digits post '0'
            if curr > 0:
                # handle of multiple digits
                backtracking(index+1, prev, curr, value, expr)
            
            # for addition
            expr.append('+')
            expr.append(currStr)
            backtracking(index+1, curr, 0, value+curr, expr)
            expr.pop()
            expr.pop()

            if expr:
                # for subtraction
                expr.append('-')
                expr.append(currStr)
                backtracking(index+1, -curr, 0, value-curr, expr)
                expr.pop()
                expr.pop()

                # for multiplication
                expr.append('*')
                expr.append(currStr)
                backtracking(index+1, prev*curr, 0, (value-prev)+(prev*curr), expr)
                expr.pop()
                expr.pop()

        backtracking(0, 0, 0, 0, [])
        return output