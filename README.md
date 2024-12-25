# Bactracking-1


## Problem1: Combination Sum (https://leetcode.com/problems/combination-sum/)

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(start, target, path):
            if target == 0:
                result.append(path)
                return
            if target < 0:
                return
            for i in range(start, len(candidates)):
                backtrack(i, target - candidates[i], path + [candidates[i]])

        result = []
        candidates.sort()
        backtrack(0, target, [])
        return result

## Problem2: Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
class Solution:
  def addOperators(self, num: str, target: int) -> List[str]:
    ans = [] # list to store all possible expressions that evaluate to the target

    # DFS function to generate all possible expressions
    # start: current index in num
    # prev: previous operand value
    # eval: current evaluated value
    # path: list to store current expression
    def dfs(start: int, prev: int, eval: int, path: List[str]) -> None:
      # base case: reached end of num
      if start == len(num):
        # check if current evaluation equals target
        if eval == target:
          # add current expression to the answer list
          ans.append(''.join(path))
        return

      # iterate over all possible operands from current index
      for i in range(start, len(num)):
        # special case: ignore operands starting with 0, except 0 itself
        if i > start and num[start] == '0':
          return
        s = num[start:i + 1]
        curr = int(s)
        # special case: first operand, simply add it to the path and evaluate
        if start == 0:
          path.append(s)
          dfs(i + 1, curr, curr, path)
          path.pop()
        # general case: iterate over all possible operators and operands
        else:
          for op in ['+', '-', '*']:
            path.append(op + s)
            # addition: add current operand to evaluated value
            if op == '+':
              dfs(i + 1, curr, eval + curr, path)
            # subtraction: subtract current operand from evaluated value
            elif op == '-':
              dfs(i + 1, -curr, eval - curr, path)
            # multiplication: multiply current operand with previous operand and update evaluated value
            else:
              dfs(i + 1, prev * curr, eval - prev + prev * curr, path)
            path.pop()

    # start DFS with initial parameters
    dfs(0, 0, 0, [])
    return ans
