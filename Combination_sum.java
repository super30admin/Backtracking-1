// Normal solution
//Time complexity: m+n
//space complexity: o(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates, target, new ArrayList<>(), 0);
        return result;
        
    }
    private void backtrack(int[] candidates, int target, List<Integer> path, int i){
        //base
        
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
            
        }
        if(target < 0 || i == candidates.length){
            return;
        }
        
        //logic
        //case1 dont choose
        backtrack(candidates, target, path, i+1);
        //case 2 choose
        //action
        path.add(candidates[i]);
        //recurse
        backtrack(candidates, target - candidates[i], path, i);
        //backtrack
        path.remove(path.size()-1);
            
        
    }
}

//Pivot method

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates, target, new ArrayList<>(), 0);
        return result;
        
    }
    private void backtrack(int[] candidates, int target, List<Integer> path, int index){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        
        //logic
        for(int i = index; i<candidates.length; i++ ){
            path.add(candidates[i]);
            
            backtrack(candidates, target- candidates[i], path, i);
            
            path.remove(path.size() - 1);
        }
            
        
    }
}
