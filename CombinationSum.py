# Time Complexity:
# O(2**n)

# Space Complexity:  
# O(n)

# Approach: 
# Backtracing based approach


class Solution(object):
    def __init__(self):
        self.result = []    # stores all combinations
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
    # =========================> Approach 4 -> For-loop Backtracking <========================= //
        if not candidates or len(candidates)==0:
            return []
        
        path = []
        self.recurse(candidates, target, 0 , path)
        return self.result

    def recurse(self, candidates, target, index, path):
        # base
        if target < 0:
            return

        if target == 0:
            self.result.append(list(path))
            return

        # logic
        for i in range(index, len(candidates)):
            # recurse
            path.append(candidates[i])
            self.recurse(candidates, target-candidates[i], i, path)
            path.pop(len(path)-1)