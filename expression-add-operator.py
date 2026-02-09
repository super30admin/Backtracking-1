#--------Solution 1 : FOr loop recursion - creating new path for each calll------------
''' Time Complexity : O(4^n * n) : n for string concatenation at each call
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.target = target

        def helper(num, pivot, calc, tail, path):
            #base
            if pivot == len(num):
                if calc == self.target:
                    self.result.append(path)
            #logic
            for i in range(pivot, len(num)):
                if num[pivot] == '0' and pivot!=i:
                    break

                curr = int(num[pivot:i+1])
                if pivot == 0:
                    helper(num, i+1, curr, curr, path + str(curr))
                else:
                    # for +
                    helper(num, i+1, calc + curr, curr, path + "+" + str(curr))
                    #for -
                    helper(num, i+1, calc - curr, -curr, path + "-" + str(curr))
                    #for *
                    helper(num, i+1, calc - tail + (tail * curr) , tail * curr, path + "*" + str(curr))
            
        helper(num, 0, 0, 0, "")
        return self.result


#--------Solution 2 : For loop with Backtraking------------
''' Time Complexity : O(4^n)
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.target = target

        def helper(num, pivot, calc, tail, path):
            #base
            if pivot == len(num):
                if calc == self.target:
                    self.result.append("".join(path))
                return
            #logic
            for i in range(pivot, len(num)):
                if num[pivot] == '0' and pivot!=i:
                    break

                curr = int(num[pivot:i+1])
                le = len(path)
                if pivot == 0:
                    path.append(str(curr))
                    helper(num, i+1, curr, curr, path)
                    path.pop()
                else:
                    # for +
                    path.append('+')
                    path.append(str(curr))
                    helper(num, i+1, calc + curr, curr, path)
                    path.pop()
                    path.pop()
                    #for -
                    path.append('-')
                    path.append(str(curr))
                    helper(num, i+1, calc - curr, -curr, path)
                    path.pop()
                    path.pop()
                    #for *
                    path.append('*')
                    path.append(str(curr))
                    helper(num, i+1, calc - tail + (tail * curr) , tail * curr, path)
                    path.pop()
                    path.pop()
            
        helper(num, 0, 0, 0, [])
        return self.result