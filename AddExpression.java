//Time complexity:- O(4 ^ L) where L = length of num
//Space complexity:- O(L) recursion stack.
class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> result = new ArrayList<>();

        helper(num, target, 0, "", 0, 0, result);
        return result;
    }

    public void helper(String num, int target, int pivot, String path, long cal, long tail, List<String> result) {

        //Base condition
        //we scanned through all the chars. then check if cal value == target
        if(pivot == num.length()) {

                if(cal == target) {
                //we add the path to result
                    result.add(path.toString());
                    return;
            } 
        }

        //Logic :- for loop recursion :- 1 12 123
        for(int i = pivot; i < num.length(); i++) {

            //for cases:- 1 -> 05 (Long takes 05 as 5 hence 1*5)
            //so when pivot == 0 then avoid it only only when i=0. Hence we avoid 05, 078 etc
            //avoid preceeding 0's
            if(i != pivot && num.charAt(pivot) == '0')
                continue;
            
            //get the digits
            long curr = Long.parseLong(num.substring(pivot, i + 1));

            //if its first character then don't add any expression
            if(pivot == 0) {

                helper(num, target, i + 1, path + curr, curr, curr, result);
            }
            else {
                
                //Now we have 3 expression options
                //a: +
                helper(num, target, i + 1, path + "+" + curr, cal + curr, curr, result);
                //b: -
                helper(num, target, i + 1, path + "-" + curr, cal - curr, -curr, result);
                //c: * :- Here we need to take care of the BODMAS rules
                helper(num, target, i + 1, path + "*" + curr, cal - tail + tail * curr, tail * curr, result);
            }
        }

    }
}