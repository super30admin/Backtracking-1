// This solution uses a recursive way to generate all the combinations. 
// While generating the combinations, we either choose to select an element or do not choose. 
// If we select an element we recurse through next stage by decrementing the target by that selected number 
// and if we do not we just move to next element with same target. 
// At the end, if target reaches zero, that means we found our combination.
class Solution {
    List<List<Integer>> combinationSums = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getCombinations(candidates, target, 0, new ArrayList());
        return combinationSums;
    }

    private void getCombinations(int[] candidates, int target, int index, List<Integer> runningSumList) {
        if(index==candidates.length || target<0) return;
        if(target==0) {
            combinationSums.add(new ArrayList(runningSumList));
            return;
        }

        // for(int i=index;i<candidates.length;i++) {
        //     runningSumList.add(candidates[i]);
        //     getCombinations(candidates, target-candidates[i], i, runningSumList);
        //     runningSumList.remove(runningSumList.size()-1);
        // }

        getCombinations(candidates, target, index+1, runningSumList);
        runningSumList.add(candidates[index]);
        getCombinations(candidates, target-candidates[index], index, runningSumList);
        runningSumList.remove(runningSumList.size()-1);
    }
}

