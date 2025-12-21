# Time Complexity : O(4^n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# 1. Use DFS/backtracking to try all ways of inserting '+', '-', and '*' between digits.
# 2. Track the current calculation (cal) and last operand (tail) to correctly handle multiplication precedence.
# 3. Skip numbers with leading zeros and add the expression to the result when the end is reached and cal == target.

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num,target, 0, 0,"",0)
        return self.result
    def helper(self, num, target, cal, tail, path,pivot):
        if pivot == len(num):
            if cal == target:
                self.result.append(path)
                return

        for i in range(pivot,len(num)):

            if num[pivot] == '0' and pivot != i:
                break

            curr = int(num[pivot:i+1])
            if pivot == 0:
                self.helper(num,target,curr,curr,path + str(curr),i+1)
            else:
                self.helper(num, target,cal+curr, curr, path + "+" + str(curr), i+1)
                self.helper(num, target, cal-curr, -curr, path + "-" + str(curr), i+1)
                self.helper(num, target, cal-tail + tail*curr,tail*curr , path + "*" + str(curr), i+1)
            

