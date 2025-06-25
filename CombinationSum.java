class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      if (candidates == null || candidates.length == 0)
            return new ArrayList<>();
        this.result = new ArrayList<>();

        // helper_tochooseFirst(candidates, 0, target, new ArrayList<>());
        // helper_notTochooseFirst(candidates, 0, target, new ArrayList<>());
        // helper_01recursion(candidates, 0, target, new ArrayList<>());
        helper_forRecursion(candidates, 0, target, new ArrayList<>());
         return result;  

        
    }
    private void helper_notTochooseFirst(int[] candidates, int idx, int target, List<Integer> path) {
        //base
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || idx >= candidates.length) {
            return;
        }
        //logic 
        //not choose 
        helper_notTochooseFirst(candidates, idx+1, target, new ArrayList<>(path));

        path.add(candidates[idx]);
        //tochoose
        helper_notTochooseFirst(candidates, idx, target-candidates[idx], new ArrayList<>(path));

    }

     private void helper_tochooseFirst(int[] candidates, int idx, int target, List<Integer> path) {
        //base
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || idx >= candidates.length) {
            return;
        }
        //logic 
        List<Integer> li = new ArrayList<>(path);
        li.add(candidates[idx]);
        //tochoose
        helper_tochooseFirst(candidates, idx, target-candidates[idx], li);

        //not choose 
        helper_tochooseFirst(candidates, idx+1, target, new ArrayList<>(path));

    }

     //01 recursion

    private void helper_01recursion(int[] candidates, int idx, int target, List<Integer> path) {
        //base
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || idx >= candidates.length) {
            return;
        }
        //logic
        //not choose
        helper_01recursion(candidates, idx + 1, target, path);
        //to choose
        path.add(candidates[idx]);
        helper_01recursion(candidates, idx, target - candidates[idx], path);
        //backtrack
        path.remove(path.size() - 1);

        return;
    }

    //For rescursion
    private void helper_forRecursion(int[] candidates, int pivot, int target, List<Integer> path){
        //base
        if(target==0){
            result.add(new ArrayList<>(path));
        }
        if(target<0) return;
        //logic
        for(int i= pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            helper_forRecursion(candidates, i, target-candidates[i], path);
            path.remove(path.size()-1);
        }
        
    } 

}