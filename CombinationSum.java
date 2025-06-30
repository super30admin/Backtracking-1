class Solution {
    //for-loop based recursion
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        helper(candidates , 0 , target , path ,result );
        return result;
    }
    private void helper(int[] candidates , int currentindex , int target , List<Integer>path,  List<List<Integer>>result){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path)); // Create a new list copying all elements of 'path' at this moment and add it to 'result'. This prevents future changes to 'path' (during backtracking) from affecting the stored solution.
            return;
        }
        if(currentindex == candidates.length || target < 0){
            return;
        }

        //logic
        for(int i = currentindex ; i < candidates.length ; i++){
            path.add(candidates[i]);
            helper(candidates , i , target - candidates[i] , path , result);
            path.remove(path.size()-1);

        }
    }


    //0-1 based recursion
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>>result = new ArrayList<>();
//         List<Integer>path = new ArrayList<>();
//         helper(candidates , 0 , target , path ,result );
//         return result;
//         }
//     private void helper(int[] candidates , int currentindex , int target , List<Integer>path , List<List<Integer>>result){
//         //base
//         if(target == 0){
//             result.add(new ArrayList<>(path)); // Create a new list copying all elements of 'path' at this moment and add it to 'result'.
// // This prevents future changes to 'path' (during backtracking) from affecting the stored solution.
//             return;
//         }
//         if(currentindex == candidates.length || target < 0){
//             return;
//         }
//         //logic
        
//         //choose 
//         path.add(candidates[currentindex]);
//         helper(candidates , currentindex , target - candidates[currentindex] , path , result);
//         path.remove(path.size() - 1);  // backtrack
//         //notchoose
//         helper(candidates , currentindex+1 , target , path , result);
        

//     }
}