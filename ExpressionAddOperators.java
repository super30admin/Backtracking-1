//The idea here is to explore all possibilites in the given string and using all the operators to see which gives the result
//To achieve this, we perform for-loop based recursion where each substring goes from pivot to the index
//To calculate the value, we convert each substring to long and perform calculations at each node
//To manage multiplication within the rules of BODMAS at each calculation, we keep track of the current calculation and the latest value so that they are performed individually
//We also make use of backtracking to avoid creating duplicate paths at each node
//Time Complexity: (O(4^n)) where n is the length of the string
//Space Complexity: O(n^2)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        helper(num, 0, path, 0l, 0l, target, result);
        return result;
    }

    private void helper(String num, int pivot, StringBuilder path, long calc, long tail, int target, List<String> result){
        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(path.toString()); //here path is converted to string each time.
            }
        }
        //logic
        for(int i = pivot; i<num.length(); i++){
            //preceding case
            if(i != pivot && num.charAt(pivot) == '0') continue; //we are addressing preceding case by considering it when it is as a single digit.
            long curr = Long.parseLong(num.substring(pivot, i+1)); //preceding case error here because "05" when parsed, becomes 5
            int le = path.length();
            if(pivot == 0){
                //action
                path.append(curr);
                //recurse
                helper(num, i+1, path, curr, curr, target, result); //curr+path adds path to the curr String and gives a new string
                //backtrack
                path.setLength(le); 
            } else { //curr+path gives reverse order of the string
                //+
                //action
                path.append("+");
                path.append(curr);
                helper(num, i+1, path, calc+curr, curr, target, result);
                //backtrack
                path.setLength(le);

                //-
                path.append("-");
                path.append(curr);
                helper(num, i+1, path, calc-curr, -curr, target, result);
                //backtrack
                path.setLength(le);

                //*
                path.append("*");
                path.append(curr);
                helper(num, i+1, path, calc-tail + tail * curr, tail * curr, target, result);
                //backtrack
                path.setLength(le);
            }
        }
    }
}