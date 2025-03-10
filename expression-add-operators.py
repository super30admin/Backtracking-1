#expressions | function | tail
# +     | curr + x  | + x
# -     | curr - x   | - x
# *     | curr - tail + tail * x | tail * x
# /     | curr - tail + tail / x | tail / x

# Time O(n * 4^n) n: because we are creating string 4^n: because we have 4 options of operators
# Space O(4*n) path strings creation
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        self.evaluate(num, 0, 0, target, "", 0, result)
        return result


    def evaluate(self, num: str, pivot: int, curr: int, target: int, path: str, tail: int, result: List[str]) -> None:
        # base
        if pivot == len(num):
            if curr == target: 
                result.append(path)
                return
        # for loop recursion
        for i in range(pivot, len(num)):
            # o case
            if i != pivot and num[pivot] == '0': break
            curr_num = int(num[pivot: i+1])
            if pivot == 0: self.evaluate(num, i+1, curr_num, target, path + str(curr_num), curr_num, result)
            else:
                # + case
                self.evaluate(num, i+1, curr + curr_num, target, path + "+" + str(curr_num), curr_num, result)
                # - case
                self.evaluate(num, i+1, curr - curr_num, target, path + "-" + str(curr_num), -curr_num, result)
                # * case
                total = curr - tail + tail * curr_num
                self.evaluate(num, i+1, total, target, path + "*" + str(curr_num), tail*curr_num, result)
            

# Time O(4^n)
# Space O(n+n-1) for path arr-> n: length of num, n-1: operators in between
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        self.evaluate(num, 0, 0, target, [], 0, result)
        return result


    def evaluate(self, num: str, pivot: int, curr: int, target: int, path: List[str], tail: int, result: List[str]) -> None:
        # base
        if pivot == len(num):
            if curr == target: 
                result.append("".join(path))
                return
        # for loop recursion
        for i in range(pivot, len(num)):
            # o case
            if i != pivot and num[pivot] == '0': break
            curr_num = int(num[pivot: i+1])
            if pivot == 0: 
                path.append(str(curr_num))
                self.evaluate(num, i+1, curr_num, target, path, curr_num, result)
                path.pop()
            else:
                # + case
                path.append('+')
                path.append(str(curr_num))
                self.evaluate(num, i+1, curr + curr_num, target, path, curr_num, result)
                path.pop()
                path.pop()
                # - case
                path.append('-')
                path.append(str(curr_num))
                self.evaluate(num, i+1, curr - curr_num, target, path, -curr_num, result)
                path.pop()
                path.pop()
                # * case
                path.append('*')
                path.append(str(curr_num))
                total = curr - tail + tail * curr_num
                self.evaluate(num, i+1, total, target, path, tail*curr_num, result)
                path.pop()
                path.pop()
        

               

        