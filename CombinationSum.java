class CombinationSum {
    List<List<Integer>> res;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      this.res = new ArrayList<>();
      List<Integer> path = new ArrayList<>();
      helper(candidates,0,path,target);
      return res;
  }
  private void helper(int[] candidates, int pivot, List<Integer> path, int target)
  {
      if(target <0)
      return;
      if(target==0)
      {
          res.add(new ArrayList(path));
      return;
              }
          for(int i=pivot;i<candidates.length;i++)
          {
              //action
              path.add(candidates[i]);
              //recurse
              helper(candidates,i,path,target-candidates[i]);
              //backtrack
              path.remove(path.size()-1);
          }
  }
}

//tc: O(2 ^ (n * target))
//sc: O(target + 2 ^ (n * target))