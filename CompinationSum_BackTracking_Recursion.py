# Time Complexity : exponential
# Space Complexity : O(n), because we are creating a new list and copying elements only when target == 0, else using 1 list only at every recursive call
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# using backtracking approach because in this solution we will not have to use a new list at every recursive call
# 0 - 1 based recusion, along with backtracking technique
# when we dont pick an element, the index increase by 1 and target remains same and nothing gets added to the path list
# when we pick at element, we decrease the target by picked element, and index remains same because we can access an element any no of times
# when target becomes negative or when index reaches the end of the candidates list, we will stop recursing



class Solution(object):
    def __init__(self):
        self.result = [] # result list to store all possible combinations
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        # using backtracking approach (recursion) - using single list
        if len(candidates) == 0:
            return [-1,-1]
        
        # emptty list - to store elements in recusion
        path = []
        self.backtrack(candidates, target, 0, path)
        return self.result
    
    def backtrack(self, candidates, target, index, path):
        # base case
        if target < 0 or index == len(candidates):
            return

        # when traget becomes 0
        if target == 0:
            # create new list, copy path, add the list to result and return
            newlist = path[:]
            self.result.append(newlist)
            return

        # logic
        # 0 case - not picking the element, index + 1, target remains same
        self.backtrack(candidates, target, index + 1, path)
        
        # 1 case - picking the element, and decreasing the target, index remains same

        # action - add to path
        path.append(candidates[index])
        # recurse
        self.backtrack(candidates, target - candidates[index], index, path)
        # backtrack - undo the action, remove the last element from the path list
        path.pop()

        


        