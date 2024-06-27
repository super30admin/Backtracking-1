'''
1. We use for loop to iterate over the string. We use a helper function to recurse over the number string.
2. Each number can be a single digit or multiple digits. We use an index to keep track of the number we are currently processing.
3. A calc variable is used to keep track of the current value of the expression. A tail variable is used to keep track of the previous value of the expression for multiplication.
4. If the expression evaluates to the target, we add it to the result.

TC: O(4^N)       N-1 places between N numbers and can be one of 3 operations - 3^(N-1) and another linear operation proportional to string length N to compute the arithmetic expression
SC: O(N)         Space for the case where expression includes all numbers and operations
'''
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num or len(num) == 0:
            return []

        self.result = []

        self.helper(num,target,0,0,0,"")
        

        return self.result

    def helper(self, num, target, index, calc, tail, path):
        #BASE
        if index == len(num):
            if calc == target:
                self.result.append(path)
            return

        # LOGIC
        for i in range(index,len(num)):
            if num[index] == '0' and index!=i: 
                continue

            curr = int(num[index:i+1])
            if index==0:
                self.helper(num, target, i+1, curr, curr, path + str(curr))
            else:
                # + operator
                self.helper(num,target, i+1, calc + curr, +curr, path + '+' + str(curr))
                # - operator
                self.helper(num,target, i+1, calc - curr, -curr, path + '-' + str(curr))
                # * operator
                self.helper(num,target, i+1, calc - tail + tail*curr, tail*curr, path + '*' + str(curr))


        