// Time Complexity : O (n * 4^n)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        //call the backtrack function with a blank expression
        //index=0, val=0, tail=0
        backtrack(num, target, "", 0, 0L, 0L);
        return result;
    }
    void backtrack(String num, int target, String exp, int index, long val, long tail) {
        // base case - when index reaches num.length
        if(index == num.length()) {
            // if the target was reached, add to the result
            if(val == target) {
                result.add(exp);
            }
            return;
        }
        for(int i = index; i < num.length(); i++) {
            //avoid leading 0s
            if(num.charAt(index) == '0' && index != i) break;
            // extract a number
            String currNum = num.substring(index, i + 1);
            long currVal = Long.parseLong(currNum);
            // for the first index, there is nothing to compute, just add the current number
            // and recurse from next index
            if(index == 0) {
                backtrack(num, target, exp + currNum, i + 1, currVal, currVal);
                continue;
            }
            //addition
            backtrack(num, target, exp + "+" + currNum, i + 1, val + currVal, currVal);
            //subtraction
            backtrack(num, target, exp + "-" + currNum, i + 1, val - currVal, -currVal);
            //multiplication - note we are manipulating the result using the tail
            backtrack(num, target, exp + "*" + currNum, i + 1, (val - tail) + (tail * currVal), tail * currVal);
        }
    }

}
