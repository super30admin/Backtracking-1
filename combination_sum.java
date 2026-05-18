//Time Complexity - O(n*2 ^ (m+n))
//Space Complexity - O(n^2)
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         this.result= new ArrayList<>();
//         helper(candidates,target,new ArrayList<>(),0);
//         return result;
//     }
//     private void helper(int[] candidates,int target, List<Integer> path,int i){
//         //base
//         if(target==0) {
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         if(target<0 || i==candidates.length) return; 
//         //logic
//         //0
//         helper(candidates,target,new ArrayList<>(path),i+1);
//         //action
//         path.add(candidates[i]);
//         // System.out.println(path);
//         //1
//         //recurse
//         helper(candidates,target-candidates[i],new ArrayList<>(path),i);
//     }
// }

//Time Complexity - O(2 ^ (m+n))
//Space Complexity - O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result= new ArrayList<>();
        helper(candidates,target,new ArrayList<>(),0);
        return result;
    }
    private void helper(int[] candidates,int target, List<Integer> path,int i){
        //base
        if(target==0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || i==candidates.length) return; 
        //logic
        //0
        helper(candidates,target,path,i+1);
        //action
        path.add(candidates[i]);
        // System.out.println(path);
        //1
        //recurse
        helper(candidates,target-candidates[i],path,i);
        //backtrack
        path.remove(path.size()-1);
    }
}