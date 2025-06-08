//Time Complexity: O(4^n)
//Space Complexity: O(n) for the recursive stack space
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }
    private void helper(String num, int target, StringBuilder sb, long calc, long tail, int index){
        if(index == num.length()){
            if(calc == target){
                result.add(sb.toString());
                return;
            }
        }
       for(int i = index; i < num.length(); i++){
        if(index != i && num.charAt(index) == '0') break;
        long curr = Long.parseLong(num.substring(index, i + 1));
        int len = sb.toString().length();
           if(index == 0){
               sb.append(curr);
               helper(num, target, sb ,curr, curr, i + 1);
               sb.setLength(len);
           } else {
               sb.append("+");
               sb.append(curr);
               helper(num, target, sb, calc + curr, curr, i + 1);
               sb.setLength(len);
               sb.append("-");
               sb.append(curr);
               helper(num, target, sb, calc - curr, -curr, i + 1);
               sb.setLength(len);
               sb.append("*");
               sb.append(curr);
               helper(num, target, sb, calc - tail + tail*curr, tail*curr, i + 1);
               sb.setLength(len);
           }
       }
    }
}