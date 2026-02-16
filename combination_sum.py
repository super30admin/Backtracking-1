"""
time complexity: O(n*2^n) where n is the number of candidates. In the worst case, we explore all possible combinations of candidates, which can lead to 2^n combinations. Additionally, for each valid combination, we may need to copy the current list to the result, which takes O(n) time.
space complexity: O(n) in the worst case when the recursion depth is equal to the number of candidates. 
We use a backtracking approach to explore all possible combinations of candidates. 
We maintain a current list of numbers and a current sum. We start from the first candidate and recursively explore two possibilities: including the current candidate in the combination or     
skipping it. If the current sum exceeds the target, we backtrack and return. If the current sum equals the target, we add a copy of the current list to the result.
"""

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.target = target
        self.candidates = candidates
        self.helper([], 0, 0)
        return self.result
    
    def helper(self, curr_list, curr_sum, index):
        if index >= len(self.candidates) or curr_sum>self.target:
            return
        if curr_sum == self.target:
            self.result.append(copy.deepcopy(curr_list))
        for i in range(index, len(self.candidates)):
            curr_list.append(self.candidates[i])
            val = curr_sum + self.candidates[i]
            self.helper(curr_list, val, i)
            curr_list.pop()

        