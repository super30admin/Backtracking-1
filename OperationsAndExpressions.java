class OperationsAndExpressions {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0){
            return new ArrayList<>();
        }

        recurse(num, target, 0, 0, 0, "");
        return result;
    }

    private void recurse(String num, int target, int index, long cal, long tail, String val){
        //base
        if(index == num.length()){
            if(target == cal){
                result.add(val);
            }
            return;
        }

        //logic
        for(int i=index; i<num.length(); i++){
            long curr = Long.parseLong(num.substring(index, i+1));
            if(num.charAt(index) == '0' && i>index){
                continue;
            }

            if(index == 0){
                recurse(num, target, i+1, curr, curr, val + curr);
            } else {
                //+ case
                recurse(num, target, i+1, cal + curr, +curr, val + "+" + curr);
                //- case
                recurse(num, target, i+1, cal - curr, -curr, val + "-" + curr);
                //* case
                recurse(num, target, i+1, cal - tail + tail * curr, tail * curr, val + "*" + curr);
            }
        }
    }
}
