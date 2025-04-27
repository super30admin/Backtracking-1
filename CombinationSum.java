//Approach 1 : 0-1 recursion - Backtracking
// Time Complexity : O(2^(m+n)) , m=target, n=size of array
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
1.Use a recursive approach to generate all possible combinations
2.At each recursive call, there are 2 choices : to include the current element or not include it.
3.If an element is included it can be included any number of times till the taget sum is reached or goes beyond.
4.If an element is excluded, it cannot be added again to the combination.
5. At each choose condition, add element to the current list
6. After the choose recursive call, backtrack list to its previosu state.
 */

class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        helper(candidates,0, new ArrayList<>(), target);

        return result;
    }

    void helper(int candidates[], int i, List<Integer> path, int target){

        if((i==candidates.length)||(target<0))
            return;

        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }

        //no choose
        helper(candidates,i+1, path, target);

        //choose
        //action
        path.add(candidates[i]);

        //recurse
        helper(candidates, i, path, target-candidates[i]);

        //backtrack
        path.remove(path.size()-1);

    }

}


// ****** Approach 2- For loop based recursion
// Time Complexity : O(2^(m+n)) , m=target, n=size of array
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        helper(candidates,0, new ArrayList<>(), target);

        return result;
    }

    void helper(int candidates[], int pivot, List<Integer> path, int target){

        if(target<0)
            return;

        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=pivot;i<candidates.length;i++){

            //action
            path.add(candidates[i]);

            //recurse
            helper(candidates, i, path, target-candidates[i]);

            //backtrack
            path.remove(path.size()-1);

        }

    }

}