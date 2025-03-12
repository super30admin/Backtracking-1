# Problem 2 : Expression Add Operators
# Time Complexity : O(3^n)
# Space Complexity : O(3^n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        # initialize the result list for storing the all the expression
        result = []

        # recursive function for calculating the expression
        # calculatedVal is the calculated value of the current expression till now
        # tail is the tail value of the pervious calculated value for previous expression (this is useful for mutliplication due to precedence over other) 
        def helper(num: str, result: list, target: int, currentExp: list, calculatedVal: int, tail:int, pivot: int) -> None:
            # base case
            # if the pivot is euqal to lenght of the num and also the calculated value of expression is equal to target
            if pivot == len(num) and calculatedVal == target:
                # if it is equal then append the current expression list to result
                result.append(''.join(currentExp))
                return
            
            # loop from pivot to lenght of num
            for i in range(pivot, len(num)):
                # to avoid numbers with leading zero
                if pivot != i and num[pivot] == '0':
                    break

                # get the number from pivot to i+1 position and convert to int for caluclation
                currentNum = int(num[pivot:i+1])
                # get the lenght of the current expression till now
                length = len(currentExp)

                # check if it is the first number by checking if pivot is equal to 0
                if pivot == 0:
                    # append the current number to current expression by converitng to string
                    currentExp.append(str(currentNum))
                    # call helper function 
                    helper(num, result, target, currentExp, currentNum, currentNum, i+1)
                    # backtracking logic to remove the currentNum and get the back the current expression state again
                    currentExp = currentExp[:length]

                else:
                    # addition case
                    # so add "+" and current num to the current expression
                    currentExp.append('+')
                    currentExp.append(str(currentNum))
                    # call helper function with calculate values as previous calculate value + current value 
                    # tail as current num
                    helper(num, result, target, currentExp, calculatedVal+currentNum, currentNum, i+1)
                    # backtracking logic to remove the currentNum and get the back the current expression state again
                    currentExp = currentExp[:length]

                    # subtraction case
                    # so add "-" and current num to the current expression
                    currentExp.append('-')
                    currentExp.append(str(currentNum))
                    # call helper function with calculate values as previous calculate value - current value 
                    # tail as -current num
                    helper(num, result, target, currentExp, calculatedVal-currentNum, -currentNum, i+1)
                    # backtracking logic to remove the currentNum and get the back the current expression state again
                    currentExp = currentExp[:length]

                    # multiplication case
                    # so add "*" and current num to the current expression
                    currentExp.append('*')
                    currentExp.append(str(currentNum))
                    # call helper function with calculate values as previous calculate value - tail value + tail value * current num
                    # tail as tail value * current num
                    helper(num, result, target, currentExp, calculatedVal-tail+tail*currentNum, tail*currentNum, i+1)
                    # backtracking logic to remove the currentNum and get the back the current expression state again
                    currentExp = currentExp[:length]

        helper(num, result, target, [], 0, 0, 0)
        return result