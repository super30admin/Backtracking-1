// Time Complexity: O(2^t) – In the worst case, we explore all combinations where t is the target value (not the array size), due to repeated additions of the same number.
//Space Complexity: O(t) – Maximum depth of the recursion stack and path list can go up to the target value t.

//Use backtracking to explore combinations of numbers summing to the target.
//At each index, choose whether to include the current number (stay on same index) or exclude it (move to next index).
//Add the combination to the result list only if the target becomes zero.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
        {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        recurse(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int target, int index, List<Integer> path)
    {
        if(index == candidates.length || target < 0)
        {
            return;
        }

        if(target ==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        
        path.add(candidates[index]);
        recurse(candidates, target - candidates[index], index, path);
        path.remove(path.size()-1);
        recurse(candidates, target, index+1, path);
    }
}