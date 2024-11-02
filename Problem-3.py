#Approach
# explore all the nums in the array for every number need to explore three ways "+,-,*'
# For '+,-' The path is straight forward but the the multiplication has some precedence so needed the previous variable  so. proceed with that

#Complexities
#Time: O(3^n)
#space :O(n)


from typing import List


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num, target, 0, 0, 0, "")
        return self.result

    def helper(self, num: str, target: int, pivot: int, current_sum: int, prev_num: int, expression: str):
        if pivot == len(num):
            if current_sum == target:
                self.result.append(expression)
            return

        for i in range(pivot, len(num)):
            if i != pivot and num[pivot] == '0':
                break

            current_str = num[pivot:i + 1]
            current_num = int(current_str)

            if pivot == 0:
                self.helper(num, target, i + 1, current_num, current_num, current_str)
            else:
                self.helper(num, target, i + 1, current_sum + current_num, current_num, expression + "+" + current_str)
                self.helper(num, target, i + 1, current_sum - current_num, -current_num, expression + "-" + current_str)
                self.helper(num, target, i + 1, current_sum - prev_num + prev_num * current_num, prev_num * current_num,expression + "*" + current_str)


s = Solution()
print(s.addOperators("232", 8))

