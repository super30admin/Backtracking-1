/**
 * Time Complexity - O(4^n * n)
 * Space Complexity - O(4^n * n)
 */

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, "", 0, 0, 0);
        return result;

    }

    private void backtrack(List<String> result, String num, int target, String path, int position, long evaluation, long mul) {
        if(position == num.length()) {
            if(evaluation == target) {
                result.add(path);
            }
            return;
        }

        for(int i = position; i < num.length(); i++) {
            if(i != position && num.charAt(position) == '0')
                break;

            long current = Long.parseLong(num.substring(position, i + 1));

            if(position == 0) {
                backtrack(result, num, target, path + current, i + 1, current, current);
            }
            else {
                backtrack(result, num, target, path +"+"+current, i+1, evaluation + current, current);
                backtrack(result, num, target, path +"-"+ current, i+1, evaluation - current, -current);
                backtrack(result, num, target, path +"*"+current, i+1, evaluation - mul + mul * current, current * mul);
            }
        }
    }
}