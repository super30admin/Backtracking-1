import java.util.ArrayList;
import java.util.List;
// Time Complexity: o(n* 2 ^ (n))
// Space Complexity: o(n* 2 ^ (n))
public class problem2 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result= new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;


    }
    private void helper(int[] nums, int i,  List<Integer>  path)
    {
        if(i==nums.length)
        {
            result.add(path);
            return;
        }
        // logic
        //no choose
        helper(nums, i+1, new ArrayList<>(path)); //deep copy

        path.add(nums[i]);

        // choose
        helper(nums, i+1, new ArrayList<>(path));
    }
}
