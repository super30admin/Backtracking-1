/* Time Complexity : O(4^n) 
 *  4 - possible operations(+, - , * , None)
 *  n - len of i/p string - num */
/* Space Complexity : O(n) 
 * 	n - height of the recursive stack */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder path){
        //base condition
        if(pivot == num.length()){
            if(target == calc){
                result.add(path.toString());
                return;
            }
        }
        //logic
        int len = path.length();
        for(int i = pivot; i < num.length(); i++){
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            long curr = Long.parseLong(num.substring(pivot, i+1));
            if(pivot == 0){
                //action
                path.append(curr);
                //recurse
                helper(num, target, i+1, curr, curr, path);
                //backtrack
                path.setLength(len);
            } else {
                //action
                path.append('+').append(curr);
                //recurse
                helper(num, target, i+1, calc + curr, curr, path);
                //backtrack
                path.setLength(len);

                //action
                path.append('-').append(curr);
                //recurse
                helper(num, target, i+1, calc - curr, -curr, path);
                //backtrack
                path.setLength(len);

                //action
                path.append('*').append(curr);
                //recurse
                helper(num, target, i+1, calc - tail + tail * curr, tail * curr, path);
                //backtrack
                path.setLength(len);
            }
        }
    }
}