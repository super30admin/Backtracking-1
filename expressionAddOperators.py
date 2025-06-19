"""
Problem: Expression Add Operators
Approach: 2 decisions to make where to break the num or current num  and also determ,in whether to use +, - or *.
t.c. => O(3^n * n) where n = len(num). as in the worst case we make 3 calls (+, -, * ) for each number in num and n ops for string manipulation
s.c. => O(n) for recursion stack space
"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []
        n = len(num)
        def helper(start, path, val, prevVal):
            if start >= n:
                if val == target:
                    res.append("".join(path))
                return 


            if start == 0:
                if num[start] == '0':
                    helper(start + 1, path + ['0'], 0, 0)
                else:
                    for i in range(start, n):
                        helper(i + 1, [num[start : i + 1]], int(num[start : i + 1]), int(num[start : i + 1]))
                        

            else:
                if num[start] == '0':

                    helper(start + 1, path + ['+'] + ['0'], val, 0)
                    helper(start + 1, path + ['-'] + ['0'], val, 0)

                    #multiplication
                    curr = 0
                    newVal = -prevVal + val
                    helper(start + 1, path + ['*'] + ['0'], newVal, 0)
                else:
                    for i in range(start, n):
                        helper(i + 1, path + ['+'] + [num[start : i + 1]], val + int(num[start : i + 1]), int(num[start : i + 1]))
                        helper(i + 1, path + ['-'] + [num[start : i + 1]], val - int(num[start : i + 1]), -int(num[start : i + 1]))
                        
                        #multiplication
                        curr = int(num[start : i + 1])
                        newVal = -prevVal + val
                        product = (prevVal * curr)

                        helper(i + 1, path + ['*'] + [num[start : i + 1]], newVal + product, product)
        
        helper(0, [], 0, 0)
        return res
