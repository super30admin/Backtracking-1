#--------Solution 1 : Backtraking------------
''' Time Complexity : O(2^(m+n)) 
    Space Complexity : O(m+n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        path = []
        def helper(candidates, i, path, target):
            #base
            if i >= len(candidates) or target < 0:
                return
            if target == 0:
                self.result.append(list(path))
                return
            #logic
            #action
            path.append(candidates[i])
            #choose
            helper(candidates, i, path, target-candidates[i])
            #backtrack
            path.pop()
            #no Choose
            helper(candidates, i+1, path, target)
        
        helper(candidates,0,path,target)
        return self.result


#--------Solution 2 : Creating new path each time------------
''' Time Complexity : O(n*2^(m+n)) 
    Space Complexity : O(n*h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        path = []
        def helper(candidates, i, path, target):
            #base
            if i >= len(candidates) or target < 0:
                return
            if target == 0:
                self.result.append(list(path))
                return
            #logic
            #action
            new_p = deepcopy(path)
            new_p.append(candidates[i])
            #choose
            helper(candidates, i, new_p, target-candidates[i])
            #no Choose
            helper(candidates, i+1, path, target)
        
        helper(candidates,0,path,target)
        return self.result

#--------Solution 3 : For loop based recursion with backtracking------------
''' Time Complexity : O(2^(m+n)) 
    Space Complexity : O(m+n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        path = []
        def helper(candidates, pivot, path, target):
            #base
            if target < 0:
                return
            if target == 0:
                self.result.append(list(path))
                return
            #logic
            #action
            for i in range(pivot,len(candidates)):
                path.append(candidates[i])
                #choose
                helper(candidates, i, path, target-candidates[i])
                #backtrack
                path.pop()

        
        helper(candidates,0,path,target)
        return self.result