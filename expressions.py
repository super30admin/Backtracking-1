# Time complexity - O(4^l) with backtracking - 4 recursions and l depth => l = len(num)
# Time Complexity - O(4^l)*l with new list creation at each level
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        n = len(num)
        def helper(pivot, path, calc, tail):
            if pivot == n:
                if calc == target:
                    result.append(path)
                return
            # logic
            for i in range(pivot, n):
                curr = int(num[pivot:i+1]) # convert the integer
                if num[pivot] == '0' and i!= pivot: continue # consider case 105 issue happens when pivot = 1 num[pivot] = 5
                len = len(path) 
                if pivot == 0: # top level no expression
                    path.append(str(curr))
                    helper(i+1, path, curr, curr)
                    path = path[:len+1]
                else:
                    # +
                    path.append("+")
                    path.append(str(curr))
                    helper(i+1, path, calc + curr, curr)
                    path = path[:len]
                    # -
                    path.append("-")
                    path.append(str(curr))
                    helper(i+1, path+"-"+str(curr), calc - curr, -curr)
                    path = path[:len]
                    # *
                    path.append("*")
                    path.append(str(curr))
                    helper(i+1, path+"*"+str(curr), calc - tail + tail * curr, tail * curr)         
                    path = path[:len]

        helper(0, "", 0, 0)
        return result


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        n = len(num)
        def helper(pivot, path, calc, tail):
            if pivot == n:
                if calc == target:
                    result.append(path)
                return
            # logic
            for i in range(pivot, n):
                curr = int(num[pivot:i+1]) # convert the integer
                if num[pivot] == '0' and i!= pivot: continue # consider case 105 issue happens when pivot = 1 num[pivot] = 5 
                if pivot == 0: # top level no expression
                    helper(i+1, path+str(curr), curr, curr)
                else:
                    # +
                    helper(i+1, path+"+"+str(curr), calc + curr, curr)
                    # -
                    helper(i+1, path+"-"+str(curr), calc - curr, -curr)
                    # *
                    helper(i+1, path+"*"+str(curr), calc - tail + tail * curr, tail * curr)

        helper(0, "", 0, 0)
        return result
