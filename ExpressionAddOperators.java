/**
 Approach: For loop based recursion

 Time Complexity: 2^N (exponential)
 Space Complexity: O(n) -> (len(num))

 */

class ExpressionAddOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {

        if(num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(num, target, 0, 0, 0, "");

        return result;
    }

    private void recurse(String num, int target, int index, long cal, long tail, String path) {


        //base
        if(index == num.length()) {
            if(cal == target) {
                result.add(path);
            }
        }


        //logic
        for(int i=index; i<num.length(); i++){

            if(num.charAt(index) == '0' && index!=i) {
                continue;
            }

            long curr = Long.parseLong(num.substring(index, i+1));

            if(index == 0) {

                recurse(num, target, i+1, curr, curr, path+curr);
            }
            else{

                //+ addition
                recurse(num, target, i+1, cal+curr, +curr, path+"+"+curr);

                //- subraction
                recurse(num, target, i+1, cal-curr, -curr, path+"-"+curr);

                // * multiplication
                recurse(num, target, i+1, cal-tail + tail*curr, tail*curr, path+"*"+curr);
            }
        }
    }
}

