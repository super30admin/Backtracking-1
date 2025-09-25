# Time Complexity : O(N) where N is the size of the list of candidates
# Space Complexity : O(N) where N is the size of the recursion stack in the worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am keeping an empty list to store the final answer.
# I am using a helper function to perform backtracking.
# The helper function takes the remaining target, current path and pivot index as input.
# If the target is less than 0, I return as it is not a valid combination.
# If the target is 0, I append the current path to the answer list as it is a valid combination.
# I iterate through the candidates starting from the pivot index to avoid duplicates.
# For each candidate, I append it to the current path and call the helper function recursively with
# the updated target (target - candidate), current path and the same pivot index (as we can reuse the same element).
# After the recursive call, I pop the last element from the current path to backtrack and try the next candidate.
# Finally, I return the answer list.



from typing import List
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        def helper(target,path,pivot):
            if target < 0:
                return 
            if target == 0:
                ans.append(list(path))
                return 
            for i in range(pivot,len(candidates)):
                path.append(candidates[i])
                helper(target-candidates[i],path,i)
                path.pop()
        helper(target,[],0)
        return ans

        