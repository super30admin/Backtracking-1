// Time Complexity : O(2^(n+k)) where n is the total number of elements in the candidates array and k is the target
// Space Complexity : O(n) where n = (target/min(candidates))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I call a recursive Helper method to which I pass the candidates array, target, index(0 initally) and temp list. 
At every index, I have two options - Choose or Don't Choose. 
For Choose - 
    1. Add candidates[index] to templist
    2. Subtract candidates[index] from target
    3. Recursively call Helper on the same index (you can choose multiple of the same element)

For Not Choose - 
    1. Backtrack (Remove element that was added in the Choose condition)
    2. Recursively call Helper on the next index and pass the original target value

Base Condition - 
    If target = 0, create a deep copy of tempList and add it to result and return.
    If target < 0 or index = candidates.Length, return
*/

public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> CombinationSum(int[] candidates, int target) {
        result = new();
        Helper(candidates, target, 0, new List<int>());
        return result;
    }

    public void Helper(int[] candidates, int target, int index, List<int> tempList)
    {
        // Base Condition
        if(target <= 0)
        {
            if(target == 0)
            {
                result.Add(new List<int>(tempList));
            }
            
            return;
        }

        if(index == candidates.Length)
        {
            return;
        }

        // Choose
        tempList.Add(candidates[index]);
        Helper(candidates, target - candidates[index], index, tempList);

        // Backtrack
        tempList.RemoveAt(tempList.Count - 1);

        // Don't choose
        Helper(candidates, target, index + 1, tempList);

    }
}