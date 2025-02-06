import java.util.ArrayList;
import java.util.List;

class Solution1 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return result;

    }

    private void dfs(int[] candidates, int target, int index, List<Integer> path) {
        // base
        if (index >= candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        dfs(candidates, target, index + 1, path);
        path.add(candidates[index]);
        dfs(candidates, target - candidates[index], index, path);
        path.remove(path.size() - 1);
    }
}

class Solution2 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return result;

    }

    private void dfs(int[] candidates, int target, int index, List<Integer> path) {
        // base
        if (target < 0 || index >= candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}