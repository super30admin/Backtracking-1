import java.util.ArrayList;
import java.util.List;

class ExpressionAndOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) return new ArrayList<>();
        result = new ArrayList<>();
        recurse(num, target, 0, 0, 0, "");
        return result;
    }
    private void recurse(String num, int target, int index, long calc, long tail, String path) {
        if(index == num.length()) {
            if(calc == target) {
                result.add(path);
            }
        }

        for(int i=index; i<num.length(); i++) {
            if(num.charAt(index) == '0' && index != i) {
                continue;
            }

            Long curr = Long.parseLong(num.substring(index, i+1));

            if(index == 0) {
                recurse(num, target, i+1, curr, curr, path + curr);
                continue;
            }

            recurse(num, target, i+1, calc + curr, +curr, path + "+" + curr);
            recurse(num, target, i+1, calc - curr, -curr, path + "-" + curr);
            recurse(num, target, i+1, calc - tail + tail * curr, tail*curr, path + "*" + curr);

        }
    }
}
