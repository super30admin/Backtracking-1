// This approach uses generating all the required combinations which appends the operators while going to the next character. 
// At the same time, if there is a product operator, we have to make sure to revert the previous operation and do the operation on that and re add it to the remaining sum to make sure of BODMAS rule
// There is a corner case to handle leading 0 and just not proceed the combination
class Solution {
    List<String> response = new ArrayList();
    public List<String> addOperators(String num, int target) {
        add(num, 0, 0, new StringBuilder(""), target, 0);
        return response;
    }

    private void add(String num, int pivot, double carry, StringBuilder operator, int target, double sum) {
        // base case
        if(pivot==num.length()) {
            if((int)sum==target) {
                response.add(operator.toString());
                return;
            }
        }

        // iterate over the string
        String sub = "";
        double subCarry = 0;
        for(int i=pivot;i<num.length();i++) {
            if(num.charAt(pivot) == '0' && i!=pivot) {
                break;
            }
            int len = operator.length();
            sub=sub.concat(String.valueOf(num.charAt(i)));
            subCarry = subCarry * 10 + (num.charAt(i)-'0');
            
            //base case for pivot=0
            if(pivot==0) {
                add(num, i+1, subCarry, operator.append(sub), target, subCarry);
                operator.setLength(len);
                continue;
            }

            // +
            add(num, i+1, subCarry, operator.append("+"+sub), target, sum+subCarry);
            operator.setLength(len);

            // - 
            add(num, i+1, -subCarry, operator.append("-"+sub), target, sum-subCarry);
            operator.setLength(len);

            // *
            add(num, i+1, carry * subCarry, operator.append("*"+sub), target, sum - carry + (carry * subCarry));
            operator.setLength(len);
        }
    }
}
