# time complexisty is o(2^m+n)
from typing import Optional, List
# class Solution:
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         self.res= []
#         def helper(candidates,idx,target,path):
#             # base
#             if target == 0 : 
#                 self.res.append(path)
#                 return
#             if idx == len(candidates) or target < 0 : return 
                
#             # logic 
#             # choose
#             path.append(candidates[idx])
#             helper(candidates, idx, target-candidates[idx], path[:]) 
#             # not choose
#             #need to do deep copy since path is passsed by reference so we need to have deep copy of the path 
#             helper(candidates, idx+1, target, path[:]) 


#         helper(candidates, 0, target, [])
#         return self.res
        
# another solution with just the deep copy if choose is done first
# from typing import Optional, List
# class Solution:
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         self.res= []
#         def helper(candidates,idx,target,path):
#             # base
#             if target == 0 : 
#                 self.res.append(path)
#                 return
#             if idx == len(candidates) or target < 0 : return 
                
#             # logic 
#             # choose
#             # since we are modifyin the path when we choose the candidate we should prepare a new list instead 
#             li = path[:]
#             li.append(candidates[idx])
#             helper(candidates, idx, target-candidates[idx], li) 
#             # not choose
#             helper(candidates, idx+1, target, path[:]) 


#         helper(candidates, 0, target, [])
#         return self.res


from typing import Optional, List
# class Solution:
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         self.res= []
#         def helper(candidates,idx,target,path):
#             # base
#             if target == 0 : 
#                 self.res.append(path[:]) #backtracking or action recurse backtrack can use path.copy() or copy.copy()
#                 return
#             if idx == len(candidates) or target < 0 : return 
                
#             # logic 
        
#             # not choose
#             helper(candidates, idx+1, target, path ) 
#             # choose
#             # action
#             path.append(candidates[idx])
#             # recurse
#             helper(candidates, idx, target-candidates[idx], path)
#             # backtrack
#             path.pop()



#         helper(candidates, 0, target, [])
#         return self.res

# class Solution:
    # def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    #     self.res = []
    #     def helper(candidates, pivot ,target, path):
    #         #base
    #         if target == 0:
    #             self.res.append(path[:])
    #             return
    #         if target < 0 : return
    #         #logic 
    #         for i in range(pivot,len(candidates)):
    #             #action
    #             path.append(candidates[i])
    #             #recurse
    #             helper(candidates, i, target-candidates[i], path)
    #             #backtrack
    #             path.pop()

    #     helper(candidates, 0, target, [])
    #     return self.res

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        def helper(candidates, pivot ,target, path):
            #base
            if target == 0:
                self.res.append(path[:])
                return
            if target < 0 : return
            #logic 
            for i in range(pivot,len(candidates)):
                #create a separate list for each baby
                li = path[:]
                li.append(candidates[i])
                helper(candidates, i, target-candidates[i], li)

        helper(candidates, 0, target, [])
        return self.res
        
        
        
        