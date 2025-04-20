
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

import static java.lang.Integer.remainderUnsigned;
import java.util.ArrayList;

/*

Approach:- 
We are given an array of integers 'candidatews and a target integer 'target'.
We need to find all unique combination of candidates where the sum equals the target.
Each number in 'candidates' may be used unlimited times.

We use a recursive method ('backtrack') to try all combinations:
-At each step, we pick the current number again (hence, same 'start' index).
-We keep track of the remaining target('remain').
-If 'remain == 0', we have a valid combination.
-If 'remain < 0', we overshoot and backtrack.
-After each choice, we undo the choice (backtrack) to explore other options.

*/



class Solution {

    protected void backtrack(
                 int remain,
                 LinkedList<Integer> comb,
                 int start,
                 int[] candidates,
                 List<List<Integer>> results
        ){

            if(remain==0){
                results.add(new ArrayList<Integer>(comb));
                return;
            }

            else if(remain<0){
                return;
            }


            for(int i = start; i< candidates.length; ++i){
                comb.add(candidates[i]);

                this.backtrack(remain-candidates[i], comb, i, candidates, results);

                comb.removeLast();

            }
        }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        this.backtrack(target, comb, 0, candidates, results);
        return results;


      
        
    }
}