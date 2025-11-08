// Time Complexity : O(4^(n)) .
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : Used for loop recursion to solve this problem. First we need to achieve all possible combination of numbers and at each combination
// we have to calculate +,-,* for the combinations. We maintain a curr and tail values as we need higher precedence operator in * case
// by using the previous value. After exploring the path, we backtracking it and set the path length to previous step one.


class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void helper(String num, int target, StringBuilder path, int pivot, long calc, long tail){
        if(pivot == num.length()){ //base case
            if(calc == target){
                result.add(path.toString());
            }
        }

        for(int i = pivot; i < num.length(); i++){

            if(num.charAt(pivot) == '0' && i != pivot) continue; // 0 precedence case

            long curr = Long.parseLong(num.substring(pivot, i+1));

            int le = path.length();

            if(pivot == 0){//at 0th level we dont have to perform operations
                path.append(curr);
                helper(num, target,path, i+1, curr, curr);
                path.setLength(le);//backtrack

            }else{

                // + case
                path.append("+").append(curr);
                helper(num, target, path, i+1, calc + curr, curr);
                path.setLength(le);//backtrack

                // - case
                path.append("-").append(curr);
                helper(num, target, path, i+1, calc - curr, -curr);
                path.setLength(le);//backtrack

                // * case
                path.append("*").append(curr);
                helper(num, target, path, i+1, calc - tail + (tail * curr), tail * curr);
                path.setLength(le);//backtrack
            }
        }
    }

}