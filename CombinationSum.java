class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        recurse(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int target, int index, List<Integer> path){
        if(target < 0 || candidates.length == index){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        recurse(candidates, target, index + 1, path);
        path.add(candidates[index]);
        recurse(candidates, target - candidates[index], index, path);

        path.remove(path.size() - 1);
    }


}
