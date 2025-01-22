//282. Expressions and Operators - https://leetcode.com/problems/expression-add-operators/description/
//Time Complexity: O(4^n) ~ 4 is no. of operations[+,-,*, no operation], n: length of the string
//Space Complexity: O(n) ~ Recursive calls

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this. result = new ArrayList<>();
        helper(num, 0, 0, 0, "", target);
        return result;
    }

    private void helper(String num, int pivot, long calc, long tail, String path, int target){
        //base case
        if(pivot == num.length()){
            if(calc == target){
                result.add(path);
            }
        }

        //logic
        for(int i=pivot; i<num.length(); i++){
            //e.g., if num=105, target=6
            //output: ["1*0+5","1*5","10-5"]
            //expected: ["1*0+5","10-5"]
            if(num.charAt(pivot) == '0' && i != pivot){
                continue;
            }
            long currNum = Long.parseLong(num.substring(pivot, i+1));
            if(pivot == 0){
                helper(num, i+1, currNum, currNum, path + currNum, target);
            } else { //is operator
                //+ operator
                helper(num, i+1, calc+currNum, currNum, path+"+"+currNum, target);
                //- operator
                helper(num, i+1, calc-currNum, -currNum, path+"-"+currNum, target);
                //* (-tail: similar to backtracking)
                helper(num, i+1, (calc-tail)+(tail*currNum), tail*currNum, path+"*"+currNum, target);
            }
        }
    }
}