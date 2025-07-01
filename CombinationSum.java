import java.util.ArrayList;

public class CombinationSum {

    int [] nums = {2,3,6,7};
    int target = 7;
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        cs.getCombinationSum(cs.nums, 0, 7, new ArrayList<>());
        System.out.println(cs.result);
    }

    public void getCombinationSum(int [] nums, int idx, int target, ArrayList<Integer> path) {
        helper(nums, idx, target, path);
    }

    public void helper(int [] nums, int idx, int target, ArrayList<Integer> path) {

        // base condition
        if (target == 0) {
            result.add(path);
            return;            
        }

        if (target < 0) {
            return;
        }

        if (idx == nums.length) {
            return;
        }

        // choose
        ArrayList<Integer> li = new ArrayList<Integer>(path);
        li.add(nums[idx]);
        helper(nums, idx, target-nums[idx], new ArrayList<>(li)); 

        // logic
        // no-choose
        helper(nums, idx+1, target, new ArrayList<>(path));

        
    }
    
}
