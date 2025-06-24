// Problem2
// Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//4 operations => no operation when pivot==i, +, -, *
//used for loop based recursion to find every possible pair of opparands and used backtracking to save space 
//and not create new string every time.



// with string concatination, no need of backtracking
// class Solution {
//     List<String> result;
//     public List<String> addOperators(String num, int target) {
//         this.result = new ArrayList<>();
//         helper(num, 0, target, "", 0, 0);
//         return result;
//     }
//     private void helper(String num, int pivot,  int target, String path, long caalculatedValue, long tail){
//         //base
//         if(pivot==num.length()) {
//             if(caalculatedValue==target) result.add(path);
//             return;
//         }
//         if(pivot==num.length()) return;
//         //logic
//         for(int i=pivot;i<num.length(); i++){
//             // preceeding zero
//             if(num.charAt(pivot)=='0'&&pivot!=i)continue;
//             long currentNumber = Long.parseLong(num.substring(pivot,i+1));

//             if(pivot==0){
//                 helper(num, i+1, target, path+currentNumber, currentNumber, currentNumber);
//             }else{
//                 // +
//                 helper(num, i+1, target, path+"+"+currentNumber, currentNumber+caalculatedValue, currentNumber);
//                 // - 
//                 helper(num, i+1, target, path+"-"+currentNumber, caalculatedValue-currentNumber, -currentNumber);
//                 // *
//                 helper(num, i+1, target, path+"*"+currentNumber, caalculatedValue-tail + tail*currentNumber, tail*currentNumber);
//             }
//         }
//     }
// }

//backtracking with String builder
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, 0, target, new StringBuilder(), 0, 0);
        return result;
    }
    private void helper(String num, int pivot,  int target, StringBuilder path, long caalculatedValue, long tail){
        //base
        if(pivot==num.length()) {
            if(caalculatedValue==target) result.add(path.toString());
            return;
        }
        if(pivot==num.length()) return;
        //logic
        for(int i=pivot;i<num.length(); i++){
            // preceeding zero
            if(num.charAt(pivot)=='0'&&pivot!=i)continue;
            int lenP=path.length();
            long currentNumber = Long.parseLong(num.substring(pivot,i+1));
            if(pivot==0){
                //action
                path.append(currentNumber);
                //recurse
                helper(num, i+1, target, path, currentNumber, currentNumber);
                //backtrack
                path.setLength(lenP);
            }else{
                // +
                //action
                path.append("+");
                path.append(currentNumber);
                //recurse
                helper(num, i+1, target, path, currentNumber+caalculatedValue, currentNumber);
                //backtrack
                path.setLength(lenP);
                // - 
                //action
                path.append("-");
                path.append(currentNumber);
                //recurse
                helper(num, i+1, target, path, caalculatedValue-currentNumber, -currentNumber);
                //backtrack
                path.setLength(lenP);
                // *
                //action
                path.append("*");
                path.append(currentNumber);
                //recurse
                helper(num, i+1, target,path, caalculatedValue-tail + tail*currentNumber, tail*currentNumber);
                //backtrack
                path.setLength(lenP);
            }
        }
    }
}