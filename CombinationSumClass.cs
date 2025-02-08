public class Solution
{
    IList<IList<int>> result;
    public IList<IList<int>> CombinationSum(int[] candidates, int target)
    {
        if (candidates == null || candidates.Length == 0)
        {
            return result;
        }
        result = new List<IList<int>>();

        Backtrack(candidates, 0, target, new List<int>());
        return result;
    }
    public void Backtrack(int[] candidates, int index, int target, IList<int> path)
    {
        if (target == 0)
        {
            result.Add(new List<int>(path));
            return;
        }
        if (index == candidates.Length || target < 0)
        {
            return;
        }

        Backtrack(candidates, index + 1, target, path);
        path.Add(candidates[index]);
        Backtrack(candidates, index, target - candidates[index], path);
        path.RemoveAt(path.Count - 1);
    }
}