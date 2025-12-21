// Time Complexity : O(4^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// 1. Use DFS/backtracking to try all ways of inserting '+', '-', and '*' between digits.
// 2. Track the current calculation (cal) and last operand (tail) to correctly handle multiplication precedence.
// 3. Skip numbers with leading zeros and add the expression to the result when the end is reached and cal == target.

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, target, 0, 0, new StringBuilder(), 0);
        return result;
    }

    public void helper(String num, int target, long cal, long tail, StringBuilder path, int pivot){
        if(pivot == num.length()){
            if (cal == target){
                result.add(path.toString());
                return;
            }
        }
        Long curr;

        for (int i = pivot; i < num.length(); i++){
            if (num.charAt(pivot) == '0' && pivot != i){
                break;
            }
            
            curr = Long.parseLong(num.substring(pivot,i+1));
            int le = path.length();

            if (pivot == 0){
                path.append(curr);
                helper(num,target,curr,curr,path,i+1);
                path.setLength(le);
            }
            else{
                path.append("+").append(curr);
                helper(num,target,cal+curr,curr, path,i+1 );
                path.setLength(le);
                path.append("-").append(curr);
                helper(num,target,cal-curr,-curr, path,i+1 );
                path.setLength(le);
                path.append("*").append(curr);
                helper(num,target,cal-tail+tail*curr,tail*curr, path,i+1 );
                path.setLength(le);

            }
        }
    }
}