# Time Complexity : O(3^n * n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []

        def helper(calc, tail, pivot, path: List[str]):
            #base
            if pivot == len(num):
                if calc == target:
                    result.append(''.join(path))
                return 
            
            for i in range(pivot, len(num)):

                if num[pivot] == '0' and pivot != i:
                    continue
                
                s = num[pivot:i+1]
                curr = int(s)
                if pivot == 0:
                    path.append(s)
                    helper(curr, curr, i+1, path)
                    path.pop()
                else:
                    for op in ['+', '-', '*']:
                        path.append(op + s)
                        #+
                        if op == '+':
                            helper(calc+curr, curr, i+1, path)
                        #-
                        elif op == '-':
                            helper(calc-curr, -curr, i+1, path)
                        #*
                        else:
                            helper(calc-tail + tail*curr, tail * curr, i+1, path)
                        path.pop()
                
        helper(0, 0, 0, [])
        return result