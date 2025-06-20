class Solution:
    def addOperators(self,num,target):
        result=[]

        def backtrack(index,expression,total,last):
            if index ==len(num):
                if total==target:
                    result.append(expression)
                return
            
            for i in range(index,len(num)):
                currStr=num[index:i+1]

                if len(currStr)>1 and currStr[0]=='0':
                    break

                currNum=int(currStr)

                if index==0:
                    backtrack(i+1,currStr,currNum,currNum)
                else:
                    backtrack(i+1,expression+"+"+currStr,total + currNum,currNum)
                    backtrack(i+1,expression+"-"+currStr,total - currNum,-currNum)
                    backtrack(i+1,expression+"*"+currStr,total-last+(last*currNum),last* currNum)

        backtrack(0,"",0,0)
        return result
    
sol=Solution()
print(sol.addOperators("123",6))
print(sol.addOperators("232",8))
print(sol.addOperators("3456237490",9191))