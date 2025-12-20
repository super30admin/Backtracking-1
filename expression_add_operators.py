# https://leetcode.com/problems/expression-add-operators/

class Solution:
    def addOperators(self, num: str, target: int) -> list[str]:
        self.result = []

        # call the helper function
        def helper(num, target, pivot, calc, tail, path):
            # base case
            if pivot == len(num):
                # calc represent the current value of the calculation so far
                # if the target is achieved
                if calc == target:
                    # append that path into the result
                    self.result.append(path)
            # use the for loop to choose the combination 
            for i in range(pivot, len(num)):
                # if the number is starting with zero break the loop
                if num[pivot] == '0' and i != pivot:
                    break
                # find the current number
                curr = int(num[pivot:i+1])

                # if we are at the beginning of the string, we cannot add an operator before it
                if pivot == 0:
                    # start the expression with the current number and continue recursion
                    helper(num, target, i+1, curr, curr, path + str(curr))
                # when the starting point is not 0, then add operators
                else:
                    # for addition- add the current number to the expression
                    helper(num, target, i+1, calc + curr, curr, path + "+" + str(curr))
                    # for substraction- substract the current number from the expression
                    helper(num, target, i+1, calc - curr, -curr, path + "-" + str(curr))
                    # for multiplication- multiply the last number (tail) with the current number
                    helper(num, target, i+1, calc - tail + (tail * curr), tail * curr, path + "*" + str(curr))
                    
        # start the recursion with initial values
        helper(num, target, 0, 0, 0, "")
        return self.result

solution = Solution()
print(solution.addOperators("123",6))