'''
Time Complexity - O(4^n)
Space Complexity - O(Input)

Works on Leetcode
'''

class Solution:
    def __init__(self):
        self.result = []

    def addOperators(self, num: str, target: int) -> List[str]:
        self.helper(num, 0, 0, "", 0,target)
        return self.result

    def helper(self, num, pivot, calc, path, tail, target):
        #base
        if pivot == len(num):
            if calc == target:
                self.result.append(path)
        #logic
        for i in range(pivot, len(num)):
            if num[pivot] == '0' and i != pivot:
                continue
            curr = int(num[pivot:i+1])
            if pivot == 0:
                self.helper(num, i+1, curr, path+str(curr),  curr, target)
            else:
                #+
                self.helper(num, i+1, calc+curr, path + "+" + str(curr), curr, target)
                #-
                self.helper(num, i+1, calc-curr, path+"-"+str(curr), -curr, target)
                #*
                self.helper(num, i+1, calc-tail + tail*curr, path+"*"+str(curr), tail*curr, target )

        