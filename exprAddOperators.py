# // Time Complexity :O(4^n) 4 choice
# // Space Complexity :O(n) for recursion stack and pathsize
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Zero condition

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        # create all permutations using pivot recursion
        # we need path, expr, calc, tail, target
        n = len(num)
        res = []
        
        def helper(num: str, pivot:int, calc:int, tail:int, path:str):
            nonlocal target, res
            # base                                      
            if pivot == n:                                                           # output found
                if calc == target:
                    res.append(path)
                    return
            
            # logic
            for i in range(pivot, n):                                               # forloop recursion logic for permutations

                if  i != pivot and num[pivot]=='0': break                           #*** 0 found on pivot ***

                currNum = int(num[pivot:i+1])                                       # substring '12' or '1234'
                
                if pivot == 0:                                                      # pivot at element 1
                    helper(num, i+1, currNum, currNum, path+ str(currNum))
                else:                    
                    helper(num, i+1, calc+ currNum, currNum, path +"+"+ str(currNum))                       # for +
                    helper(num, i+1, calc - currNum, -currNum, path +"-"+ str(currNum))                     # for -
                    helper(num, i+1, (calc-tail)+(tail*currNum), tail*currNum, path +"*"+ str(currNum))     # for *
        helper(num,0,0,0,"")
        return res