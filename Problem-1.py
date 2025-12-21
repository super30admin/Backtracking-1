

# Time Complexity : O(2^(m+n))
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# 1. Use DFS/backtracking to explore all combinations of candidates that sum up to the target.
# 2. Track the current combination (path) and remaining target, allowing repeated use of each candidate.
# 3. Add a copy of the path to the result when the remaining target becomes 0, and backtrack to explore other options.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    public void helper(int[] candidates, int target, int pivot, List<Integer> path){
        if (target < 0 ){
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates,target-candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, target,[],0)
        return self.result
    def helper(self,candidates,target, path, pivot):
        if target <0:
            return
        if target == 0:
            self.result.append(list(path))
            return
        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,target-candidates[i], path, i)
            path.pop()
        
        