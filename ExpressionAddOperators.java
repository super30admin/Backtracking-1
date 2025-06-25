class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() ==0)
            return res;
        StringBuilder path = new StringBuilder();
        backTrack(num, target, path, res,0,0,0);
        return res;
    }

    private void backTrack(String num, int target, StringBuilder path, List<String> res, int index, long eval, long prevOperand){
        if(index == num.length()){
            if(eval == target){
                res.add(path.toString());
            }
                return;
        }
        for(int i=index; i< num.length(); i++){
            if(i!=index && num.charAt(index) == '0')
                break;
            String currStr = num.substring(index, i+1);
            long currNum = Long.parseLong(currStr);
            int lenBeforeAppend = path.length();
        
        if(index == 0){
            path.append(currStr);
            backTrack(num, target, path, res, i+1, currNum, currNum);
            path.setLength(lenBeforeAppend);
        }
        else{
            path.append('+').append(currStr);
            backTrack(num, target, path, res, i+1, eval + currNum, currNum);
            path.setLength(lenBeforeAppend);

            path.append('-').append(currStr);
            backTrack(num, target, path, res, i+1, eval - currNum, -currNum);
            path.setLength(lenBeforeAppend);

             path.append('*').append(currStr);
            backTrack(num, target, path, res, i+1, eval - prevOperand + (prevOperand * currNum),
                          prevOperand * currNum);
            path.setLength(lenBeforeAppend);
            }
        }
        
    }
}
