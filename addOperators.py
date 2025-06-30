#TimeComplexity:    O(4^n) where n is lenght of num .. here we have 4 choices at each idx, +,-,* or just concat with next number 
#SpaceComplexity: O(k * n)  k valid expressions
#approach :Similar to other backtracking fix pivot and then try diffrent combinations..
# also use tail approach to track prev used number to make * easy 

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        


        def helper(num,pivot,path, cal, tail, target,result):  #path at start will [] for backtracking solution
            #base,, at pv== len, and res=target
           
            if pivot==len(num) :
                if cal==target:
                    
                    result.append("".join(path))
                return 


            #logic
            for i in range(pivot,len(num)):
                s=num[pivot:i+1]
                if num[pivot]=="0" and len(s)>1:continue
                curr=int(s)
                
                if pivot==0:
                    #no need add operators
                    path.append(str(curr))
                    helper(num,i+1,path, curr, curr, target,result)
                    path.pop()
                else:
                    #+
                    path.append("+")
                    path.append(str(curr))
                    
                    helper(num,i+1,path, cal+curr, curr, target,result)
                    path.pop()
                    path.pop()
                    #-
                    path.append("-")
                    path.append(str(curr))
                    
                    helper(num,i+1,path, cal-curr, -curr, target,result)
                    path.pop()
                    path.pop()
                    #*
                    path.append("*")
                    path.append(str(curr))
                    
                    helper(num,i+1,path, cal-tail+curr*tail, curr*tail, target,result)
                    path.pop()
                    path.pop()
        
        result=[]
        helper(num,0,[], 0, 0, target,result)
        return result


