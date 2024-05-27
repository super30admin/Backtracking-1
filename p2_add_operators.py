"""

DO AGAIN !!!!

Double recursion
 - Form numbers
 - FOr operators between numbers


 Also check the non forloop based recursion (After 1 hours 20 min)
 https://www.youtube.com/watch?v=YWIKRsyz9zk&list=PLWtKyKogBpBAnsRWmlBs2b1LpC98ikorf&index=42
"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.nums = num
        self.target = target
        self.res = list()
        self.helper(0, 0, 0, "")
        return self.res

    def helper(self, pivot, calc, tail, path):
        # Base 
        if pivot == len(self.nums):
            if calc == self.target:
                self.res.append(path)
            return 

        # Logic 
        init_len = len(path)
        for i in range(pivot, len(self.nums)):
            if self.nums[pivot] == '0' and pivot != i:
                continue
            curr = self.nums[pivot: i+1]
            # print ("pivot=", pivot, "calc=", calc, "curr=", curr)
            if pivot == 0:
                # Action
                path += curr
                # Recurse
                self.helper(i + 1, calc + int(curr), int(curr), path)
                # Backtrack
                path = path[:init_len]
            else:
                # Action
                path += "+"
                path += curr
                # Recurse
                self.helper(i+1, calc + int(curr), int(curr), path)
                # Backtrack
                path = path[:init_len]

                # Action
                path += "-"
                path += curr
                # Recurse
                self.helper(i+1, calc - int(curr), -int(curr), path)
                # Backtrack
                path = path[:init_len]

                # Action
                path += "*"
                path += curr
                # Recurse
                self.helper(i+1, calc - tail + tail * int(curr), tail * int(curr), path)
                # Backtrack
                path = path[:init_len]
                