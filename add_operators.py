# This solution uses DFS with backtracking to explore all possible ways of inserting +, -, * between digits to evaluate to the target.
# It keeps track of the current index, cumulative sum, expression so far, and the last evaluated operand to correctly handle multiplication.
# Time Complexity: O(4^n), Space Complexity: O(n) for recursion stack and expression storage (where n is the length of num).

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []

        def dfs(cur_idx, cur_res, cur_sum, prev):
            if cur_idx >= len(num):
                if cur_sum == target:
                    res.append("".join(cur_res))
                return
            else:
                for i in range(cur_idx, len(num)):
                    cur_str = num[cur_idx: i+1]
                    cur_num = int(cur_str)

                    if not cur_res:
                        dfs(i+1, [cur_str], cur_num, cur_num)
                    else:
                        dfs(i+1, cur_res + ["+"] + [cur_str], cur_sum+cur_num, cur_num)
                        dfs(i+1, cur_res + ["-"] + [cur_str], cur_sum-cur_num, -cur_num)
                        dfs(i+1, cur_res + ["*"] + [cur_str], cur_sum-prev+cur_num*prev, cur_num*prev)

                    if num[cur_idx] == '0':
                        break

        dfs(0, [], 0, 0)
        return res
