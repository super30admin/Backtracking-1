class Solution {

    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;

    }

    private void helper(String num, int target, StringBuilder sb, long calc, long tail, int index){

        // base 
        if(index == num.length()){
            if(calc == target){
                result.add(sb.toString());
                return;

            }

        }

        // logic

       for(int i = index; i < num.length(); i++){

           // preceding zero case

           if(index != i && num.charAt(index) == '0') break;
           long curr = Long.parseLong(num.substring(index, i + 1)); // 1*5
           int len = sb.toString().length();
           if(index == 0){
               sb.append(curr); //action
               helper(num, target, sb ,curr, curr, i + 1); // recurse
               sb.setLength(len); // backtrack

           } else {

               sb.append("+");//action
               sb.append(curr);//action
               helper(num, target, sb, calc + curr, curr, i + 1); // recurse
               sb.setLength(len);// backtrack

               

               sb.append("-");//action
               sb.append(curr);//action
               helper(num, target, sb, calc - curr, -curr, i + 1); // // recurse
               sb.setLength(len);// backtrack
               
               sb.append("*");
               sb.append(curr);
               helper(num, target, sb, calc - tail + tail*curr, tail*curr, i + 1); // recurse
               sb.setLength(len);// backtrack

           }

       }

    }

}

//TC : Exponential 4 power n
// Sc : Exponential
