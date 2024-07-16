# Time Complexity : O(3^n)
# space complexity : O(n)

# Approach :

#  keep iterating over the string with different operators
#  in case index is not equal to i and the character is 0, skip that iteration as we dont look for trailing zeros
#  for multiplication, calc = prev calc -  prev tail + current number * tail, and store tail as number * tail


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:

        self.path = []
        self.recurse(num, target, 0, 0, 0, "")
        return self.path

    def recurse(self, num, target, index, calc, tail, path):

        if index == len(num):
            if target == calc:
                self.path.append(path)
            return

        for i in range(index, len(num)):

            if index != i and num[index] == '0':
                continue

            curr = num[index:i+1]
            numCurr = int(curr)

            if index == 0:
                self.recurse(num, target, i+1, numCurr, numCurr, path+curr)
            else:
                self.recurse(num, target, i+1, numCurr+calc,
                             numCurr, path + "+" + curr)
                self.recurse(num, target, i+1, calc - numCurr,
                             (-1)*numCurr, path + "-" + curr)
                self.recurse(num, target, i+1, calc - tail +
                             numCurr * tail, tail * numCurr, path + "*" + curr)
