# time: O(4^n)
# Have 4 options at each recursive step:
# 1) extend current number
# 2) add +
# 3) add -
# 4) add *
# space: O(n)

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []

        def helper(num,target,pivot,calc,tail,path):
            if pivot == len(num)
                if calc == target:
                    self.result.append(path)

            for i in range(pivot,len(num)):
                # ignore leading 0's - 05 does not become 5
                if num[pivot]=='0' and i != pivot:
                    break
                curr = int(num[pivot:i+1])

                if pivot == 0:
                    helper(num, target, i+1, curr, curr, path + str(curr))
                else:
                    # +
                    helper(num, target, i+1, calc + curr, curr, path + "+" + str(curr))
                    # -
                    helper(num, target, i+1, calc - curr, -curr, path + "-" + str(curr))
                    # *
                    helper(num, target, i+1, calc - tail + (tail * curr), tail * curr, path + "*" + str(curr))

        helper(num, target, 0, 0, 0, "")
        return self.result