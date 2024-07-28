# time: O(4**n)
# space: O(n)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []

        def helper(pos, cursum,last, path):
            if cursum==target and pos==len(num):
                res.append(path)
                return
            
            for i in range(pos, len(num)):
                if i!=pos  and num[pos]=='0':
                    break
                n = int(num[pos:i+1])
                if pos==0:
                    helper(i+1, n,n, path+num[pos:i+1])
                else:
                    # +
                    helper(i+1, cursum+n,n, path+'+'+num[pos:i+1])

                    # -
                    helper(i+1, cursum-n,-n, path+'-'+num[pos:i+1])
                    
                    # *
                    helper(i+1, cursum-last+last*n,last*n, path+'*'+num[pos:i+1])
            
        helper(0, 0,0, "")
        return res
