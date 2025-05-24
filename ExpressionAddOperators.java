// Time Complexity : O(4^n), n = no of digits in string, 4 comes from 4 operators
// Space Complexity : O(n) - recursive stack + stringbuilder path
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use backtracking to try inserting '+', '-', or '*' between digits at each step.
//   - Maintain a running total (calc), a tail to handle multiplication precedence, and a StringBuilder for the expression path.
//   - If a segment starts with '0' and has more than 1 digit (like '05'), skip to avoid invalid numbers.
//   - Base condition: If you've reached the end and the total matches the target, add the expression to the result.
//   - For multiplication, subtract the last operand from total and add back multiplied value to handle precedence.


import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    //brute force
    // List<String> result;
    // public List<String> addOperators(String num, int target) {
    //     this.result = new ArrayList<>();

    //     helper(num, target, 0, 0, 0, "");


    //     return result;
    // }

    // private void helper(String num, int target, int pivot, long calc, long tail, String path) {
    //     if(pivot == num.length()) {
    //         if(calc == target) {
    //             result.add(path);
    //         }
    //     }


    //     for(int i = pivot; i < num.length(); i++) {
    //         if(num.charAt(pivot) == '0' && i != pivot) {
    //             break;  //because all branches will be like 05, 056, etc and it will mess up calculations and will give some extra paths in result
    //         }
    //         long curr = Long.parseLong(num.substring(pivot, i + 1));

    //         if(pivot == 0) {    //0the level so no operators used
    //             helper(num, target, i+1, curr, curr, path + curr);  //concat curr to current path
    //         } else {
    //             //+
    //             helper(num, target, i+1, calc + curr, +curr, path + "+" + curr);

    //             //-
    //             helper(num, target, i+1, calc - curr, -curr, path + "-" + curr);

    //             //*
    //             helper(num, target, i+1, (calc - tail) + (tail * curr), tail * curr, path + "*" + curr);
    //         }

    //     }
    // }


    // Wuth backtracking
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void helper(String num, int target, StringBuilder sb, long calc, long tail, int index){
        // base condition
        if(index == num.length()){
            if(calc == target){
                result.add(sb.toString());
                return;
            }
        }

        // logic
        for(int i = index; i < num.length(); i++){
            // preceding zero case
            if(index != i && num.charAt(index) == '0') break;

            long curr = Long.parseLong(num.substring(index, i + 1)); // 1*5
            int len = sb.toString().length();

            if(index == 0){
                sb.append(curr); //action
                helper(num, target, sb ,curr, curr, i + 1); // recurse
                sb.setLength(len); // backtrack
            } else {
                sb.append("+");//action
                sb.append(curr);//action
                helper(num, target, sb, calc + curr, curr, i + 1); // recurse
                sb.setLength(len);// backtrack

                sb.append("-");//action
                sb.append(curr);//action
                helper(num, target, sb, calc - curr, -curr, i + 1); // // recurse
                sb.setLength(len);// backtrack

                sb.append("*");
                sb.append(curr);
                helper(num, target, sb, calc - tail + tail*curr, tail*curr, i + 1); // recurse
                sb.setLength(len);// backtrack

            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators solver = new ExpressionAddOperators();
        String num = "105";
        int target = 5;
        System.out.println("Valid expressions: " + solver.addOperators(num, target)); // ["1*0+5", "10-5"]
    }
}
