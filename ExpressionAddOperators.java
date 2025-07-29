// Time Complexity : O(4^n)
// Space Complexity : O(n) //recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : find all permutations of slicing string into multiple numbers. We have 3 possibilities of placing operators.
/// Maintain curr to keep track fo current value of expression and a tail for previous value. For * operator, we need to 
/// reverse the previos operation (use tail) and then multiply current number to tail. If at the end of the string,
/// curr has value equal to target add it to result
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder("");
        helper(num, target, 0, 0, 0, path, res);
        return res;
    }
    private void helper(String num, int target, int pivot, long curr, long tail, StringBuilder path, List<String> res){
        if(pivot == num.length()){
            if(curr == target){
                res.add(path.toString());
            }
            return;
        }
        for(int i=pivot;i<num.length();i++){
            Long val = Long.parseLong(num.substring(pivot, i+1));
            //preceeding 0s case
            if(num.charAt(pivot) == '0' && i>pivot){
                return;
            }
            if(pivot == 0){
                path.append(val);
                helper(num, target, i+1, val, val, path, res);
                path.setLength(path.length()-(i+1-pivot));
            }
            else{
                int oldLen = path.length();
                //+
                path.append("+");
                path.append(val);
                helper(num, target, i+1, curr+val, val, path, res);
                path.setLength(oldLen);
                //-
                path.append("-");
                path.append(val);
                helper(num, target, i+1, curr-val, -1*val, path, res);
                path.setLength(oldLen);
                //*
                path.append("*");
                path.append(val);
                helper(num, target, i+1, curr-tail+tail*val, tail*val, path, res);
                path.setLength(oldLen);
            }
        }
        return;
    }
}