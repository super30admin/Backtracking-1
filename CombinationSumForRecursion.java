//TC :O(2^n)
//Space - O(n) 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(candidates,target,0,new ArrayList<>());
        return result;

        
    }
    private void recurse(int[] candidates, int target, int index, List<Integer> path){
        //Base case 
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        for(int i = index; i < candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            recurse(candidates,target - candidates[i],i,path);
            //backtrack
            //once base case is hit then recurse call gets ended and backtrack step is executed.
            path.remove(path.size()-1);
        }
     
    }
}
