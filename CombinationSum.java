import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n)
// Space Complexity: O(n)

public class CombinationSum {
        List<List<Integer>> cslist;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null || candidates.length ==0){
                return cslist;
            }
            cslist = new ArrayList<>();
            recurse(candidates, target, 0, new ArrayList<>());
            return cslist;
        }

        public void recurse(int[] candidates, int target, int index, List<Integer> path){
            if( target <0){
                return;
            }

            if(target == 0){
                cslist.add(new ArrayList<>(path));
                return;
            }



            for(int i=index;i<candidates.length;i++){
                System.out.println("i "+i+" "+candidates[i]);
                path.add(candidates[i]);
                recurse(candidates, target-candidates[i], index, path);
                path.remove(path.size()-1);
            }
        }

        public static void main(String[] args){
            int[] candidates = {2,3,6,7}; int target = 7;
            CombinationSum cs = new CombinationSum();
            List<List<Integer>> cslist = cs.combinationSum(candidates,target);
            for(List<Integer> l : cslist){
                for(int i : l){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }

}
