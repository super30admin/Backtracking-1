/*
    L.C 39. Combination Sum

    Approach: recursion with backtracking, Type - choose/not choose or 0/1 recursion

    Working:
        //approach similar to Coin change problem
        declare an resultant array result

        recursive method
            void backtrack(array, index -> 0, sum -> 0, path -> ArrayList, target)
             //base case
             check if sum > target || index > array.length-1
                return;

            //logic
            check if target id equal to sum
                add the path to the result with new array list

            //recurse
            case 0 - not choose the current index element, move to the next index without choosing
            backtrack(candidates, index+1, sum, path, target);

            //action
            add the current index element to the path sisce we will be choosing an element in case 1

            case 1 - choose the current index element and add it to the sum
             backtrack(candidates, index, sum+candidates[index], path, target);

             //backtrack - undo action
             remove the last element from the list and move the so that, we can capture multiple paths without using n arraylist

        return result;

    Time Complexity:
    Space Complexity:



 */

class CombinationSum {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        recurse(candidates, 0, 0, new ArrayList<>(), target);

        return result;
    }

    public void recurse(int[] candidates, int index, int sum, List<Integer> path, int target) {

        //base
        if(sum > target ) {
            return;
        }
        //logic
        if(sum == target) {
            result.add(new ArrayList<>(path));
        }

        //recurse
        for(int i=index; i<candidates.length;i++) {
            //action
            path.add(candidates[i]);
            recurse(candidates, i, sum+candidates[i],path, target);

            //backtrack
            path.remove(path.size() - 1);

        }

    }
}
