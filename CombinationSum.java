//TC:- O(2 ^ m+n), similar to coin change
//SC:- O(m+n), depth of recursion stack
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        //we will perform for loop recursion to solve this backtracking problem
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, 0, path, target);
        return result;
    }

    public void backtrack(int[] candidates, int pivot, List<Integer> path, int target) {

            //Fails
            if(pivot == candidates.length || target < 0) {
                return;
            }

            //base condition
            if(target == 0) {

                //we create deep copy for path, because entire recursion stack is pointing to same path 
                //we keep on adding to same path and removing as well. At the end it will be empty
                result.add(new ArrayList<>(path));
                return;
            }

        //logic
        //for loop recursion we use pivot, to get unique combinations of number
        for(int i = pivot; i < candidates.length; i++) {

            //we add index to path
            //action
            path.add(candidates[i]);
            //recurse
            backtrack(candidates, i, path, target - candidates[i]);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}