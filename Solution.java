class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result; 
    }

    private void helper(int[] candidates, int i, int target, List<Integer> path)
    {
        //basecase
        if(i == candidates.length || target < 0) return;

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        //no chose case 
        helper(candidates, i+1, target, path);
        //chose case
        path.add(candidates[i]);
        helper(candidates, i, target - candidates[i], path);

        //backtrack
        path.remove(path.size()-1);


    }
}