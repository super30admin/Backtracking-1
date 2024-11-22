# Time Complexity : O(4^n * n)
# Space Complexity : O(4^n * n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Expression Add Operators


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        def helper(index: int, path: str, calc: int, tail: int):
            # Base case: if we've reached the end of the string
            if index == len(num):
                if calc == target:
                    self.result.append(path)
                return

            for i in range(index, len(num)):
                # Skip numbers with leading zeros
                if i != index and num[index] == '0':
                    break

                # Current number
                curr = int(num[index:i + 1])

                if index == 0:
                    # First number in the expression (no operator needed)
                    helper(i + 1, path + str(curr), curr, curr)
                else:
                    # Add "+"
                    helper(i + 1, path + "+" + str(curr), calc + curr, curr)
                    # Add "-"
                    helper(i + 1, path + "-" + str(curr), calc - curr, -curr)
                    # Add "*"
                    helper(i + 1, path + "*" + str(curr), calc - tail + tail * curr, tail * curr)

        self.result = []
        helper(0, "", 0, 0)
        return self.result


    #     self.result = []
    #     self.target = target
    #     if num == None or len(num) == "0":
    #         return self.result
    #     self.helper(num, self.target, "", 0, 0, 0)
    #     return self.result
    # def helper(self, num: str, target: int, path: str, calc: int, tail: int, index: int):
    #     # Base case
    #     if index == len(num):
    #         if target == calc:
    #             self.result.append(path)
    #         return

    #     # Logic
    #     for i in range(index, len(num)):
    #         if i != index and num[index] == "0":
    #             break
    #         curr = int(num[index:i + 1])
    #         if index == 0:
    #             self.helper(num, self.target, str(curr), curr, curr, i + 1)
    #         else:
    #             # Add '+'
    #             self.helper(num, self.target, path + "+" + str(curr), calc + curr, curr, i + 1)
    #             # Add '-'
    #             self.helper(num, self.target, path + "-" + str(curr), calc - curr, -curr, i + 1)
    #             # Add '*'
    #             self.helper(num, self.target, path + "*" + str(curr), calc - tail + tail * curr, tail * curr, i + 1)
