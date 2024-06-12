/*
Without backtracking
TC: O(3^N)
SC : O(3^N)
*/

class Solution {
   List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, target, "");
        return result;
    }
    private void helper(String num, long calc, long tail, int pivot, int target, String path){
        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(path);
            }
        }
        //logic
        for(int i=pivot; i<num.length(); i++){
            if(num.charAt(pivot) == '0' && pivot!=i) continue;
            Long curr = Long.parseLong(num.substring(pivot, i+1));
            //combinations
            if(pivot == 0){
                helper(num, curr, curr, i+1, target, path + curr);
            }else{
                //+
                helper(num, calc + curr, curr, i+1, target, path + '+' +     curr);
                //-
                helper(num, calc-curr, -curr, i+1, target, path + '-' + curr);
                //*
                helper(num, calc - tail + tail*curr, tail*curr, i+1, target, path + '*' + curr);

            }

        }
    }
}




/*
Backtracking using stringbuilder
TC : O(3^N)
SC: max height of the tree : O(N)
*/
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, target, new StringBuilder());
        return result;
    }
    private void helper(String num, long calc, long tail, int pivot, int target, StringBuilder path){
        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(path.toString());
            }
        }
        //logic
        for(int i=pivot; i<num.length(); i++){
            if(num.charAt(pivot) == '0' && pivot!=i) continue;
            Long curr = Long.parseLong(num.substring(pivot, i+1));
            int le = path.length();
            //combinations
            if(pivot == 0){
                path.append(curr);
                helper(num, curr, curr, i+1, target, path);
                path.setLength(le);
            }else{
                //+
                path.append('+');
                path.append(curr);
                helper(num, calc + curr, curr, i+1, target, path);
                path.setLength(le);
                //-
                path.append('-');
                path.append(curr);
                helper(num, calc-curr, -curr, i+1, target, path);
                path.setLength(le);
                //*
                path.append('*');
                path.append(curr);
                helper(num, calc - tail + tail*curr, tail*curr, i+1, target, path);
                path.setLength(le);
            }

        }
    }
}
