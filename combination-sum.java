// //0-1 recursion //choose - not choose
// //TC = O(2^m+n) exponential = traversal. m=amount/target ,n=number of candidates
// //SC = O(n) for the recursion stack and the result list
// class Solution {
//     private List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         this.result = new ArrayList<>();
//         helper(candidates, 0, target, new ArrayList<>());
//         return result;
//     }
//     private void helper(int [] candidates, int idx, int target, List<Integer> path){
//         //base
//         if(target == 0){
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         if(idx==candidates.length || target<0) return;
        
//         //logic
//         //not choose
//         helper(candidates, idx+1, target, path);

//         //choose
//         //action
//         path.add(candidates[idx]);
//         //recurse
//         helper(candidates, idx, target-candidates[idx], path);
//         //backtrack
//         path.remove(path.size()-1);
//     }
// }

//for loop based recursion //is still chhose-not choose tree but tree shape has changed - from verticle to horizontal
//Time Complexity = O(2^m+n) = exponential
//Space Complexity = O(n)
class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int [] candidates, int pivot, int target, List<Integer> path){
        //base cases
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        
        //logic //PIVOT IS STATIC, i is iterating
        for(int i=pivot; i< candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, target-candidates[i], path);
            //backtrack
            path.remove(path.size()-1);
        }

        // //without backtracking //very slow //takes more time & space
        // for(int i=pivot; i< candidates.length; i++){
        //     //action
        //     List<Integer> li = new ArrayList<>(path); //create deep copy
        //     li.add(candidates[i]);
        //     //recurse
        //     helper(candidates, i, target-candidates[i], li);
        // }
    }
}