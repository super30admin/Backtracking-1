/*
  Time complexity: O(n^(T / min))
  Space complexity: O(T)

*/


public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> CombinationSum(int[] candidates, int target) {
        result = new();
        BackTracking(candidates, target, 0, new List<int>());
        return result;
    }

    private void BackTracking(int[] candidates, int target, int start, List<int> temp)
    {
        if(target==0)
        {
            result.Add(new List<int>(temp));
            return;
        }
        else
        if(target<0)
            return;

        for(int i=start;i<candidates.Length;i++)
        {
            temp.Add(candidates[i]);
            BackTracking(candidates, target-candidates[i],i,temp);
            temp.RemoveAt(temp.Count-1);
        }
    }
}
