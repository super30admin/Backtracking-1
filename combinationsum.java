class Solution {
    List<List<Integer>> result;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result =new ArrayList<>();
        this.candidates=candidates;
        this.target=target;
        helper(0,0,new ArrayList<>());
        return result;
    }
    public void helper(int i, int total,List<Integer> path)
    {
        if(total==target)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if(i>candidates.length-1 || total>target) return;
        path.add(candidates[i]);
        helper(i,total+candidates[i],path);
        path.remove(path.size()-1);
        helper(i+1,total,path);
    }
}