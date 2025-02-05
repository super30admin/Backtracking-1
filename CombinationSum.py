#For loop Recursion Approach
# TC = O(2^n+m//2)
#SC = O(n+m)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates == None and len(candidates) == 0:
            return []
        self.result = []
        self.recursion(candidates, target, 0, [])
        return self.result
    
    def recursion(self, canidates : List[int], target : int, piviot : int, path : List[int]) -> None:
        if target == 0:
            self.result.append([num for num in path])
            return   
        if target < 0 or piviot == len(target):
            return
        
        #0 case
        self.recursion(canidates, target , piviot + 1, path)
        
        # 1 case
        for i in range(len(canidates)):
            path.append(canidates[i])
            self.recursion(canidates, target - canidates[i], i , path)
            path.pop()
        
            










# Time Complexity : O(2^(n+m) * N)
# Space Complexity : O((n+m) * 2^(n+m))

# class Solution:
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         if candidates == None and len(candidates) == 0:
#             return []
#         self.result = []
#         self.recurcive(candidates, target, 0, [] )
#         return self.result
    
#     def recurcive(self, candidates: List[int], target: int, index: int, path : List[int] ) -> None:
#         if(target == 0):
#             self.result.append([num for num in path])
#             return 
#         if index == len(candidates) or target < 0:
#             return 
        
#         #0 Case

#         self.recurcive(candidates, target, index+1, [num for num in path])

#         #1 Case
#         path.append(candidates[index])
#         self.recurcive(candidates, target - candidates[index], index , [num for num in path])
#         path.pop()

        