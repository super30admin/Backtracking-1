//39. Combination Sum - https://leetcode.com/problems/combination-sum/description/
//Time Complexity: O(n * 2^(m+n))
//Space Complexity: O(n * 2^(m+n) + (m+n)) recursive Stack Space
//Recursive Approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path){
        //base case
        if(target == 0){
            result.add(path);
            return;
        }
        if(i == candidates.length || target<0){
            return;
        }

        //logic
        //don't choose
        helper(candidates, target, i+1, new ArrayList<>(path));

        //choose
        path.add(candidates[i]);
        helper(candidates, target-candidates[i], i, new ArrayList<>(path));
    }
}



//Time Complexity: O(2^(m+n))
//Space Complexity: O(n)+(m+n)
//Backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path){
        //base case
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(i == candidates.length || target<0){
            return;
        }

        //logic
        //don't choose
        helper(candidates, target, i+1, new ArrayList<>(path));

        //choose case
        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates, target-candidates[i], i, new ArrayList<>(path));
        //backtrack
        path.remove(path.size()-1);
    }
}


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path){
        //base case
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(pivot == candidates.length || target<0){
            return;
        }

        //logic
        for(int i=pivot; i<candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target-candidates[i], i, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}