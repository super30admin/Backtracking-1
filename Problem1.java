
// Time complexity is O( 2 ^ (T/M)) where is target is the target  and m is the smallest number inthe candidatest the extra length we get when we keep on choosing smallest number
//Space complexity is  O(T/M) 
// combination sum using backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>() );

        return result;
        
    }

        private void helper(int[] candidates, int i, int target, List<Integer> path){

            if(target < 0 || i == candidates.length) {
                return ;
            }

            if(target == 0){
                result.add(new ArrayList<>(path));
                return;
            }
  //choose
            path.add(candidates[i]);
            helper(candidates, i, target- candidates[i], path);
            path.remove(path.size()-1);
            //not choose

            helper(candidates, i+1, target, path);

          


        }
}
