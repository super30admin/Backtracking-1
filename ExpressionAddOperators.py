# Time Complexity :
# O(3^N) , N= length of the string

# Space Complexity :  
# O(N), N= length of the string

# Approach:
# For loop based Recursion approach. 


class Solution(object):
    def __init__(self):
        self.result = []

    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        if not num or len(num)==0:
            return []

        self.recurse(num, target, 0, 0, 0, "")
        return self.result
    
    def recurse(self, num, target, index, calc, tail, path):
        #base
        if index == len(num):
            if calc == target:
                self.result.append(path)

        #logic
        for i in range(index, len(num)):
            #handle leading zeroes
            if num[index]=='0' and index!=i:
                continue

            curr = int(num[index:i+1])
            if index==0:
                self.recurse(num, target, i+1, curr, curr, path+str(curr))
            else:
                # + operation
                self.recurse(num, target, i+1, calc+curr, +curr, path + "+" + str(curr))

                # - operation
                self.recurse(num, target, i+1, calc-curr, -curr, path + "-" + str(curr))

                # * operation
                self.recurse(num, target, i+1, calc-tail + tail*curr, tail*curr, path + "*" + str(curr))