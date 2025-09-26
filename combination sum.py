'''
Solution 1: Choose/No-Choose based recursion with backtracking
Time Complexity: O(2^(m+n)), where m = len(candidates), n = target 
                 - eg. candidates = [1,2], target = 7 then [[1,1,1,1,1,1,1],[1,1,1,1,1,2],[1,1,1,2,2]..etc]
                    The idea being, recursion at 1 will be called 7 times deeper 
Space Complexity: O(n), n = target recursion stack 
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        combinations_list = []
        self.helper(candidates,target,0,[],combinations_list) # candidates, remaining target, index, curr_path,answer_list

        return combinations_list

    def helper(self,candidates,remaining_target,idx,curr_path,combinations_list):
        # base
        if remaining_target==0: # found new combination
            combinations_list.append(deepcopy(curr_path))
            return 
        
        if remaining_target<0 or idx==len(candidates):
            return

        # logic
        # no choose
        self.helper(candidates,remaining_target,idx+1,curr_path,combinations_list)

        # choose
        curr_path.append(candidates[idx]) # action
        self.helper(candidates,remaining_target-candidates[idx],idx,curr_path,combinations_list)
        curr_path.pop() # backtrack


'''
Solution 2: For loop based recursion with backtracking
Time Complexity: O(2^(m+n)), where m = len(candidates), n = target 
                 - eg. candidates = [1,2], target = 7 then [[1,1,1,1,1,1,1],[1,1,1,1,1,2],[1,1,1,2,2]..etc]
                    The idea being, recursion at 1 will be called 7 times deeper 
Space Complexity: O(n), n = target recursion stack 
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        combinations_list = []
        self.helper(candidates,target,0,[],combinations_list) # candidates, remaining target, pivot_index, curr_path,answer_list

        return combinations_list

    def helper(self,candidates,remaining_target,pivot_index,curr_path,combinations_list):
        # base
        if remaining_target==0: # found new combination
            combinations_list.append(deepcopy(curr_path))
            return
        
        if remaining_target<0:
            return 

        # logic
        for i in range(pivot_index, len(candidates)):
            curr_path.append(candidates[i]) # action
            self.helper(candidates,remaining_target-candidates[i],i,curr_path,combinations_list)
            curr_path.pop() # recurse