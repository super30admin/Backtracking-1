// Approach : Recursion
// Time : 4^N // N - being the length of the num
// Space : O(N) // recursive stack space
class Solution {
    List<String> result;
    int targ;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        this.targ = target;
        helper(num,"",0,0,0);
        return result;
    }
    public void helper(String num , String path, long cal,long tail,int pivot){
        // base case
        if(pivot == num.length()){
            if(cal == targ){
                result.add(path);
                return;
            } 
        }

        // logic - "1234"
        for(int i = pivot;i<num.length();i++){
            // edge case with preceeding zero - stop eliminating
            if(num.charAt(pivot) == '0' && i!=pivot) continue; // "05"
            long curr = Long.parseLong(num.substring(pivot,i+1)); // "1","05"
            // At the root
            if(pivot == 0){
                helper(num,path + curr,curr,curr,i+1);
            } else{
                // case 1 : "+"
                helper(num,path + "+" + curr,cal + curr, curr, i+1);
                // case 2 : "-"
                helper(num,path + "-" + curr,cal - curr, -curr, i+1);
                // case 3 : "*"
                helper(num,path + "*" + curr,cal - tail + tail * curr, tail*curr, i+1);
            }
        }
    }
}