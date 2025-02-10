public class Problem2 {


    class Recurse {
        List<String> result;
        public List<String> addOperators(String num, int target) {
            if(num == null || num.length()==0){
                return new ArrayList<>();
            }
            result = new ArrayList<>();
            recurse(num,target,0,0,0,"");
            return result;
        }
        private void recurse(String num, int target, int index, long calc, long tail, String path){
            //base
            if(index == num.length()){
                if(calc ==target){
                    result.add(path);
                }
                return;
            }

            //logic
            for(int i = index;i<num.length();i++){
                //to prevent the leading 0 , so single digit containing 0 is allowed but more than 1 is not allowed example '01'.
                if(num.charAt(index)=='0' && index != i){
                    continue;
                }
                //starting from each index get each substring.
                //Example "123" -> index = 0 -> Substrings == "1","12","123".
                long curr = Long.parseLong(num.substring(index,i+1));
                //if we are at index 0 the calculated values and tail would be whatever we've at 0 index and as path is empty we'll add the first element in it
                if(index==0){
                    recurse(num,target,i+1,curr,curr,path+curr);
                }
                else{
                    //if the index is not 0 then there are 3 conditions we need to take care of

                    // + op
                    recurse(num,target,i+1,calc + curr, + curr , path+ "+" + curr);

                    // - op
                    recurse(num,target,i+1,calc - curr, - curr, path+ "-" + curr);

                    // * op
                    recurse(num,target,i+1,calc - tail + tail * curr , tail * curr , path+ "*" + curr);
                }
            }

        }
    }



    class backtrack {
        List<String> result;
        public List<String> addOperators(String num, int target) {
            if(num == null || num.length()==0){
                return new ArrayList<>();
            }
            result = new ArrayList<>();
            recurse(num,target,0,0,0,new StringBuilder(""));
            return result;
        }
        private void recurse(String num, int target, int index, long calc, long tail, StringBuilder path){
            //base
            if(index == num.length()){
                if(calc ==target){
                    result.add(new String(path.toString()));
                }
                return;
            }

            //logic
            for(int i = index;i<num.length();i++){
                //to prevent the leading 0 , so single digit containing 0 is allowed but more than 1 is not allowed example '01'.
                if(num.charAt(index)=='0' && index != i){
                    continue;
                }
                //starting from each index get each substring.
                //Example "123" -> index = 0 -> Substrings == "1","12","123".
                long curr = Long.parseLong(num.substring(index,i+1));
                //if we are at index 0 the calculated values and tail would be whatever we've at 0 index and as path is empty we'll add the first element in it

                int len = path.length();
                if(index==0){
                    recurse(num,target,i+1,curr,curr,path.append(curr));
                    path.setLength(len);
                }
                else{
                    //if the index is not 0 then there are 3 conditions we need to take care of

                    // + op
                    recurse(num,target,i+1,calc + curr, + curr , path.append("+").append(curr));
                    path.setLength(len);

                    // - op
                    recurse(num,target,i+1,calc - curr, - curr, path.append("-").append(curr));
                    path.setLength(len);

                    // * op
                    recurse(num,target,i+1,calc - tail + tail * curr , tail * curr , path.append("*").append(curr));
                    path.setLength(len);
                }
            }
        }
    }
}
