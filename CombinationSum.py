# -*- coding: utf-8 -*-
"""
Created on Mon Oct 19 20:05:36 2020

@author: Tripti Santani

Algorithm Used - Backtracking

Step 1: Declared output list globally to store  the list of the list of the combinations whose sum is equal to target
Step 2: Check for the base condition if empty candidates list is provided.If empty, return empty output list
Step 3: Define a helper function with arguments (self,candidates,target,index,sub_list)
Step 4: Check if target == 0, then append the sub_list to the output and return since if we add something to the list
        the result will be greater than target
Step 5: If target <0, that means the sum of elements in the sub_list is greater than target. Therefore, we discard that
        sublist and return nothing
Step 6: Start a for loop i with range(index,len(candidates)). This is to check for every combination for the 
        particular element in candidates.
Step 7: Append the candidates element at the ith position to the sub_list.
Step 8: Call the helper function again recursively with arguments (candidates,target-candidates[i],i,sub_list)
Step 9: If the output of the above helper function is empty, it means that sum of sub_list is grater than target
        If the sum gets greater by adding the candidates[i], we need to remove this element from the sub_list.
Step 10: Return the output
Step 11: In the combinationSum function, sort the function and call the helper function with 
         arguments (candidates,target,0,sub_list)
Step 12: Return the output

Time Complexity - O(N)
Space Complexity - O(N)

Code accepted on leetcode
        
"""

class Solution:
    def __init__(self):
        self.output = []
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        sub_list = []
        
        if candidates == None:
            return output
        
        candidates.sort()
        
        self.helper(candidates,target,0,sub_list)
        
        return self.output
        
#         Backtracking algorithm

    def helper(self,candidates,target,index,sub_list):
        if target == 0:
            self.output.append(sub_list[:])
            return
            
        if target<0:
            return
        
        for i in range(index,len(candidates)):
            sub_list.append(candidates[i])
            self.helper(candidates,target-candidates[i],i,sub_list)
            sub_list.remove(candidates[i])
            # print(sub_list)
            # output.append(sub_list)
            
        return self.output
            