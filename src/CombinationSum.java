// 0-1 Recursion
// TC : O(n)
// SC : O(h)
class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates,0, new ArrayList<>(), target);
        return result;
    }

    private void helper(int[] candidates,int i,List<Integer> path, int target) {
        if (i == candidates.length || target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 0 case
        helper(candidates, i+1,path, target);
        // 1 case
        path.add(candidates[i]);
        helper(candidates, i, path,target - candidates[i]);
        path.remove(path.size()-1);
    }
}


// for-loop based recursion
// TC : O(n)
// SC : O(h)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates,0, new ArrayList<>(), target);
        return result;
    }

    private void helper(int[] candidates,int start,List<Integer> path, int target) {
        if(start == candidates.length || target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start;i<candidates.length;i++) {
            path.add(candidates[i]);
            helper(candidates, i, path, target - candidates[i]);
            path.remove(path.size()-1);
        }
    }
}