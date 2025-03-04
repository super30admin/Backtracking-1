#  https://leetcode.com/problems/combination-sum/


############## recursion ####################

# 2 ^ (m+n) no of nodes in this tree
# additional tc will be (m+n) * 2^(m+n) that m+n is for copying the list.
# SC is (m+n) * 2^(m+n)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []    
        self.helper(candidates,0,[],target)
        return self.result
    
    def helper(self, candidates: List[int], idx, path, target: int):
        # base
        if target < 0 or idx == len(candidates):
            return 
        
        if target == 0:
            self.result.append(path)
            return

        #logic
        # 0 case
        self.helper(candidates,idx+1,path,target)

        # 1 case
        li = path.copy()
        li.append(candidates[idx])
        self.helper(candidates,idx,li,target - candidates[idx])


########### backtracking ################

# TC: (m+n) * 2^(m+n)
# SC: 2* m+n ==> one for stack and one for the li path array ==> O(m+n)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []    
        self.helper(candidates,0,[],target)
        return self.result
    
    def helper(self, candidates: List[int], idx, path, target: int):
        # base
        if target < 0 or idx == len(candidates):
            return 
        
        if target == 0:
            self.result.append(path.copy())
            return

        #logic
        # 0 case
        self.helper(candidates,idx+1,path,target)

        # 1 case
        # action
        path.append(candidates[idx])
        # recurse
        self.helper(candidates,idx,path,target - candidates[idx])

        #backtrack
        path.pop()

        
################ for loop recursion with backtracking ###################

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []    
        self.helper(candidates,0,[],target)
        return self.result
    
    def helper(self, candidates: List[int], pivot, path, target: int):
        # base
        if target < 0 or pivot == len(candidates):
            return 
        
        if target == 0:
            self.result.append(path.copy())
            return

        #logic
        for i in range(pivot,len(candidates)):
            path.append(candidates[i])

            self.helper(candidates, i, path, target - candidates[i])

            path.pop()



############3 for loop recursion without backtracking #########################


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []    
        self.helper(candidates,0,[],target)
        return self.result
    
    def helper(self, candidates: List[int], pivot, path, target: int):
        # base
        if target < 0 or pivot == len(candidates):
            return 
        
        if target == 0:
            self.result.append(path)
            return

        #logic
        for i in range(pivot,len(candidates)):
            li = path.copy()
            li.append(candidates[i])

            self.helper(candidates, i, li, target - candidates[i])

            #path.pop()
            