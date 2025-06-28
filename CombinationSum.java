class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path){
        // base case
        if(target == 0){
            result.add(path);
            return;
        }
        if(target < 0) return;
        // logic
        for(int i = pivot; i < candidates.length; i++){
            path.add(candidates[pivot]);
            helper(candidates, target - candidates[pivot], i,new ArrayList<>(path));
        }
    }
}
