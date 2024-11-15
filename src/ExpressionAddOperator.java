// Recursive Solution
class ExpressionAddOperator {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num,target,0,"",0l,0l,result);
        return result;
    }

    private void helper(String num, int target, int pivot,String path, long calc, long tail,List<String> result) {
        //base case
        if(pivot == num.length()) {
            if(calc == target) {
                result.add(path);
            } 
            return;
        }
        //logic

        for(int i = pivot; i < num.length(); i++) {
            if (i != pivot && num.charAt(pivot) == '0') {
                break;
            }
            long curr = Long.parseLong(num.substring(pivot,i+1));

            if(pivot == 0) {
                helper(num, target, i+1, path + curr, curr, curr, result);
            } else {
                helper(num, target, i+1, path + '+' + curr, calc + curr, curr, result);
            helper(num, target, i+1, path + '-' + curr, calc - curr, -curr, result);
            helper(num, target, i+1, path + '*' + curr, calc - tail + tail*curr, tail*curr, result);
            }
        }
    }
}

// Backtracking Solution
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num,target,0,new StringBuilder(),0l,0l,result);
        return result;
    }

    private void helper(String num, int target, int pivot,StringBuilder path, long calc, long tail,List<String> result) {
        //base case
        if(pivot == num.length()) {
            if(calc == target) {
                result.add(path.toString());
            } 
            return;
        }
        //logic

        for(int i = pivot; i < num.length(); i++) {
            if (i != pivot && num.charAt(pivot) == '0') {
                break;
            }
            int le = path.length();
            long curr = Long.parseLong(num.substring(pivot,i+1));

            if(pivot == 0) {
                path.append(curr);
                helper(num, target, i+1, path, curr, curr, result);
                path.setLength(le);
            } else {
                path.append("+");
                path.append(curr);
                helper(num, target, i+1, path, calc + curr, curr, result);
                path.setLength(le);

                path.append("-");
                path.append(curr);
            helper(num, target, i+1, path, calc - curr, -curr, result);
            path.setLength(le);

            path.append("*");
            path.append(curr);
            helper(num, target, i+1, path, calc - tail + tail*curr, tail*curr, result);
             path.setLength(le);

            }
        }
    }
}