//Time Complexity - exponential  - O(2^n)
//Space complexity - recursive stack space - O(n) - where n is the length of the string 
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(num,target,0,0,0, "");
        return result;
        
    }
    private void recurse(String num, int target, int index, long calc , long tail, String path){
        //base
        if(index == num.length()){
            if(calc == target){
                result.add(path);
            }
        }

        //logic
        for(int i = index; i < num.length(); i++){
            long curr = Long.parseLong(num.substring(index,i+1));
            if(num.charAt(index) == 0 && i != index){
                continue;
            }
            if(index == 0){
                recurse(num,target,i + 1, curr, curr, path + curr);
            }
            else{
                //+ operator
                recurse(num,target,i+1, curr + calc , +curr, path + "+" + curr);
                //- operator
                recurse(num,target,i+1, calc - curr, -curr, path + "-" + curr);
                //* operator
                recurse(num, target, i + 1, calc - tail + tail * curr , tail * curr, path + "*" + curr);
            }

        }

    }
}
