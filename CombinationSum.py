class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result =[ ]
        def backtrack(index,curr,curr_sum):
            if (curr_sum>target):
                return
            if (curr_sum==target):
                result.append(curr[:])
                return 
            if index<len(candidates):
                backtrack(index,curr+[candidates[index]],curr_sum+candidates[index])
                backtrack(index+1,curr,curr_sum)

        backtrack(0,[],0)
        return result