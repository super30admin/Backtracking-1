import java.util.ArrayList;
import java.util.List;

// Time Complexity: 2 ^ (m+n)
// Space Complexity: o(n) + o(m+n)

public class problem1 {
List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.res=new ArrayList<>();
        helper(candidates,target, 0, new ArrayList<>());
        return res;
    }
    public void helper(int[] candidates,int target, int i, List<Integer> path) {

        //base case
        if (target == 0) {
            res.add(path);
            return;
        }
        if (i == candidates.length || target<0) {
            return;
        }

        //logic


        //dont choose
        helper(candidates,target,i+1,new ArrayList<>(path));

        //choose
        path.add(candidates[i]);
        helper(candidates,target-candidates[i],i,new ArrayList<>(path));

    }
}
