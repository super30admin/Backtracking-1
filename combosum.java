class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target);       
        return res;
    }
    private void helper(int[] candidates, int i, List<Integer> path, int target){
        //base
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || i>=candidates.length) return; 
        //logic
        //choose
        for(int index=0;index<candidates.length;index++){
            path.add(candidates[index]);
            helper(candidates,index,path,target-candidates[index]);
            path.remove(path.size()-1);
        }
    }
}
