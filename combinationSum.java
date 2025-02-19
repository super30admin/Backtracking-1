// tc: O(2^m+n)
// sc:O(2^m+n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates,0,target,path);

        return result;
    }

    private void helper(int[] candidates,int pivot,int target,List<Integer> path){
        // base
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || pivot==candidates.length) return;
        // logic

        for(int i=pivot;i<candidates.length;i++){
            // action
            path.add(candidates[i]);
            // recurse
            helper(candidates,i,target-candidates[i],path);
            // backtrack
            path.remove(path.size()-1);
        }
    }
}