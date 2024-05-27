class Solution:
    """
    Time Complexity: n * 2 ^ n
    Space Complexity: O(N)

    Approach: 
        - We take backtracking approach (exhaustive)
        - we recurse until we go out of bound with the pivot or target < 0
        - if target == 0 
            - we add the copy of the path to the result list
    """

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = list()
        self.helper(candidates, target, [], 0)
        return self.result
    
    def helper(self, cand_lst, target, path, pivot):
        #Base
        if target < 0 or pivot == len(cand_lst):
            return
        if target == 0:
            self.result.append(path.copy())
            return
        
        # Logic
        for i in range(pivot, len(cand_lst)):
            # Action
            path.append(cand_lst[i])
            # Recurse
            self.helper(cand_lst, target - cand_lst[i], path, i)
            # Pop
            path.pop()
        

    """
    Time Complexity: n * 2 ^ n
    Space Complexity: O(N)

    Approach: 
        - We take the 0 1 recursive approach
        - At each step we choose or not choose the candidate
            - if we don't chose we increase the index by 1
            - we keep the target as same
            -if we choose then we keep the index as same 
            - we decrease the target by candidate chosen

            - if target < 0 or if index goes out of bound we return
            - if target == 0 we add the copy of the path to the result
        - In the end we return the result
    """

    # def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    #     self.result = list()
    #     self.helper(candidates, target, [], 0)
    #     return self.result
    
    # def helper(self, cand_lst, target, path, i):
    #     #Base
    #     print ("path=", path)
    #     if target < 0 or i == len(cand_lst):
    #         return
    #     if target == 0:
    #         a = path.copy()
    #         self.result.append(a)
    #         return
    #     #Logic
    #     #Choose
    #     path.append(cand_lst[i])
    #     self.helper(cand_lst, target - cand_lst[i], path, i)
    #     path.pop()

    #     #Not Choose 
    #     self.helper(cand_lst, target, path, i+1)
