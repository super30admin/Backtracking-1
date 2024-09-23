import java.util.ArrayList;
import java.util.List;
class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0 || candidates==null)
        {
            return new ArrayList<>();
        }
        result= new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[]candidates, int target, int index, List<Integer>path)
    {
        //base
        if(target<0 || index== candidates.length)
        return;

        if(target==0)
        {
            result.add(new ArrayList<>(path)); // we keep on modifying the path so thats why we created new Arraylist created
            return;
        }

        //recurse
        //0 or not pick case
        backtrack(candidates, target,index+1, path);
        // 1 or pick case
        path.add(candidates[index]);
        backtrack(candidates, target-candidates[index],index, path);
        // backtrack
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        CombinationSum c= new CombinationSum();
        int[]candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans=c.combinationSum(candidates, target);
        System.err.println(ans);
        
    }

}