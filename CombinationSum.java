class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 1 && candidates[0] != target)
            return new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, res, path);
        return res;
    }

    private void helper(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> path){
        if(target<0 || index == candidates.length){
            return;
        }

        if(target == 0){
           res.add(new ArrayList<>(path));
           return;
        }
        //No Choose
        helper(candidates, target, index+1, res, path);

        path.add(candidates[index]);
        
        //Choose
        helper(candidates, target - candidates[index], index, res, path);

        path.remove(path.size()-1);
    }
}