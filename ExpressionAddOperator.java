// Time Complexity : O(4^n) n is the length of the input string (just say exponential)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// in this for loop based recursion, pivot takes care of the starting index of new number and loop takes care of the ending index of new number.
// in the initial call, we don't have any operator to add before the first number, we call the recursion without any operator and just add the number to the path.
// for the subsequent calls, we have 3 options +,-,* to add before the new number. We handle the previous calculation in tail and calculate new value accordingly.
// We use long to prevent overflow of integer values.
// We backtrack the path string builder to previous length after every recursion call.

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList();
        helper(num,target,0,0l,0l,new StringBuilder());
        return result;
    }

    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder path){
        //base
        if(pivot == num.length()){
            if(calc == target)
                result.add(path.toString());
            return;
        }

        //logic
        for(int i=pivot;i<num.length();i++){
            long cur = Long.parseLong(num.substring(pivot,i+1));
            int l = path.length();
            if(num.charAt(pivot) == '0' && i!=pivot) continue;
            if(pivot == 0){
                path.append(cur);
                helper(num,target,i+1,cur,cur,path);
                path.setLength(l);
            }else{
                path.append("+");
                path.append(cur);
                helper(num,target,i+1,calc+cur,cur,path);
                path.setLength(l);

                path.append("-");
                path.append(cur);
                helper(num,target,i+1,calc-cur,-cur,path);
                path.setLength(l);

                path.append("*");
                path.append(cur);
                helper(num,target,i+1,calc-tail+tail*cur,tail*cur,path);
                path.setLength(l);
            }
        }
    }
}