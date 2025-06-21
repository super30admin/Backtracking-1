//Time Complexity: O(2^(m+n))
//Space Complexity:

//Solution: NoChoose scenraio first, choose scenario second using deep copy. Without Backtracking 

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;   
    }

    private void helper(int[] candidates, int idx, int target, List<Integer> path){
        //base

        if(target == 0){
            result.add(path);
            return;
        }

        if(idx == candidates.length || target < 0)
            return;

        //logic
        //no choose
        helper(candidates, idx+1, target, new ArrayList<>(path));

        //choose
        path.add(candidates[idx]);
        helper(candidates, idx, target-candidates[idx], new ArrayList<>(path));

    }
}


//Solution: Choose scenario first, NoChoose scenario second using 2 deep copies. Without Backtracking 

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;   
    }

    private void helper(int[] candidates, int idx, int target, List<Integer> path){
        //base

        if(target == 0){
            result.add(path);
            return;
        }

        if(idx == candidates.length || target < 0)
            return;

        //logic

        //choose
        List<Integer> lis = new ArrayList<>(path); //Same path should not be passed in this case so created a deep copy. 
        // It takes length of path time and extra space of path
        lis.add(candidates[idx]);
        helper(candidates, idx, target-candidates[idx], lis);

        //no choose
        helper(candidates, idx+1, target, new ArrayList<>(path));

       
    }
}

//Solution: Choose/NoChoose recursion + Backtracking
class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;   
    }

    private void helper(int[] candidates, int idx, int target, List<Integer> path){
        //base

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(idx == candidates.length || target < 0)
            return;

        //logic    //no choose
        helper(candidates, idx+1, target, path);

        //choose//action
        path.add(candidates[idx]);
        helper(candidates, idx, target-candidates[idx], path);

        //recurse
       path.remove(path.size()-1);
    }
}


//Solution: For loop based recursion + backtracking. This will be faster because we don't create deep copy at each n every node

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates,0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> path){
        //base
            if(target == 0){
                result.add(new ArrayList<>(path));
                return;
            }
            if(target < 0 || pivot == candidates.length)
                return;

        //logic
        for(int i = pivot; i<candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, target-candidates[i], path);
            //backtrack
            path.remove(path.size()-1);

        }
    }
} 

//Follow up: Permutation Sum. This will give all possible permutations

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates,0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> path){
        //base
            if(target == 0){
                result.add(new ArrayList<>(path));
                return;
            }
            if(target < 0 || pivot == candidates.length)
                return;

        //logic
        for(int i = 0; i<candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, target-candidates[i], path);
            //backtrack
            path.remove(path.size()-1);

        }
    }
}






 