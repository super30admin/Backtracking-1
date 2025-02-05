class Solution:
    def recurse(self,num:str,target:int,idx:int,calcval,tail,path:str):
        # base
        if idx == len(num):
            if calcval == target:
                self.res.append(path[:])
            return
        # logic
        for i in range(idx,len(num)):
            if num[idx] == "0" and idx != i:
                continue                                 
            cur = int(num[idx:i+1])
            if idx == 0:
                self.recurse(num,target,i+1,cur,cur,path+str(cur))
            else:
                # + operator
                self.recurse(num,target,i+1,calcval+cur,+cur,path+"+"+str(cur))
                # - operator
                self.recurse(num,target,i+1,calcval-cur,-cur,path+"-"+str(cur))
                # * operator
                self.recurse(num,target,i+1,(calcval-tail + tail * cur),tail*cur,path + "*" +str(cur))

    def addOperators(self, num: str, target: int) -> List[str]:
        if num is None or len(num)==0:
            return []
        self.res = []
        self.recurse(num,target,0,0,0,"")
        return self.res