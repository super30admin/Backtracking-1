//Time Complexity: O(n^2)
//Space Complexity: O(n) for the recursive stack space

class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        if(candidates==null) return result;
        helper(candidates,0,new ArrayList<>(),target);
        return result;
    }
    private void helper(int[] candidates,int pivot,List<Integer> path,int amount){
        if(amount==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(amount<0) return;
        for(int i =pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates,i,path,amount-candidates[i]);
            path.remove(path.size()-1);
                                             
        }
    }
        
    }
