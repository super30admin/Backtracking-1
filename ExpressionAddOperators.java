//package Backtracking-1;

import java.util.*;

public class ExpressionAddOperators {
    List<String> res;
    private List<String> solution(String num, int target){
        this.res = new ArrayList<>();
        helper(num, 0, 0l, 0l, "", target);
        return res;
    }

    private void helper(String num, int pivot, long calc , long tail, String path , int target){

        //base 
        if(pivot == num.length()){
            if(calc == target) {
                res.add(path);
            }
            return;
        }


        //logic
        for(int i = pivot; i< num.length();i++){
            //preceeding 0 
            if(num.charAt(pivot)=='0' && i>pivot){
                continue;
            }

            //what if > 10 digits
            long cur = Long.parseLong(num.substring(pivot, i+1));
            if(pivot==0){
                helper(num, i+1, cur, cur, path+cur, target);
            }
            else{

            //recurse
            //+
            helper(num, i+1, calc + cur, cur, path + "+" + cur, target);


            //-
            helper(num, i+1, calc - cur, -cur, path + "-" + cur, target);

            //* 
            helper(num, i+1, calc - tail + tail * cur, tail * cur, path + "*" + cur, target);
            }
        }
    }

    public static void main(String[] args){
        String num = "123";
        int target = 6;
        ExpressionAddOperators solver = new ExpressionAddOperators();
        List<String> res = solver.solution(num, target);
        System.out.println("List = "+ res);

    }

    
}
