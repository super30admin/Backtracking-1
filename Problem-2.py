'''
    Time Complexity: O(n*4^n)
    Space Complexity: O(n)
'''
class Solution:
    def __init__(self):
        self.result = []

    def addOperators(self, num: str, target: int) -> List[str]:
        self.helper(0, "", num, target)
        return self.result
        
    def helper(self, i, curExp, num, target):
        # base case
        if i == 0:
            curExp = num[0]
            self.helper(i+1, curExp, num, target)
            return

        if i == len(num):
            if self.checkExp(curExp, target):
                self.result.append(curExp[:])
      
            return

        # logic
        # no operation 
        if not (curExp[-1] == '0' and (len(curExp) == 1 or curExp[-2] in '+-*')):
            curExp = curExp + num[i]
            self.helper(i+1, curExp, num, target)
            curExp = curExp[:-1]

        # addition
        curExp = curExp + '+' + num[i]
        self.helper(i+1, curExp, num, target)
        curExp = curExp[:-2]

        # subtraction
        curExp = curExp + '-' + num[i]
        self.helper(i+1, curExp, num, target)
        curExp = curExp[:-2]

        # multiplication
        curExp = curExp + '*' + num[i]
        self.helper(i+1, curExp, num, target)
        curExp = curExp[:-2]

    def checkExp(self, expression, target):
        digits = []
        lastSign = '+'

        curNum = 0
        for i in range(len(expression)):
            exp = expression[i]

            if exp.isdigit():
                curNum = curNum * 10 + int(exp)
            
            elif exp in ('+', '-', '*'):
                if lastSign == '+':
                    digits.append(curNum)
                elif lastSign == '-':
                    digits.append(-curNum)
                elif lastSign == '*':
                    num = digits.pop()
                    digits.append(num * curNum)

                lastSign = exp
                curNum = 0

        if lastSign == '+':
            digits.append(curNum)
        elif lastSign == '-':
            digits.append(-curNum)
        elif lastSign == '*':
            num = digits.pop()
            digits.append(num * curNum)

        while len(digits) > 1:
            num1 = digits.pop()
            num2 = digits.pop()
            digits.append(num1+num2)

        if digits[0] == target:
            return True
        else: 
            return False