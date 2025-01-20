class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  result = new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>(),result);
        return result;
    }

    private void helper(int[] candidates,int idx, int target,List<Integer> path,List<List<Integer>> result){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(target<0 || idx == candidates.length) return;

        //no choose 
        helper(candidates, idx+1, target, path, result);
        
        //recurse choose
        path.add(candidates[idx]);
        helper(candidates, idx, target - candidates[idx], path, result);
        //backtrack 
        path.remove(path.size()-1);


        

    }
}