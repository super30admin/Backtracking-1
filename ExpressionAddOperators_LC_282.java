import java.util.ArrayList;
import java.util.List;

/*
DFS-
Time Complexity - O(4^N * N)
Space Complexity - O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class ExpressionAddOperators_LC_282 {
    public List<String> addOperators(String num, int target) {
        ArrayList<String> output = new ArrayList<>();

        dfs(num, target, "",0, 0l, 0l, output);
        return output;
    }
    private void dfs(String num, int target, String path, int pivot, long calc, long tail,ArrayList<String> output) {
        //base case
        if(pivot == num.length()){
            if(calc == target){
                output.add(path);
            }
        }

        //logic
        for(int i = pivot; i<num.length(); i++) {

            //String curString = num.substring(pivot, i+1);
            long curStringNum = Long.parseLong(num.substring(pivot, i+1));
            //in preceding 0 case just continue else it will yield incorrect result
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            if(pivot == 0) { //this is the beginning of string and need not require operand
                dfs(num, target, path + curStringNum, i+1, curStringNum, curStringNum, output);

            } else {
                //+
                dfs(num, target, path + "+" + curStringNum, i+1, calc + curStringNum,  curStringNum, output);

                //-
                dfs(num, target, path+ "-"+ curStringNum, i+1, calc - curStringNum,  -curStringNum, output);

                //*
                dfs(num, target, path+ "*" + curStringNum, i+1, calc - tail + tail* curStringNum, tail * curStringNum, output);
            }
        }

    }

}

