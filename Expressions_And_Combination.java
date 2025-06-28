class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, "", 0, 0, target);
        return result;
    }

    public void helper(String num, int pivot, String path, long calc, long tail, int target){
        //base case 
        if(pivot == num.length()){
            if(calc == target){
                result.add(path);
            }
            return;
        }
        // logic 
        for(int i = pivot; i < num.length(); i++){
            if(num.charAt(pivot) == '0' && i > pivot) return;
            long curr = Long.parseLong(num.substring(pivot, i+1));
            if(pivot == 0){
                helper(num, i+1, path+curr, curr, curr, target);
            }else {
                //+
                helper(num, i+1, path + "+" + curr, calc + curr, curr, target);
                //-
                helper(num, i+1, path + "-" + curr, calc - curr, -curr, target);
                //*
                helper(num, i+1, path + "*" + curr, calc - tail + tail * curr, tail * curr, target);
            }
        }
    }
}
