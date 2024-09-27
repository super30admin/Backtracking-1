class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.final=[]
        def helper(index,num,target,calc,tail,path):
            if target==calc and index==len(num):
                self.final.append(path)
                return
            for i in range(index,len(num)):
                val=num[index:i+1]
                #if we have string like "05", we ignore
                if num[index]=="0" and i!=index:
                    break
                #First of string
                if index==0:
                    helper(i+1,num,target,int(val),int(val),path+val)
                else:
                    #+ operation
                    helper(i+1,num,target,calc+int(val),+int(val),path+"+"+val)
                    #- operation
                    helper(i+1,num,target,calc-int(val),-int(val),path+"-"+val)
                    #* operation
                    helper(i+1,num,target,calc-tail+tail*int(val),tail*int(val) ,path+"*"+val)
        helper(0,num,target,0,0,"")
        return self.final
