// Time Complexity : O(n*T)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//recursive , space - new list for every recursive call, more time for coying elements
// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         if(candidates == null || candidates.length == 0){
//             return new ArrayList<>();
//         }
//         res = new ArrayList<>();
//         recurse(candidates, target, 0, new ArrayList<>());
//         return res;
//     }

//     private void recurse(int[] candidates, int target, int index, List<Integer> path){
//         //base 
//         if(target< 0 || index == candidates.length){
//             return;
//         }
//         if(target == 0){
//             res.add(path);
//             return;
//         }
//         //logic
//         // 0/ not choose
//         recurse(candidates, target, index+1, new ArrayList<>(path));

//         //1/ choose  
//         path.add(candidates[index]);
//         recurse(candidates, target - candidates[index], index, new ArrayList<>(path));

//     }
// }

// backtrack
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> path){
        //base 
        if(target< 0 || index == candidates.length){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        // 0/ not choose
        backtrack(candidates, target, index+1, path);

        //1/ choose  
        path.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, path);

        //backtrack
        path.remove(path.size() - 1);

    }
}