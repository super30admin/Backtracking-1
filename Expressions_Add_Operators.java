/*
 * TC: O(4^n) where n: length of String num
 * SC: O(n)  space for recursive stack which can be in worst case the depth of the tree i.e length of num.
 * Approach: Implement it using for loop based recursion. at each iteration i would have 2 choice either to do nothing or do add the 3 operators to the operands. Base case would be when my idx becomes equal to the length of String num.
 */

class Solution {
    private List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(0, "", 0, 0, num, target);
        return result;
    }

    private void helper(int idx, String path, long resSoFar, long prevNum, String s, int target){
        //base
        if(idx == s.length()){
            if(resSoFar == target) result.add(path);
            return;
        }

        for(int i = idx; i < s.length(); i++){
            //skip leading zeros
            if(i > idx && s.charAt(idx) == '0') break;

            long currNum = Long.parseLong(s.substring(idx, i+1));

            if(idx == 0){
                helper(i+1, path + currNum, currNum, currNum, s, target);
            }else{
                helper(i+1, path + "+" +currNum, resSoFar + currNum, currNum, s, target);
                helper(i+1, path + "-" +currNum,resSoFar - currNum, -currNum, s, target);
                helper(i+1, path + "*" +currNum, resSoFar - prevNum + (prevNum * currNum),prevNum * currNum, s, target);
            }
        }

    }
}