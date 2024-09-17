// Time Complexity : O(n*4^n) (Exponential)
// Space Complexity : O(n) (Recursive Stack)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        //string, target, index, calc, tail, path
        helper(num, target, 0, 0, 0, "");
        return result;
    }
    private void helper(String num, int target, int index, long calc, long tail, String path) {
        //base case
        if(num.length() == index) {
            if(target == calc) 
                result.add(path);
        return;
        }
        for(int i=index; i<num.length(); i++) {
            Long curr = Long.parseLong(num.substring(index,(i+1)));
            if(num.charAt(index) == '0' && index != i) break;
            if(index == 0) {
                helper(num, target, i+1, curr, curr, curr+path);
            }
            else {
                //+
                helper(num, target, i+1, calc+curr, curr, path+"+"+curr);
                //-
                helper(num, target, i+1, calc-curr, -curr, path+"-"+curr);
                //*
                helper(num, target, i+1, calc-tail+tail*curr, tail*curr, path+"*"+curr);
            }
        } 
    }
}