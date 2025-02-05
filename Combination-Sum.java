Combination Sum (https://leetcode.com/problems/combination-sum/)

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


//Approach
// As we have to give all possible combinations so we can think of recursion also we can either pick or not pick the element so we can think of
// 0-1 recursion approach 

//Approach-1
//In this we are doing an 0-1 approach and we are maintaing a list in which we are adding elements just when we are picking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Base case
        if(candidates==null || candidates.length ==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        //recurse function call
        recurse(candidates, target,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target,int index, List<Integer> path){
        //base cases
        if(target<0 || index>candidates.length-1){
            return;
        }
        if(target==0){
            result.add(path);
            return;
        }


        //processing
        //0-call
        recurse(candidates, target,index+1,path);
        //adding elements to path
        path.add(candidates[index]);
        //1-call
        recurse(candidates, target-candidates[index],index,path);
    }
}

//problem with this approach is as we are maintaining a single list and we are adding into it will just give 2 lists in result but those will be 
// same due to the nature of the list in java as it is pass by reference
// Input -candidates = [2,3,6,7], Target = 7
//Expected output - [[2,2,3],[7]]
//output - [[7,6,7,6,3,7,6,3,7,6,3,2,7,6,3,7,6,3,2,7,6,3,2,7,6,3,2],[7,6,7,6,3,7,6,3,7,6,3,2,7,6,3,7,6,3,2,7,6,3,2,7,6,3,2]]
// Time complexity : O(2^n) -> as every call is giving 2 further calls so it will be exponential 
// Space Complexity : O(target) -> let's consider the smallest  element in candidates array is 1 so there will be target np of calls in stack
                 // : O(2^n) -> we are adding every subset in a list so there can be max 2^n possiblities in worst case but as this we are asked so we will not consider

// Space Complexity = O(target)


//To overcome above problem we are creating and copying a list at every recursive calls so we will create 2^n lists and copy the elements in the worst case there will be target elements in the list in smallest element in 1
// Space complexity in that case will be O(2^n) * target
// Time complexity will be 2^n * target  (target for copying)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Base case
        if(candidates==null || candidates.length ==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        //recurse function call
        recurse(candidates, target,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target,int index, List<Integer> path){
        //base cases
        if(target<0 || index>candidates.length-1){
            return;
        }
        if(target==0){
            result.add(path);
            return;
        }


        //processing
        //0-call
        recurse(candidates, target,index+1,new ArrayList<>(path));
        //adding elements to path
        path.add(candidates[index]);
        //1-call
        recurse(candidates, target-candidates[index],index,new ArrayList<>(path));
    }
}

//The above approach solves problem but comes with the cost

//Solution for above cost problem is backtracking
//Template : action, recurse, backtrack
// Time Complexity : O(2^n ×target)
// O(2^n) comes from the exponential growth of recursive calls.
// O(target) comes from the time spent copying the path when a valid combination is found.
// Space Complexity : O(target)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Base case
        if(candidates==null || candidates.length ==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        //recurse function call
        recurse(candidates, target,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target,int index, List<Integer> path){
        //base cases
        if(target<0 || index>candidates.length-1){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }


        //processing
        //0-call
        recurse(candidates, target,index+1,path);
        //adding elements to path
        //action
        path.add(candidates[index]);
        //1-call
        //recurse
        recurse(candidates, target-candidates[index],index,path);
        //backtrack
        path.remove(path.size()-1);
    }
}

//Another way to solve this question is For loop based recursion
// In this approach we are using a for loop to interate over the candidates array. Also we will iterate at each step
//Time complexity : Exponential O(n*2^n) n for for loop and for each index it is doing recursive calls for every possible so 2^n for that
//Space Complexity : O(target) *
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Base case
        if(candidates==null || candidates.length ==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        //recurse function call
        recurse(candidates, target,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target,int index, List<Integer> path){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(path);
        }

        for(int i=index;i<candidates.length;i++){
            path.add(candidates[i]);
            recurse(candidates, target-candidates[i],i,path);
        }
    }
}

//Problem with this approach will be same as that we sam earlier ddue to nature of the list in java
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Base case
        if(candidates==null || candidates.length ==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        //recurse function call
        recurse(candidates, target,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target,int index, List<Integer> path){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(path);
        }

        for(int i=index;i<candidates.length;i++){
            List<Integer> newList=new ArrayList<>(path);
            newList.add(candidates[i]);
            recurse(candidates, target-candidates[i],i,newList);
        }
    }
}
//But again we are creating a new list at every iteration so it will come up with a cost
//The above is the recursive solution and not the backtracking solution

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Base case
        if(candidates==null || candidates.length ==0){
            return new ArrayList<>();
        }
        result=new ArrayList<>();
        //recurse function call
        recurse(candidates, target,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target,int index, List<Integer> path){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(path));
        }

        for(int i=index;i<candidates.length;i++){
            //action
            path.add(candidates[i]);
            //recurse
            recurse(candidates, target-candidates[i],i,path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}