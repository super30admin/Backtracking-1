import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> result;
    static List<Integer> path;

    //Both approaches have O(2^(m*n)) T.C where 01 is depth first and for-loop is breadth first
    //Both have O(k) S.C where k is length of deep copies of paths created while disregarding the stack space
    public static List<List<Integer>> combinationSum(int[] candidates, int target, int input) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        //not an actual problem but just the way I am running different type of recursions on same class
        if (input == 0) {
            combination01Recursion(candidates, 0, target);
        } else if(input == 1) {
            combinationForLoopRecursion(candidates, 0, target);
        } else{
            System.out.println("Valid input is 0 for 01 recursion and 1 for for loop recursion");
            return null;
        }
        return result;
    }

    static void combination01Recursion(int[] candidates, int index, int target) {

        if(target == 0) { //if target is perfectly 0
            result.add(new ArrayList<>(path)); //add the current path to result as a valid answer
            return;
        }

        if(target < 0 || index == candidates.length) return; //if target becomes negative or index reaches end of input

        //don't choose
        combination01Recursion(candidates, index+1, target); //skip the current index if you dont want to choose

        //choose
        path.add(candidates[index]); //add the current value into path if you want to choose it
        combination01Recursion(candidates, index, target-candidates[index]); //perform recursion at same index
        //but with reduced target of the inserted path value

        //backtrack
        path.removeLast(); //remove the last added value from path to proceed with no-choose scenario
    }

    static void combinationForLoopRecursion(int[] candidates, int pivot, int target) {
        //here we take pivot and not index to not confuse between i - the actual index here and
        //pivot - the starting point of the candidates array at each level

        if(target == 0) { //same as above
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0) return; //same as above,
        //but the scenario where pivot can reach the length of input is handled by for loop itself

        for(int i=pivot; i<candidates.length; i++) { //start from pivot, initially 0
            path.add(candidates[i]); //add the current value to path

            combinationForLoopRecursion(candidates, i, target-candidates[i]); //continue recursion
            //with pivot changed to i, so it traverses until rest of the length of input list

            //backtrack
            path.removeLast(); //same as above, to continue with next value
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {2,3,5};
        int target1 = 8;

        System.out.println("The combination paths from " + Arrays.toString(candidates1) + " that equal to sum "
                + target1 + " using 0-1 recursion are " + combinationSum(candidates1, target1, 0));

        System.out.println("The combination paths from " + Arrays.toString(candidates1) + " that equal to sum "
                + target1 + " using for loop recursion are " + combinationSum(candidates1, target1, 1));
    }
}