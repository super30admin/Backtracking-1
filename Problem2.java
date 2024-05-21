import java.util.*;

// Time Complexity : O(3^L), where L is the length of the input string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Since we are asked to include all the characters (digits) in the num string,
 * we cannot do it with choose, not choose approach.
 * <p>
 * The strategy here is to 1st figure out what numbers will be there in the expression.
 * <p>
 * We will start from a path that'll be an empty string. Therefore at first level we
 * just append the curr number to the path.
 * <p>
 * For other levels, we have 3 choices. +, -, *
 * + : We can add the curr number to the path.
 * - : We can subtract the curr number from the path.
 * * : We can multiply the curr number with the tail. Here we are subtracting
 * the tail and adding the tail*curr. We are subtracting because we want to undo the last
 * operation. We are adding tail*curr because we want to multiply the last number with the curr number.
 * <p>
 * We will also keep track of the calc and tail.
 * <p>
 * The calc will keep track of the value of the path.
 * The tail will keep track of the last operation in the path.
 * <p>
 * We will also keep track of the pivot, target.
 * <p>
 * We are also handling the preceding zero case. Ex. num = "105", target = 5
 * <p>
 * In without backtracking approach, we are creating a new string everytime we recurse
 * because we are concatenating the strings which creates a new string everytime.
 * Hence, we don't need to backtrack.
 * <p>
 * But in backtracking, we are using a StringBuilder. Hence, we need to backtrack.
 */


public class Problem2 {

    private List<String> res;


    //Without Backtracking
    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList<>();
        helper(num, 0, "", 0, 0, target);
        return res;
    }

    private void helper(String num, int pivot, String path, long calc, long tail, int target) {
        //base
        if (pivot == num.length()) {
            if (calc == target) {
                res.add(path);
            }
            return;
        }


        //logic
        for (int i = pivot; i < num.length(); i++) {

            //check for preceding zero case. Ex. num = "105", target = 5
            if (num.charAt(pivot) == '0' && i != pivot) continue;

            long curr = Long.parseLong(num.substring(pivot, i + 1));
            //check if its the 1st level. At this level, calc and tails remain same
            if (pivot == 0) {
                helper(num, i + 1, path + curr, curr, curr, target);
            } else {
                //Here we have 3 cases (operations)

                // +
                helper(num, i + 1, path + '+' + curr, calc + curr, curr, target);
                // -
                helper(num, i + 1, path + '-' + curr, calc - curr, -curr, target);
                // *
                helper(num, i + 1, path + '*' + curr, calc - tail + tail * curr, tail * curr, target);
            }

        }
    }

    //With Backtracking
    public List<String> addOperatorsBacktrack(String num, int target) {
        this.res = new ArrayList<>();
        helperBacktrack(num, 0, new StringBuilder(), 0, 0, target);
        return res;
    }

    private void helperBacktrack(String num, int pivot, StringBuilder path, long calc, long tail, int target) {
        //base
        if (pivot == num.length()) {
            if (calc == target) {
                res.add(path.toString());
            }
            return;
        }

        //logic
        for (int i = pivot; i < num.length(); i++) {
            //preceding zero case
            if (num.charAt(pivot) == '0' && i != pivot) continue;

            //1st level case
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            int length = path.length();
            if (pivot == 0) {
                //action
                path.append(curr);
                //recurse
                helperBacktrack(num, i + 1, path, curr, curr, target);
                //backtrack
                path.setLength(length);
            } else {
                // +
                ///action
                path.append('+').append(curr);
                ///recurse
                helperBacktrack(num, i + 1, path, calc + curr, curr, target);
                ///backtrack
                path.setLength(length);

                // -
                ///action
                path.append('-').append(curr);
                ///recurse
                helperBacktrack(num, i + 1, path, calc - curr, -curr, target);
                ///backtrack
                path.setLength(length);


                // *
                ///action
                path.append('*').append(curr);
                ///recurse
                helperBacktrack(num, i + 1, path, calc - tail + tail * curr, tail * curr, target);
                ///backtrack
                path.setLength(length);
            }
        }
    }
}
