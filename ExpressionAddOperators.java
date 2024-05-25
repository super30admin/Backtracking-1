// Time Complexity : O(4^N)
// Space Complexity : O(N) - auxilary stack space for recursive call
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int target, int pivot, long calc, long tail, String path)        {

        // base case
        if(pivot == num.length()) {
            if(calc == target) {
                result.add(path);
                return;
            }
        }

        //logic
        for(int i=pivot;i< num.length();i++) {

            if(num.charAt(pivot) == '0' && pivot != i) {
                continue;
            }
            long curr = Long.parseLong(num.substring(pivot, i+1));

            if(pivot == 0 ) {
                helper(num, target, i+1, curr, curr, path+curr);
            }else{
                //+
                helper(num, target, i+1, calc+curr, curr, path+ "+"+curr);
                //-
                helper(num, target, i+1, calc-curr, -curr, path+"-"+curr);
                //*
                helper(num, target, i+1, (calc-tail) +(tail*curr), tail*curr, path+"*"+curr);
            }


        }
    }
}