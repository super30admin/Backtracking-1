// Time Complexity : 2 ^ (n+m)
// Space Complexity : (m + n)
// Did this code run successfully on leetcode: Yes
// Have you faced any problem while coding this problem : Yes, had to refer the video multiple times to understand when to create a deep copy and how the path is getting affected
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         this.result = new ArrayList<>();
//         helper(candidates, 0, target, new ArrayList<>());
//         return result;
//     }

//     private void helper(int[] candidates, int i, int target, List<Integer> path) {
//         //0-1 recursion
//         //base case
//         if(target == 0) {
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         if(target < 0 || i == candidates.length) return;

//         //logic
//         //don't choose
//         helper(candidates, i+1, target, path);
//         //choose
//         //action
//         path.add(candidates[i]);
//         //recurse
//         helper(candidates, i, target-candidates[i], path);
//         //backtrack
//         path.remove(path.size()-1);
        

//     }
        
// }
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         this.result = new ArrayList<>();
//         helper(candidates, 0, target, new ArrayList<>());
//         return result;
//     }

//     private void helper(int[] candidates, int pivot, int target, List<Integer> path) {
//         //base case
//         if(target == 0) {
//             result.add(path);
//             return;
//         }
//         if(target < 0 || pivot == candidates.length) {
//             return;
//         }

//         //logic
//         for(int i = pivot; i < candidates.length; i++) {
//             List<Integer> li = new ArrayList<>(path);
//             li.add(candidates[i]);
//             helper(candidates, i, target-candidates[i], li);
//         }
//     }
// }
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> path) {
        //base case
        if(target == 0) {
            result.add(path);
            return;
        }
        if(target < 0) {
            return;
        }

        //logic
        for(int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, target-candidates[i], new ArrayList<>(path));
            path.remove(path.size()-1);
        }
    }
}