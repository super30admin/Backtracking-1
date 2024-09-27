class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #Choose and don't choose method
        def combo(index,cur,curList):
            
            if cur==0:
                self.final.append([v for v in curList])
                return
            if cur<0 or index>=len(candidates):
                return
            #don't choose
            combo(index+1,cur,curList)
            #choose
            curList.append(candidates[index])
            combo(index,cur-candidates[index],curList)
            curList.pop()
        self.final=[]
        combo(0,target,[])
        return self.final
        #Time O(2^n)
        #Space O(n)
    
    
    
        #With for loop and recursion
        # candidates.sort()
        # def combo(index,cur,curList):
        #     if cur==target:
        #         self.final.append([v for v in curList])
        #         return
        #     if cur<target:
        #         for i in range(index,len(candidates)):
        #             if cur+candidates[i]>target:
        #                 break
        #             curList.append(candidates[i])
        #             combo(i,cur+candidates[i],curList)
        #             curList.pop()
        # self.final=[]
        # combo(0,0,[])
        # return self.final
        # #Time O(n^Target/min)-exponential-n -number of candidates
        # #Space O(Target/minimum value)
                
            
        
