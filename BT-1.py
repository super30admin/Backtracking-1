# Bactracking-1

## Problem 1 Combination Sum (https://leetcode.com/problems/combination-sum/)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates == None or len(candidates) == 0:
            return []
        self.result = []
        self.backtrack(candidates,target, 0, [])
        return self.result
    def backtrack(self, candidates: List[int], target: int, index : int, path: List[int]) -> None:
        #base
        if target < 0:
            return
        if target == 0:
            self.result.append([num for num in path])
            return
        for i in range(index, len(candidates)):
            #action
            path.append(candidates[i])
            #recurse
            self.backtrack(candidates, target - candidates[i], i, path)
            #backtrack
            path.pop()

## Problem 2 Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if num == None or len(num) == 0:
            return []
        self.result = []
        self.recurse(num, target, 0, 0, 0, "")
        return self.result
    def recurse(self, num: str, target: int, index: int, calc: int, tail: int, path: str) -> None:
        #base
        if index == len(num):
            if calc == target:
                self.result.append(path)
            return
        #logic
        for i in range(index, len(num)):
            if num[index] == '0' and i != index:
                continue
            curr = int(num[index: i+1])
            if index == 0:
                self.recurse(num, target, i+1, curr, curr, path + str(curr))
            else:
                #recursive call for + opertor
                self.recurse(num, target, i+1, calc + curr, +curr, str(path + '+' + str(curr)))
                #recursive call for - opertor
                self.recurse(num, target, i+1, calc - curr, -curr, str(path + '-' + str(curr)))
                #recursive call for * opertor
                self.recurse(num, target, i+1, calc - tail + tail * curr, tail * curr, str(path + '*' + str(curr)))
        
