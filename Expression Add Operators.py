"""
THis could be solved by using for-loop-based recursion. For each baby produced there will be 3 branches for +, * and -.
The first level of babies will not have an operator in front of it.
The expression can be evaluated when the recursive tree reaches the leaf node. OR we can keep track of calculated value
at each level. if the expression is:
                                   1+2 = 3
                                   + /   \ *3
                                 3+3        3*3 is wrong. it should be 1*6 = 7
Thus, we need to know +2 so that we can get  1 as 3-2 and then expression becomes (3-2)+ (2*3). Thus, need to know
the previous value (tail). The tail is the current number for the given level.
expression          calculated value                                tail
+                       curr + calculated value                  + current
-                   calculated value - curr                         - current
*                   (calculated -tail) + (tail*curr)                    tail*current

Edge case: 105. It is evaluated as 1*5, zero is left. THus, all digits should be included.
Todo: use string builder
"""


class Solution:
    def helper(self, num, calculated_val, tail, pivot, path, target):
        # base case
        if pivot >= len(num):
            if calculated_val == target:
                self.ans.append(path)

        # logic
        for idx in range(pivot, len(num)):
            # substring formed is till the idx
            sub_str = num[pivot:idx + 1]
            # this is the check if the substring have leadning zero
            if len(sub_str) > 1 and sub_str[0] == "0":
                continue

            # convert to number
            curr_num = int(sub_str)

            # move to the next level w/o adding any operator if it is first level
            if pivot == 0:  # we are at first level
                # the tail is the curr number
                self.helper(num, curr_num, curr_num, idx + 1, path + sub_str, target)
            else:
                # +
                self.helper(num, calculated_val + curr_num, curr_num, idx + 1, path + "+" + sub_str, target)

                # -
                self.helper(num, calculated_val - curr_num, -curr_num, idx + 1, path + "-" + sub_str, target)

                # *
                self.helper(num, (calculated_val - tail) + (tail * curr_num), tail * curr_num, idx + 1,
                            path + "*" + sub_str, target)

    def addOperators(self, num: str, target: int) -> List[str]:
        self.ans = []
        self.helper(num, 0, 0, 0, "", target)
        return self.ans
