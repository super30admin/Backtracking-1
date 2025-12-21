# the recursive function checks if the target is 0. If it is, it appends the path to the 
# result and returns. If the target<0 or pivot == length of the caniddates, return. Else
# run a loop from pivot to the length of candidates. Add the number at the ith ind to the path
# and call the recursive function by subtracting the target. Pop the element from the list

# Time complexity: O(2^m+n)
# Space: O(max(m,n))

class Solution(object):
    
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]

        """
        self.result=[]
        if not candidates:
            return []
        else:
            self.helper(candidates, target, [], 0)
            return self.result
    

    def helper(self, candidates, target, path, pivot):

        if target ==0:
            self.result.append(path[:])
            return
        if target<0 or pivot==len(candidates):
            return
        
        for i in range(pivot, len(candidates)):
            path.append(candidates[i])

            self.helper(candidates, target-candidates[i], path,i)

            path.pop()