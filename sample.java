class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), result);
        return result;

    }

    private void helper(int index, int[] candidates, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }
        curr.add(candidates[index]);
        helper(index, candidates, target - candidates[index], curr, result);
        curr.remove(curr.size() - 1);
        helper(index + 1, candidates, target, curr, result);
    }
}

////////////////////////////////////
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void backtrack(String num, int target, int index, long prev, long curr, String path, List<String> result) {
        if (index == num.length()) {
            if (curr == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Skip leading zeros
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            long currentNum = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                // First number, no operator needed
                backtrack(num, target, i + 1, currentNum, currentNum, path + currentNum, result);
            } else {
                // Add '+'
                backtrack(num, target, i + 1, currentNum, curr + currentNum, path + "+" + currentNum, result);

                // Add '-'
                backtrack(num, target, i + 1, -currentNum, curr - currentNum, path + "-" + currentNum, result);

                // Add '*'
                backtrack(num, target, i + 1, prev * currentNum, curr - prev + prev * currentNum,
                        path + "*" + currentNum, result);
            }
        }
    }
}
