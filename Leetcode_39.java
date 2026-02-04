//Way1
//DFS - With backtracking
//Choose case - Same element can be choosen again - So, pass i as i only
//No choose case - element is not selected - So, move to next element. i.e., i+1
//Base case - check if sum==0. If yes, add to result
//And every step, back track the path to regain the orifinal state
//TC: 2^(m+n)
//SC: m+n
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(candidates,0,target,new ArrayList<>(),res);
        return res;
        
    }
    private void dfs(int[] candidates, int i, int target, List<Integer> path, List<List<Integer>> result){
        //base case
        if(target<0 || i==candidates.length){
            return;
        }

        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }


        //actual logic
        //no choose
        dfs(candidates,i+1,target,path,result);

        //choose
        path.add(candidates[i]);
        dfs(candidates,i,target-candidates[i],path,result);
        //backtrack
        path.remove(path.size()-1);
    }
}


//way2
//for loop based recurssion - with backtracking
//in for loop - start with i=0
//call with same i=0 till target becomes to negative
//Once target = 0, add the path to result
//And when iteration returned, new one will start with i+1
//process goes on
//TC: O(n * 2^(m+n)) where m is the candidates length and n is the target
//SC: O(n * h) -> O(n^2)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>(),ans);
        return ans;
        
    }
    private void helper(int[] candidates, int pivot, int target,List<Integer> path, List<List<Integer>> ans){
        if(target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(path));
        }

        for(int i=pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates,i,target - candidates[i],path,ans);
            path.remove(path.size()-1);
        }
    }
}
