import java.util.ArrayList;
import java.util.List;

/*
//recursion
class Solution {
  public List<String> addOperators(String num, int target) {
      List<String> res=new ArrayList<>();
      helper(num,target,0,res,0l,0l,"");
      return res;
  }

  private void helper(String num, int target, int pivot, List<String> res, long calc, long tail, String path){
      //base
      if(pivot==num.length()){
          if(calc==target){
              res.add(path);
          }
          return;
      }

      //logic
      for(int i=pivot;i<num.length();i++){
          //placeholder preceeding
          if(i!=pivot && num.charAt(pivot)=='0'){
              continue;
          }
          long curr=Long.parseLong(num.substring(pivot,i+1));
          if(pivot==0){
              helper(num, target,i+1,res,curr,curr,path+curr);
          }else{
              //+
              helper(num,target,i+1,res, curr+calc,curr,path+"+"+curr);

              //-
              helper(num,target,i+1,res, calc-curr,-curr,path+"-"+curr);

              //*
              helper(num,target,i+1,res, calc-tail+tail*curr,tail*curr,path+"*"+curr);
          }
          
      }
  }
}
*/

//TC: O(4^l)
//SC: O(l)

//backtrack
class ExpressionAddOperator {
  public List<String> addOperators(String num, int target) {
      List<String> res=new ArrayList<>();
      StringBuilder sb=new StringBuilder();
      helper(num,target,0,res,0l,0l,sb);
      return res;
  }

  private void helper(String num, int target, int pivot, List<String> res, long calc, long tail, StringBuilder path){
      //base
      if(pivot==num.length()){
          if(calc==target){
              res.add(path.toString());
          }
          return;
      }

      //logic
      for(int i=pivot;i<num.length();i++){
          //placeholder preceeding
          if(i!=pivot && num.charAt(pivot)=='0'){
              continue;
          }
          long curr=Long.parseLong(num.substring(pivot,i+1));
          int l=path.length();
          if(pivot==0){
              path.append(curr);
              helper(num, target,i+1,res,curr,curr,path);
              path.setLength(l);
          }else{
              //+
              path.append("+");
              path.append(curr);
              helper(num,target,i+1,res, curr+calc,curr,path);
              path.setLength(l);
              //-
              path.append("-");
              path.append(curr);
              helper(num,target,i+1,res, calc-curr,-curr,path);
              path.setLength(l);
              //*
              path.append("*");
              path.append(curr);
              helper(num,target,i+1,res, calc-tail+tail*curr,tail*curr,path);
              path.setLength(l);
          
          }
          
      }
  }
}