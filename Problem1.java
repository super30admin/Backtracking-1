public class Problem1 {
    class (0-1Recurssion) {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0){
                return new ArrayList<>();
            }
            result = new ArrayList<>();
            recurssion(candidates,target,0,new ArrayList<>());
            return result;
        }
        private void recurssion(int[] candidates, int target, int index, List<Integer> path){
            //base
            if(index>=candidates.length || target <0){
                return;
            }
            if(target == 0){
                result.add(path);
                return;
            }
            //recurssive
            //1)donot pick
            recurssion(candidates,target,index+1,new ArrayList<>(path));
            //2)pick
            path.add(candidates[index]);
            recurssion(candidates,target-candidates[index],index,new ArrayList<>(path));
        }
    }

    class (0-1RecurssionWithBackTracking) {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0){
                return new ArrayList<>();
            }
            result = new ArrayList<>();
            recurssion(candidates,target,0,new ArrayList<>());
            return result;
        }
        private void recurssion(int[] candidates, int target, int index, List<Integer> path){
            //base
            if(index>=candidates.length || target <0){
                return;
            }
            if(target == 0){
                result.add(new ArrayList<>(path));
                return;
            }
            //recurssive
            //1)donot pick
            recurssion(candidates,target,index+1,path);
            //2)pick
            //action
            path.add(candidates[index]);
            //recurssion
            recurssion(candidates,target-candidates[index],index,path);
            //backtrack and undo the action
            path.remove(path.size()-1);
        }
    }
}
