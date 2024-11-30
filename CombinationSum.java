// Approach: Estabilish Decision Tree choose and dont choose. Perform Normal recursion.
// Time : n*O(2^n)
// Space : 
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.target = target;
        // edge case
        if(candidates == null || candidates.length == 0) return result;

        helper(candidates,0,new ArrayList<>(),0);
        return result;
        
    }

    public void helper(int[] candidates, int currSum, List<Integer> temp,int i){
        // Base case
        if(currSum > target || i>=candidates.length) return;
        if(currSum == target){
            result.add(temp);
            return;
        }

        // Logic
        // don't choose number
        helper(candidates,currSum,new ArrayList<>(temp),i+1);

        // choose number
        temp.add(candidates[i]);
        helper(candidates,currSum+candidates[i],new ArrayList<>(temp),i);
    }

}

// Approach: Recursion with Backtrack.
// Time : n*O(2^n) # exponential time same as recursion
// Space : O(n) # exponential space - through out the recursion we only have one list but at certain paths we are making copies
// and give results.
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.target = target;
        // edge case
        if(candidates == null || candidates.length == 0) return result;

        backtrack(candidates,new ArrayList<>(),0,0);
        return result;
    }

    public void backtrack(int[] candidates,List<Integer> temp,int currSum, int index){
        // Base case
        if(currSum > target || index>=candidates.length) return;
        if(currSum == target){
            result.add(new ArrayList<>(temp)); // create the copy of the original list
            return;
        }

        // Logic
        // iterating through pivot
        for(int i =index;i<candidates.length;i++){
            // action
            temp.add(candidates[i]);
            backtrack(candidates,temp,currSum+candidates[i],i); // same number twice again. so i
            // backtrack
            temp.remove(temp.size()-1);
        }
    }

}

// Approach: For loop based Recursion with Backtrack.
// Time : n*O(2^n) # exponential time same as recursion
// Space : O(n) # exponential space - through out the recursion we only have one list but at certain paths we are making copies
// and give results.
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.target = target;
        // edge case
        if(candidates == null || candidates.length == 0) return result;

        backtrack(candidates,new ArrayList<>(),0,0);
        return result;
    }

    public void backtrack(int[] candidates,List<Integer> temp,int currSum, int index){
        // Base case
        if(currSum > target || index>=candidates.length) return;
        if(currSum == target){
            result.add(new ArrayList<>(temp)); // create the copy of the original list
            return;
        }

        // Logic
        // iterating through pivot
        for(int i =index;i<candidates.length;i++){
            // action
            temp.add(candidates[i]);
            backtrack(candidates,temp,currSum+candidates[i],i); // same number twice again. so i
            // backtrack
            temp.remove(temp.size()-1);
        }
    }

}