import java.util.ArrayList;
import java.util.List;

class Problem1 {
    List<List<Integer>> result;
    int s;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        s= candidates.length;
        result = new ArrayList<>();
        helper(candidates,target,new ArrayList<>(),0);
        return result;
    }

    private void helper(int[] candidates, int target,List<Integer> path,int idx){
        //base
        if(target==0){
            result.add(path);
            return;
        }
        if(target<0 || idx >=s){
            return;
        }

        //actual

        //choose
        List<Integer> np = new ArrayList(path);
        np.add(candidates[idx]);
        helper(candidates,target-candidates[idx],np,idx);
        // path.remove(path.size()-1);

        //not choose
        helper(candidates,target,path,idx+1);



    }

}

//time complexity: O(N^(T/M +1)) where N is the number of candidates, T is the target, and M is the minimum value in candidates.
//space complexity: O(T/M) for the recursion stack and the path list.