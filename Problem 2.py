class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        n = len(num)
        res = []
        def dfs(i,sofar, value, prev): #123
            if i >= n and value == target:
                # print(sofar, value)
                res.append("".join(sofar))
                return
            
            for j in range(i, n):
                if not sofar:
                    dfs(j+1, [num[i:j+1]], int(num[i:j+1]), int(num[i:j+1]))
                else:   
                    dfs(j+1, sofar + ['+'] + [num[i:j+1]], value+int(num[i:j+1]), int(num[i:j+1]) )
                    dfs(j+1, sofar + ['-'] + [num[i:j+1]], value-int(num[i:j+1]), -int(num[i:j+1]) )
                    
                    #for *, bc of bodmas, need to have prev value so that we will add or minus ( opps of last operation), multiply it with current one and then add it back to value(which is prev res or res sofar)
                    dfs(j+1, sofar + ['*'] + [num[i:j+1]], value-prev + prev*int(num[i:j+1]),  prev*int(num[i:j+1]))
                
                if num[i]=='0': #so that it doesn't consider vals like 00, 05, 005 etc. hence after 1 0, don't dfs more
                    break
        dfs(0, [], 0, None)
        return res
