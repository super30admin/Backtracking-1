import java.util.ArrayList;
import java.util.List;

/*
//recursion
class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      res= new ArrayList<>();
      helper(candidates, target, 0,0,new ArrayList<>());
      return res;
  }

  private void helper(int[] candidates, int target, int idx, int sum, List<Integer> comb){
      if(sum>target || idx==candidates.length){
          return;
      }
      if(target==sum){

          res.add(comb);
          return;
      }
      //not choose
      helper(candidates, target, idx+1,sum,comb);
      //choose
      List<Integer> l1=new ArrayList<>(comb);
      l1.add(candidates[idx]);
      helper(candidates, target, idx,sum+candidates[idx],l1);
      
  }
}
*/
/*
//recursion with backtrack
class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      res= new ArrayList<>();
      helper(candidates, target, 0,0,new ArrayList<>());
      return res;
  }

  private void helper(int[] candidates, int target, int idx, int sum, List<Integer> comb){
      if(sum>target || idx==candidates.length){
          return;
      }
      if(target==sum){
          List<Integer> l1=new ArrayList<>(comb);
          res.add(l1);
          return;
      }
      //not choose
      helper(candidates, target, idx+1,sum,comb);
      //choose
      comb.add(candidates[idx]);
      helper(candidates, target, idx,sum+candidates[idx],comb);
      comb.remove(comb.size()-1);
  }
}   
*/

//TC:O( (m+n)2^(m+n)
//SC : O(m+n)
//for loop based recursion using backtrack
class CombinationSum {
  List<List<Integer>> res;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      res= new ArrayList<>();
      helper(candidates, target, 0,0,new ArrayList<>());
      return res;
  }

  private void helper(int[] candidates, int target, int pivot, int sum, List<Integer> comb){
      if(sum>target){
          return;
      }
      if(target==sum){
          List<Integer> l1=new ArrayList<>(comb);
          res.add(l1);
          return;
      }
      for(int i=pivot;i<candidates.length;i++){
          comb.add(candidates[i]);
          helper(candidates, target, i,sum+candidates[i],comb);
          comb.remove(comb.size()-1);
      }
  }
}