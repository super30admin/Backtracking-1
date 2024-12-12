// Time Complexity :O(4 pow n) (3 operators and 1 for not choosing operator)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num, 0, 0, 0, "", target);
        return res ;
    }

    private void helper(String num, int pivot, long calc, long tail, String path,int target){
        if(pivot == num.length()){
            if(calc == target){
                res.add(path);
            }
        }

        for(int i=pivot; i<num.length(); i++){
            if(num.charAt(pivot)=='0' && i!=pivot) continue;
            long currNum = Long.parseLong(num.substring(pivot, i+1));
            if(pivot==0){
                helper(num, i+1, currNum, currNum,path+currNum,target);
            }else{
                //+
                helper(num,i+1, calc+currNum,currNum,path+"+"+currNum, target);

                //-
                helper(num, i+1, calc-currNum,-currNum,path+"-"+currNum, target);

                //*
                helper(num, i+1, (calc-tail)+(tail*currNum), tail*currNum, path+"*"+currNum, target);
            }
        }
    }
}
