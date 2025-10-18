"""
TC: O(3^N) {where N is the length of `num`. The branching factor is at most 3 at each position (+, -, *), leading to an exponential search space.}
SC: O(N) {The space required is dominated by the recursion stack depth and the `path` list, which are both proportional to the length of the input string.}

Approach:

This problem is solved using a **backtracking** algorithm to explore all possible valid expressions. The recursive function builds an expression by iterating through the input string `num` and trying to place an operator (`+`, `-`, `*`) or no operator between numbers. A crucial aspect of this approach is handling the order of operations for multiplication. To do this, we maintain the `curr_sum` and the `prev_num` (the last number added or subtracted) in our recursive state. When we encounter a multiplication, we must subtract the `prev_num` from the `curr_sum` and add `prev_num * curr_num` to correctly evaluate the expression. The recursion continues until all characters of the input string have been used. At the base case, if the final `curr_sum` equals the `target`, we add the constructed expression to our results. We also include a check to avoid invalid numbers with leading zeros (e.g., "05").

The problem ran successfully on LeetCode.
"""
from typing import List
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:

        def backtrack(idx, path, curr_sum, prev_num):
            nonlocal res
            #base case
            if idx >= len(num):
                if curr_sum == target:
                    res.append("".join(path))
                return

            #logic
            for i in range(idx, len(num)):
                curr_str = num[idx:i+1]
                curr_num = int(curr_str)

                if not path:
                    #skip operation/add curr_num to path
                    backtrack(i+1, [curr_str], curr_num, curr_num)
                
                else:
                    # + 
                    backtrack(i+1, path+["+"]+[curr_str], curr_sum + curr_num, curr_num)

                    # - 
                    backtrack(i+1, path+["-"]+[curr_str], curr_sum - curr_num, -curr_num)

                    # *
                    backtrack(i+1, path+["*"]+[curr_str], curr_sum - prev_num + prev_num*curr_num, curr_num*prev_num)
                
                if num[idx] == "0":
                    break
                

        

        res = []
        backtrack(idx = 0, path = [], curr_sum = 0, prev_num=0)
        return res