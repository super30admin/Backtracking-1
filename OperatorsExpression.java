import java.util.List;

class Solution {
    List<String> result;
    int targt;

    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        this.targt = target;
        if(num == null || num.length() == 0) return result;
        helper(num, "", 0L, 0L,0);
        return result;
    }

    private void helper(String num, String path,  Long calc, Long tail,int pivot) {
        // base
        if (pivot == num.length()) {
            if (calc == targt){
                result.add(path);
            }
                return;
        }
        // logic
        for (int i = pivot; i < num.length(); i++) {
            if (num.charAt(pivot) == '0' && pivot != i)
                break;

            long curr = Long.parseLong(num.substring(pivot, i + 1));

            if (pivot == 0) {

                helper(num, path + curr, curr, curr, i + 1);

            } else {

                // +

                helper(num, path + "+" + curr, calc + curr, curr, i + 1);

                // -

                helper(num, path + "-" + curr, calc - curr, -curr, i + 1);

                // *

                helper(num, path + "*" + curr, calc - tail + tail * curr, tail * curr, i + 1);

            }

        }
    }
}