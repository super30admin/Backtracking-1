# Time Complexity : O(4^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
For loop based recursion

"""

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """

        self.result = []
        self.helper(num, target, [], 0, 0, 0)
        return self.result

    def helper(self,num, target, expr_path, current_calculated_value, tail, index):

        if index == len(num):
            if current_calculated_value == target:
                self.result.append("".join(str(x) for x in expr_path))

        for i in range(index,len(num)):
            if index != i and num[index] == '0': break
            current_number = int(num[index:i+1])
            length = len(expr_path)
            if index == 0:
                expr_path.append(current_number)
                self.helper(num, target, expr_path, current_number, current_number, i+1)
                expr_path = expr_path[0:length]
            else:
                expr_path.append("+")
                expr_path.append(current_number)
                self.helper(num, target, expr_path, current_calculated_value + current_number, current_number, i+1)
                expr_path = expr_path[0:length]

                expr_path.append("-")
                expr_path.append(current_number)
                self.helper(num, target, expr_path, current_calculated_value - current_number, -current_number, i+1)
                expr_path = expr_path[0:length]

                expr_path.append("*")
                expr_path.append(current_number)
                self.helper(num, target, expr_path, current_calculated_value - tail + tail*current_number, tail*current_number, i+1)
                expr_path = expr_path[0:length]
