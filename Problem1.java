//Problem1 
//Combination Sum (https://leetcode.com/problems/combination-sum/)

// Time Complexity : O(2**(m+n))
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// 1. recursion =>choose or not choose and backtrack
// 2. recursion+forloop => for every pivot, run helper for every baby one by one using for loop

//recursion+backtracking
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> result = new ArrayList<>();
//         if(candidates==null||candidates.length==0) return result;
//         helper(candidates, 0, new ArrayList<>(), target, result );
//         return result;
//     }
//     private void helper(int[] candidates, int index,List<Integer> path,int target, List<List<Integer>> result){
//             //base
//             if(target==0) {result.add(new ArrayList<>(path)); return;}
//             if(target<0||index==candidates.length) return;
//             //logic
//             //not choose
//             helper(candidates, index+1, path, target, result);
//             //action
//             path.add(candidates[index]);
//             //choose
//             helper(candidates, index, path, target-candidates[index], result);
//             //backtracking
//             path.remove(path.size()-1);
//     }
// }

//froloop based recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result= new ArrayList<>();
        if(candidates==null||candidates.length==0) return result;
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
    private void helper(int[] candidates, int pivot,List<Integer> path,int target){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0||pivot==candidates.length) return;
        for(int i=pivot; i<candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recursion
            helper(candidates,i,path,target-candidates[i]);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}