// Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

// Time Complexity : O(4^l) l is length of the string
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse along the length of the string taking pivot startingly at 0. if the char at ith position when it is not pivot then
 * continue. Take the element of string from pivot to i+1 position and if pivot == 0 then take calc as curr, tail as curr and add curr
 * to path else there are 3 conditions one is +, -, * for each case add curr to path and calculate calc and tail for each case. If
 * pivot == num.length and calc == target then add path to result and finally return result. 
 */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        helper(num, 0, 0, 0, path, target, result);
        return result;
    }
    private void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target, List<String> result){
        //base case
        if(pivot == num.length()){
            if(calc == target){
                result.add(path.toString());
            }
            return;
        }

        //Action
        for(int i = pivot; i< num.length();i++){
            if (i != pivot && num.charAt(pivot) == '0') continue;
            long curr = Long.parseLong(num.substring(pivot, i+1));
            int len = path.length();
            // if the digit is a preceeding zero
            if(pivot == 0){
                path.append(curr);
                helper(num, i+1, curr, curr, path, target, result);
                path.setLength(len);
            }
            else{
                //+
            path.append("+");
            path.append(curr);
            helper(num, i+1, calc+curr ,curr, path, target, result);
            path.setLength(len);

            //-
            path.append("-");
            path.append(curr);
            helper(num, i+1, calc-curr, -curr, path, target, result);
            path.setLength(len);

            //*
            path.append("*");
            path.append(curr);
            helper(num, i+1, calc-tail+(tail * curr), tail * curr, path, target, result);
            path.setLength(len);
            }

        }
    }
}