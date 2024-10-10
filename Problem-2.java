// Time Complexity : exponential
// Space Complexity : recursive stack can upto lenght of the string , O(n) + O(n) is the path string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num,res, new StringBuilder(),0,0l,0l,target);
        return res;
    }

    private void helper(String num, List<String> res, StringBuilder path, int pivot, long calc, long tail, int target){
        //base
        if(pivot == num.length()){
            if(calc == target){
                res.add(path.toString());
            }
            return;
        }

        //logic
        for(int i = pivot; i < num.length(); i ++){
            long cur = Long.parseLong(num.substring(pivot, i + 1));
            //
            if(num.charAt(pivot) == '0' && i!= pivot) continue;
            int le = path.length();
            if(pivot == 0){
                //action
                path.append(cur);
                helper(num, res, path,i+1,cur,cur,target);
                //backtrack
                path.setLength(le);
            }else{
                //+
                //action
                path.append("+").append(cur);
                helper(num, res, path,i+1,calc + cur,cur,target);
                //backtrack
                path.setLength(le);
                //-
                //action
                path.append("-").append(cur);
                helper(num, res, path,i+1,calc - cur,-cur,target);
                //backtrack
                path.setLength(le);
                //*
                //action
                path.append("*").append(cur);
                helper(num, res, path,i+1,calc -tail + tail * cur,cur*tail,target);
                //backtrack
                path.setLength(le);
            }
        }
    }
}