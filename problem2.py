# Space Complexity: O(h) -> height of stack
# Time Complexity:  4 ^ len(num)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        res = []

        def helper(num, pivot, calc, tail, path, target, res):

            if pivot == len(num): 
                if target == calc: 
                    res.append(''.join(map(str, path)))
                return 
            
            for i in range(pivot, len(num)):
                if num[pivot] == '0' and i!=pivot: continue
                curr = int(num[pivot:i+1])
                if pivot == 0:
                    path.append(curr)
                    helper(num, i+1, curr, curr, path, target, res)
                    path.pop()
                else:
                    # +
                    path.append('+')
                    path.append(curr)
                    helper(num, i+1, calc + curr, curr, path, target, res)
                    path.pop()
                    path.pop()
                    # -
                    path.append('-')
                    path.append(curr)
                    helper(num, i+1, calc - curr, -curr, path, target, res)
                    path.pop()
                    path.pop()
                    # *
                    path.append('*')
                    path.append(curr)
                    helper(num, i+1, calc - tail + tail * curr, tail*curr, path, target, res)
                    path.pop()
                    path.pop()

        helper(num, 0, 0, 0, [], target, res)
        return res
