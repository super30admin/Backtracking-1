public class Solution
{

    IList<string> result;
    public IList<string> AddOperators(string num, int target)
    {
        if (num == null || num.Length == 0)
        {
            return result;
        }

        result = new List<string>();
        Recurse(num, target, 0, 0, 0, "");
        return result;
    }
    public void Recurse(string nums, int target, long calc, long tail, int index, string path)
    {
        //base
        if (index == nums.Length)
        {
            if (target == calc)
            {
                result.Add(path.ToString());
            }
            return;
        }

        //logic
        for (int i = index; i < nums.Length; i++)
        {
            if (nums[index] == '0' && i != index)
            {
                continue;
            }
            long curr = long.Parse(nums.Substring(index, i + 1 - index));
            if (index == 0)
            {
                Recurse(nums, target, curr, curr, i + 1, path + curr);
                continue;
            }
            //+
            Recurse(nums, target, calc + curr, +curr, i + 1, path + "+" + curr);
            //-
            Recurse(nums, target, calc - curr, -curr, i + 1, path + "-" + curr);
            //*
            Recurse(nums, target, calc - tail + tail * curr, tail * curr, i + 1, path + "*" + curr);
        }
    }
}