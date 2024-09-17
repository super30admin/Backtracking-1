// Time Complexity : O(n*4^n) (Exponential)
// Space Complexity : O(n) (Recursive Stack)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        //string, target, index, calc, tail, path
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }
    private void helper(String num, int target, int index, long calc, long tail, StringBuilder sb) {
        //base case
        if(num.length() == index) {
            if(target == calc) 
                result.add(sb.toString());
        return;
        }
        for(int i=index; i<num.length(); i++) {
            Long curr = Long.parseLong(num.substring(index,(i+1)));
            int len = sb.toString().length();
            if(num.charAt(index) == '0' && index != i) break;
            if(index == 0) {
                sb.append(curr);
                helper(num, target, i+1, curr, curr, sb);
                sb.setLength(len);
            }
            else {
                //+
                sb.append("+");
                sb.append(curr);
                helper(num, target, i+1, calc+curr, curr, sb);
                sb.setLength(len);
                //-
                sb.append("-");
                sb.append(curr);
                helper(num, target, i+1, calc-curr, -curr, sb);
                sb.setLength(len);
                //*
                sb.append("*");
                sb.append(curr);
                helper(num, target, i+1, calc-tail+tail*curr, tail*curr, sb);
                sb.setLength(len);
            }
        } 
    }
}