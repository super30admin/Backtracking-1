# ## Problem2
# Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

# Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

# Example 1:

# Input: num = "123", target = 6
# Output: ["1+2+3", "1*2*3"] 
# Example 2:

# Input: num = "232", target = 8
# Output: ["2*3+2", "2+3*2"]
# Example 3:

# Input: num = "105", target = 5
# Output: ["1*0+5","10-5"]
# Example 4:

# Input: num = "00", target = 0
# Output: ["0+0", "0-0", "0*0"]
# Example 5:

# Input: num = "3456237490", target = 9191
# Output: []

# Method1: Using For Loop Based Recursion with backtracking
# N -- no. of elements in the array
# Time Complexity : O(4 ^ N) -- at each node we have 4 cases. 0-case when we create number without operators and 1-case when we 
# use operators in between. As there are 3 operators that can be used, so 1-case has 3 possibilities. So total 4 cases at each node.
# Also we are creating a substring at each node, so complexity = O((4 ^ N) * h) -- h = n in worst case. But exponential is a dominant
# factor. So O(4 ^ N)
# Space Complexity : O(h1 * h2) + O(h) -- h1 --- max recursion depth that is height of the tree, h2 -- average length of the string
# h -- space occupied by path -- in worst case would be length of num
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we have a 2-level recursion. The first level recursion is to create the possible numbers. Then with each possible number, we can have
# all possible operators before creating numbers at the next level. Here we also evaluate the expression as we go along rather than 
# reaching the leaf and then evaluating. For expression evaluation the addition and subtraction cases are simple. But the multiplication or
# division are cases that are to be handled as Multiplication and Division have higher precedence than addition and subtraction.
# We keep a tail variable to keep track of the change that happened from previous level. We initialize the calc and tail variables at the 
# first level when pivot = 0. For addition tail = + curr, for subtraction tail = - curr and for multiply tail = tail * curr
# So calc for addition = calc + curr, for subtraction calc = calc - curr and for mutiply calc = (calc - tail) + (calc * tail). For multiply
# we nullify the previous effect by removing tail and giving precedence to multiply by (calc * tail).
# We have to take care of preceeding 0 case in such number problems. When pivot is at digit 0 and i > pivot, we would get all invalid numbers.
# So we should skip those cases and allow pivot = digit 0 and i = pivot case
# This is a backtracking solution as we are maintaining a single path variable


import copy
class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        def helper(num, target, pivot, path, tail, operators, calc):
            # base
            if(pivot == len(num)):
                if(calc == target):
                    newPath = copy.deepcopy(path)
                    result.append("".join(newPath))
                return

            # logic
            # main recursion for the numbers
            for i in range(pivot, len(num)):
                # preceding 0 case
                # when pivot is at 0, only valid case if when i == pivot
                # rest cases when i > pivot are all invalid as it would give numbers as "05", "056" ...
                if(num[pivot] == "0" and (i > pivot)):
                    return
                # get the number between i and pivot
                currStr = (num[pivot:i+1]) # O(h) time and space
                currNum = int(currStr) # O(h) time and space
                if(pivot == 0):
                    # we are at first level
                    # tail = currNum
                    # calc = currNum
                    path.append(currStr)
                    helper(num, target, i + 1, path, currNum, operators, currNum)
                    path.pop()
                else:
                    # we are at further levels
                    # calculate the expression as per operators

                    for j in range(len(operators)):
                        path.append(operators[j])
                        path.append(currStr)
                        if(operators[j] == '+'):
                            # calc += currNum
                            # tail = currNum
                            helper(num, target, i + 1, path, currNum, operators, calc + currNum)

                        elif(operators[j] == '-'):
                            # calc -= currNum
                            # tail = -currNum
                            helper(num, target, i + 1, path, -currNum, operators, calc - currNum)

                        elif(operators[j] == '*'):
                            # calc = (calc - tail) + (tail * currNum)
                            # tail = tail * currNum
                            helper(num, target, i + 1, path, tail * currNum, operators, (calc - tail) + (tail * currNum))

                        path.pop() # to pop the curr number string
                        path.pop() # to pop the operator


        result = []
        operators = ['+', '-', '*']
        helper(num, target, 0, [], 0, operators, 0)
        return result
    
sol = Solution()
print(sol.addOperators("123", 6))
print(sol.addOperators("232", 8))
print(sol.addOperators("3456237490", 9191))
print(sol.addOperators("105", 5))
print(sol.addOperators("050", 5))
print(sol.addOperators("123", 123))

