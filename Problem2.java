//for loop based recursion
// TC: O(4^N)
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
    }
    public void helper(String num, int target, int index, long currsum, long tail, String path){
        if(index == num.length()){
            if(currsum == target) result.add(path);
            return;
        }

        for(int i = index; i < num.length(); i++){
            if(index != i && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if(index == 0){
                helper(num, target, i + 1, curr, curr, path + curr);
            }
            else{
                helper(num, target, i + 1, currsum + curr, +curr, path + "+" + curr);
                helper(num, target, i + 1, currsum - curr, -curr, path + "-" + curr);
                helper(num, target, i + 1, currsum - tail + (curr * tail), curr * tail, path + "*" + curr);
            }
        }
        
    }
}
