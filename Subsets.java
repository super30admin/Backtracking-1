// 0-1 recursion
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper (int nums[], List<Integer> path, int index) {

        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(path)); // deep copy
            return;
        }

        //not choose
        helper(nums, path, index + 1);

        //choose
        path.add(nums[index]);
        helper(nums, path, index + 1);

        //backtrack
        path.remove(path.size() - 1);
    }
}

// for lopp recursion
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper (int nums[], List<Integer> path, int pivot) {
    
        result.add(new ArrayList<>(path)); // deep copy

        for(int i = pivot; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, path, i + 1);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}

// Start with the empty subset in the result list.
//For each number, copy all current subsets and append the number to create new subsets.
class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {
            int size = result.size();
            for(int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        
        return result;
    }
}


// Time = O(N*2^N)
// Space = O(N)