//for loop based recursion / backtracking
// TC: O(N ^ T/M) where T is target and M is smallest val in candidate
// SC: O(T/M)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return new ArrayList<>();
        
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path){
        
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            List<Integer> newlist = new ArrayList<>(path);
            newlist.add(candidates[i]);
            helper(candidates, target - candidates[i], i, newlist);

            // path.add(candidates[i]);
            // helper(candidates, target - candidates[i], i, path);
            // path.remove(path.size() - 1);
        }
    }
}


// //backtracking >> less space, less time compared to recursion
// TC: SC: 

// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         result = new ArrayList<>();
//         if(candidates == null || candidates.length == 0) return new ArrayList<>();
//         helper(candidates, target, 0, new ArrayList<>());
//         return result;
//     }
//     private void helper(int[] candidates, int target, int index, List<Integer> path){
//         if(index >= candidates.length) return;
//         if(target < 0) return;
//         if(target == 0){
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         helper(candidates, target, index + 1, path);
//         path.add(candidates[index]);
//         helper(candidates, target - candidates[index], index, path);
//         path.remove(path.size() - 1);
//     }
// }

//Recursion

// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         result = new ArrayList<>();
//         if(candidates == null || candidates.length == 0) return new ArrayList<>();
//         helper(candidates, target, 0, new ArrayList<>());
//         return result;
//     }
//     private void helper(int[] candidates, int target, int index, List<Integer> path){
//         if(index >= candidates.length) return;
//         if(target < 0) return;
//         if(target == 0){
//             result.add(path);
//             return;
//         }
//         helper(candidates, target, index + 1, new ArrayList(path));
//         path.add(candidates[index]);
//         helper(candidates, target - candidates[index], index, new ArrayList(path));
//     }
// }
