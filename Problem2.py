# time complexity 4^n since we have 4 sub recursion paths at every number
# spac complexity -> On as we are saving only the digits in the pathlist array 
# logic -> using pivot and i create the possible combinations of numbers and between every 2 numbers try all 3 operations

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        digits = [int(d) for d in num]
        def helper(pivot, pathList, calc, tail):
            if pivot == len(num):
                if calc == target:
                    result.append("".join(pathList))
            curr = 0
            for i in range(pivot, len(num)):
                if digits[pivot] == 0 and pivot != i:
                    break
                curr = curr*10 + digits[i]
                currStrNum = num[pivot:i+1]
                if pivot == 0:
                    pathList.append(currStrNum)
                    helper(i+1, pathList, curr, curr)
                    pathList.pop()
                else:
                    #addition
                    pathList.append("+")
                    pathList.append(currStrNum)
                    helper(i+1, pathList, calc+curr, curr)
                    pathList.pop()
                    pathList.pop()


                    #subtraction
                    pathList.append("-")
                    pathList.append(currStrNum)
                    helper(i+1, pathList, calc-curr, -curr)
                    pathList.pop()
                    pathList.pop()


                    # multiply
                    pathList.append("*")
                    pathList.append(currStrNum)
                    helper(i+1, pathList, calc-tail+(tail*curr), (tail*curr))
                    pathList.pop()
                    pathList.pop()
        helper(0, [], 0, 0,)
        return result

