class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        helper(target, candidates, result, 0, new ArrayList<>());
        
        return result;
        
    }

    public void helper(int target, int[] candidates, List<List<Integer>> result, int pivot, List<Integer> path){

        //base case
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0 || pivot == candidates.length){
            return;
        }


        //for loop base recursion
        for(int i = pivot; i < candidates.length; i++){

            path.add(candidates[i]);

            helper(target - candidates[i], candidates, result, i, path);

            //backtrack
            path.remove(path.size() - 1);

        }
    }
}

// TC - O(2^(m+n))
// SC - O(n^2)