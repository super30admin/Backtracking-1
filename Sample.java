// Problem 1
//Time Complexity:O(2^n)
//Space Complexity:O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0) return new ArrayList<>();
        result=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int candidates[], int target, int index, List<Integer> path)
    {
if(target<0|| index>=candidates.length) return;
if(target==0)
{
    result.add(new ArrayList<>(path));
    return;

}
for(int i=index;i<candidates.length;i++)
{
    path.add(candidates[i]);
    backtrack(candidates,target-candidates[i],i,new ArrayList<>(path));
    path.remove(path.size()-1);
}
    }
}

// Problem 2
//Time Complexity:O(2^n)
//Space Complexity:O(n)

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if(num==null || num.length()==0) return new ArrayList<>();
        result=new ArrayList<>();
        recurse(num,target,0,0,0,"");
        return result;
    }
    private void recurse(String nums, int target, int index,long cal, long tail, String path)
    {
if(index==nums.length())
{
    if(cal==target)
    {
        result.add(path);
       
    }
}
    // logic
    for(int i=index;i<nums.length();i++)
    {
         if(nums.charAt(index)=='0' && index!=i) {
            continue;
        }
        long cur=Long.parseLong(nums.substring(index,i+1));
       
        if(index==0)
        {
            recurse(nums,target,i+1,cur,cur,path+cur);
        }
        else{
            //+ operator
            recurse(nums,target,i+1,cal+cur,+cur,path+"+"+cur);
            // - operator
            recurse(nums,target,i+1,cal-cur,-cur,path+"-"+cur);
            //* operator
            recurse(nums,target,i+1,cal-tail+tail*cur,tail*cur,path+"*"+cur);
        }
    
}
    }
}