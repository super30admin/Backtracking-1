//we wont do greedy because we are aksed to give all possible solutions , so exhaustive is better approach
//dp is also not oprimised approach, whenever we want to find path we need to keep track of path while on recurssion
// 


//0,1 resurssiona approach (choose no choose case)
//sending path like this is problem also taking result is problem because
//it will take the same reference and change result everytime, because when resurssion comes back to fuc call 
//i wont contain same values from last call 
//answer is to deep copy every time the path or use backtracking
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         this.result = new ArrayList<>();
  
//         int i = 0;

//         helper(candidates, i, target, new ArrayList<>());
//         return result;
 
//     }

//     private void helper(int[] candidates, int i, int target, List<Integer> path){
//     //     //base case
//     //     if(target == 0){
//     //         result.add(path);
//     //         return;
//     //     }
//     //     if(target < 0 || i == candidates.length) return;


//     //     // logic
//     //     //no choose
//     //    // helper(candidates, i + 1, target, path);//here problem is same reference is going inside the stack we need to 
//     //     // make different references at each and every step
//     //     //with deep copy
//     //     helper(candidates, i + 1, target, new ArrayList<>(path));

//     //     //choose
//     //     path.add(candidates[i]);
//     //     helper(candidates, i, target - candidates[i], new ArrayList<>(path));
//     //backtracking
//     //base case
//         if(target == 0){
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         if(target < 0 || i == candidates.length) return;


//         // logic
//         //no choose
//        // helper(candidates, i + 1, target, path);//here problem is same reference is going inside the stack we need to 
//         // make different references at each and every step

//         helper(candidates, i + 1, target, new ArrayList<>(path));

//         //choose
//         path.add(candidates[i]);
//         helper(candidates, i, target - candidates[i], new ArrayList<>(path));

//         //backtracking in this case chooose case will work beafore no choose case 

//         path.remove(path.size() - 1);
//     }
// //-----------if we wanna do choose case first
//     //   private void helper(int[] candidates, int i, int target, List<Integer> path){
//     //     //base case
//     //     if(target == 0){
//     //         result.add(path);
//     //         return;
//     //     }
//     //     if(target < 0 || i == candidates.length) return;

//     //      //choose
//     //     //create deep copy before sending it to recurssion
//     //    List<Integer> temp = new ArrayList<>(path);
//     //     temp.add(candidates[i]);
//     //     helper(candidates, i, target - candidates[i], temp);


//     //     // logic
//     //     //no choose
//     //    // helper(candidates, i + 1, target, path);//here problem is same reference is going inside the stack we need to 
//     //     // make different references at each and every step
//     //     //with deep copy
//     //     helper(candidates, i + 1, target, new ArrayList<>(path));

//     // }
// } 

//tc will be same for 0 1 recursion and for loop based - 2^m+n
//for many problems for loop based recurssion is more intuitive than 0,1 recursion. ex- if we are having multiple
//babies like, in a graph problem, in an n array tree 
// //with backtracking
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         this.result = new ArrayList<>();
  
//         int i = 0;

//         helper(candidates, target, 0, new ArrayList<>());
//         return result;
 
//     }

//     private void helper(int[] candidates, int target, int pivot, List<Integer> path){
//         //base
//         if(target < 0 || pivot == candidates.length) return;
//         if(target == 0){
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         //logic

//         for(int i= pivot; i <candidates.length; i++){// start from pivot
//         //action
//             path.add(candidates[i]);
//             //recurssion
//             helper(candidates, target-candidates[i], i, path);//send i as pivot for baby 
//             //backtrack
//             path.remove(path.size()-1);//backtrack, remove from path the element while going back to parent
//         }


//     }
// }


// //with deep copy
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         this.result = new ArrayList<>();
  
//         int i = 0;

//         helper(candidates, target, 0, new ArrayList<>());
//         return result;
 
//     }

//     private void helper(int[] candidates, int target, int pivot, List<Integer> path){
//         //base
//         // if(target < 0 || pivot == candidates.length) return;//for loop takes care of this
//          if(target < 0 || pivot == candidates.length) return;
//         if(target == 0){
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         //logic

//         // for(int i= pivot; i <candidates.length; i++){// start from pivot
//         // //action
//         //     path.add(candidates[i]);//in this case we are adding path value first at initial node then sending its
//         //     //deep copy, but when come back to that initial node we want list empty beacuse i will move to next 
//         //     //place and that will be first value in path, so its adding extra values to path
//         //     helper(candidates, target-candidates[i], i, new ArrayList<>(path));//send i as pivot for baby 
            
//         // }

//          for(int i= pivot; i <candidates.length; i++){// start from pivot
      
//             List<Integer> temp = new ArrayList<>(path);//to solve above problem we will create deep copy first
//             //then add value to that new deep copy and send it in recursion, so that it reflact to initial list
//             temp.add(candidates[i]);
//             helper(candidates, target-candidates[i], i, temp);//send i as pivot for baby 
            
//         }



//     }
// }

//path as global
class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        int i = 0;

        helper(candidates, target, 0);
        return result;
 
    }

    private void helper(int[] candidates, int target, int pivot){
        //base
        // if(target < 0 || pivot == candidates.length) return;//for loop takes care of this
         if(target < 0 || pivot == candidates.length) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //for permutaion tc- n^t--n- no of ele, t  = target
         //to have all permutations in combination sum result set i = 0 in below loop, start from i=0 always
         //in case of choose and no choose case while on choose case send i as 0 always to start from begining
        for(int i= pivot; i <candidates.length; i++){// start from pivot
        //action
            path.add(candidates[i]);
            helper(candidates, target-candidates[i], i);//send i as pivot for baby 
            path.remove(path.size()-1);
            
        }
        //result in local will also work

    }
}