# BT Approach --
# TC - 4 ^ n. Why 4? Since we've to make 4 decision, i.e. 3 operators and 1 substring decision
# SC - O(n x 4^n) for recursion and O(n) for Backtracking

class Solution:
    def __init__(self):
        self.rtnData = []

    def addOperators(self, num: str, target: int) -> List[str]:
        if num is None or len(num) == 0: return self.rtnData

        # helper method
        self.helper(num, target, 0, [], 0, 0)

        return self.rtnData

    def helper(self, num, target, index, path, calc, tail):
        # base
        # if index has reached len(num)
        if index == len(num):
            if calc == target:
                self.rtnData.append(''.join(path))
            return

        # logic
        for i in range(index, len(num)):
            #   preceding 0 case check
            if (index != i and num[index] == '0'):
                break

            # get curr
            curr = int(num[index:i + 1])
            # print("curr",curr)

            if index == 0:
                self.helper(num, target, i + 1, [str(curr)], curr, curr)
            else:
                # + operator case
                path.append('+');
                path.append(str(curr))
                self.helper(num, target, i + 1, path, calc + curr, curr)
                path.pop();
                path.pop()

                # - operator case
                path.append('-');
                path.append(str(curr))
                self.helper(num, target, i + 1, path, calc - curr, -curr)
                path.pop();
                path.pop()

                # * operator case
                path.append('*');
                path.append(str(curr))
                self.helper(num, target, i + 1, path, (calc - tail) + (tail * curr), (tail * curr))
                path.pop();
                path.pop()
        return