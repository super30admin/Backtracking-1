def addOperators(self, num: str, target: int) -> List[str]:
    self.result=[]

    def helper(num,target,pivot,calc,tail,path):
        if pivot==len(num):
            if calc==target:
                self.result.append(path)
        for i in range(pivot, len(num)):
            le=len(path)
            curr=int(num[pivot:i+1])
            if num[pivot]=="0" and i!=pivot:
                break
            if pivot==0:
                helper(num,target,i+1,curr,curr,path+str(curr))
            else:
                helper(num,target,i+1,calc+curr,curr,path+ "+" +str(curr))
                helper(num,target,i+1,calc-curr,-curr,path+ "-" +str(curr))
                helper(num,target,i+1,calc-tail+(curr*tail),curr*tail,path+ "*" +str(curr))
    helper(num,target,0,0,0,"")
    return self.result

        