//Time Complexity: 2 power (m+n)
//Space Compexity: O(m+n) + O(n)
//For primitive data type in result instead of exact path (list of integers etc.) we can use DP else use Backtracking for optimal solution

//Back Tracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int i, int target, List<Integer> path)
    {
        //Base case
        if(target < 0 || i == candidates.length){
            return;
        }

        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        //case 0
        helper(candidates, i+1, target, path);

        //case 1
        path.add(candidates[i]);
        helper(candidates, i, target-candidates[i], path);

        //backtrack
        path.remove(path.size() - 1); // remove last element added 
    }
}