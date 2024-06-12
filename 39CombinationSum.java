/*
Using 0-1 based recursion
TC: O(2^m+n)
SC: O(n+m)
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, target, 0, path);
        return result;
    }
    private void helper(int[] candidates, int target, int idx,List<Integer> path){
        //base
        if(target == 0 ){
            result.add(new ArrayList<>(path));
            return;
        }
        if( target < 0 || idx == candidates.length ) return;
        //not-choose
        helper(candidates, target, idx+1, path);
        //choose
        path.add(candidates[idx]);
        helper(candidates, target - candidates[idx], idx, path);
        path.remove(path.size()-1);
    }
}



/*
for-loop based recursion
TC: O(2^m+n)
SC: O(n+m)
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if( candidates == null || candidates.length ==0) return result;
        helper(candidates, target, 0, path);
        return result;
    }
    private void helper(int[] candidates, int target, int pivot, List<Integer> path){
        if(target == 0 ){
            result.add(new ArrayList<>(path));
            return;
        }
        if( target < 0 ) return;
        for(int i = pivot ; i < candidates.length; i++){
            List<Integer> li = new ArrayList<>(path);
            li.add(candidates[i]);
            helper(candidates, target - candidates[i], i, new ArrayList<>(li));
        }
    }
}
