#for loop based backtracking
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        self.recursion(candidates,0,[],target)
        return self.result

    def recursion(self,candidates,index,path,target):
        #base
        if index==len(candidates) or target < 0:
            return

        if target==0:
            self.result.append(path.copy())
            return
#          #logic
        for i in range(index,len(candidates)):
#           #append
            
            path.append(candidates[i])
#           #recursion
            self.recursion(candidates,i,path,target-candidates[i])
            path.pop()

#for loop recursion
# class Solution:
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         self.result=[]
#         self.recursion(candidates,0,[],target)
#         return self.result

#     def recursion(self,candidates,index,path,target):
#         #base
#         if index==len(candidates) or target < 0:
#             return

#         if target==0:
#             self.result.append(path)
#             return
# #          #logic
#         for i in range(index,len(candidates)):
# #           #append
#             newList=path.copy()
#             newList.append(candidates[i])
# #           #recursion
#             self.recursion(candidates,i,newList,target-candidates[i])
            

# #0/1 recursion
# class Solution:
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         self.result=[]
#         self.recursion(candidates,0,[],target)
#         return self.result

#     def recursion(self,candidates,index,path,target):
#         #base
#         if index==len(candidates) or target < 0:
#             return

#         if target==0:
#             self.result.append(path)
#             return
#         #logic
#         #0 or non picked values
#         self.recursion(candidates,index+1,path,target)
#         #append
#         newList=path.copy()
#         newList.append(candidates[index])
#         #1 or picked values
#         #recursion
#         self.recursion(candidates,index,newList,target-candidates[index])

#0/1 backtracking
# class Solution:
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         self.result=[]
#         self.recursion(candidates,0,[],target)
#         return self.result

#     def recursion(self,candidates,index,path,target):
#         #base
#         if index==len(candidates) or target < 0:
#             return

#         if target==0:
#             self.result.append(path.copy())
#             return
#         #logic
#         #0 or non picked values
#         self.recursion(candidates,index+1,path,target)
#         #append
#         path.append(candidates[index])
#         #1 or picked values
#         #recursion
#         self.recursion(candidates,index,path,target-candidates[index])
#         #remove
#         path.pop()
