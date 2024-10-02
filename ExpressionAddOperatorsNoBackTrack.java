// Time complexity = O(4^l), where l is the length of the num string.
// Space complexity = O(4^l), where l is the length of the num string.
// What we did -
// eg - [1,2,3,4]
// we start with the simple idea that we can produce strings such as 1, 12, 123, 1234.
// what's the pivot - it is 0 (initially.)
// So then just call the same function, helper function .
// if there is second then it will be attached either via a string builder 
// or a appending a string(creating a new string.)

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, 0, "", 0l, 0l, target, res);
        return res;
    }
    
    private void helper(String num, int pivot, String path, long calc, long tail, int target, 
                        List<String> res) {
        if(pivot == num.length()) {
            if(calc == target) {
                res.add(path);
            }
            return;
        }
        
        for(int i=pivot;i< num.length();i++) {
            long curr = Long.parseLong(num.substring(pivot, i+1));
            if(num.charAt(pivot)=='0' && i!=pivot) {
                continue;
            }
            // helper is called from index+1. to mark it as start from the next index. we have already put the earlier string in path.
            // the reason we do not need a new String, since when we concat the strings, we get a new string.
            if(pivot==0) {
                // when pivot is 0, no need to append the strings.
                helper(num, i+1, path+ curr, curr, curr,target, res);
            } else {
                // pivot is not 0. 
                // so it is the second string . you need to append.
                // add
                helper(num, i+1, path+ '+' + curr, calc+curr, curr, target, res);
                // subtract
                helper(num, i+1, path+ '-' + curr, calc-curr, -curr, target, res);
                // multiply. to undo the mistake -> calc- tail + tail* curr
                helper(num, i+1, path+ '*' + curr, calc-tail + tail*curr, tail*curr, target, res);
            }
        }
        
    }
}