//TC :O(2^n)
//Space - O(n) * number of times recursion is called. 
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
        if(target < 0 || index == candidates.length){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //case0
        recurse(candidates,target,index + 1, path); //create new list for each recursive call
        //action
        path.add(candidates[index]);
        //recurse
        recurse(candidates,target - candidates[index], index, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}

