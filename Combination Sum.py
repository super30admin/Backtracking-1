#Time Complexity: O(2^target) The recursion explores all possible ways to sum up to target, and in the worst case, the number of recursive calls grows exponentially, The worst-case scenario occurs when the smallest number is 1 (e.g., candidates = [1]), leading to approximately O(2^target) recursive calls.
#Space Complexity: O(2^target) We store all valid combinations in result, which can contain up to O(2^target) subsets in the worst case. Uses at most O(target) extra space in each recursion call.
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        def dfs(i,curr,total):
            #Base Case 1
            if(total==target):
                result.append(curr.copy())
                return
            #Base Case 2
            if(i>=len(candidates) or total>target):
                return
            #Choose Case
            curr.append(candidates[i])
            dfs(i,curr,total+candidates[i])
            #No Choose Case
            curr.pop()
            dfs(i+1,curr,total)
        dfs(0,[],0)
        return result