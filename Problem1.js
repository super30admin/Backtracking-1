// ## Problem1 
// Combination Sum (https://leetcode.com/problems/combination-sum/)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : In for loop based recursion we need not call the NOT TAKEN METHOD also The pivor is passed as I

var combinationSum = function(candidates, target) {
    //**For loop based recursion */
    let res = []
    function helper(candidates,target,amount,path,pivot){
        for(let i =pivot;i<candidates.length;i++){
            if(amount == target){
                res.push([...path])
                return
            }
            if(amount > target){ 
                return 
            }
            path.push(candidates[i])
            helper(candidates,target,amount+candidates[i],path,i)
            path.pop()
        }
    }
    helper(candidates,target,0,[],0)
    return res
};

// var combinationSum = function(candidates, target) {
// //** 0 1 based Backtracking sol */
//     //Time Complexity : O(2^n+m)
//     //Space Complexity : O(N)
//     let res = []
//     function helper(candidates,target,amount,path,idx){
//         if(amount == target){
//             res.push([...path])
//             return 
//         }
//         if(idx >= candidates.length || amount>target){
//             return 
//         }
//         path.push(candidates[idx])
//         helper(candidates,target,amount+candidates[idx],path,idx)
//         path.pop(path.length-1)
//         helper(candidates,target,amount,path,idx+1)
//         return res
//     }
//     helper(candidates,target,0,[],0)
//     return res
// };
// var combinationSum = function(candidates, target) {
//** Recursive Sol */
//     //Time Complexity : O(2^n+m)
//     //Space Complexity : O(2^n+m)
//     let res = []
//     function helper(candidates,target,amount,path,idx){
//         if(amount == target){
//             res.push(path)
//             return 
//         }
//         if(idx >= candidates.length || amount>target){
//             return 
//         }
//         let newArray = [...path,candidates[idx]] // Create a DEEP COPY
//         helper(candidates,target,amount+candidates[idx],newArray,idx)
//         helper(candidates,target,amount,path,idx+1)
//         return res
//     }
//     helper(candidates,target,0,[],0)
//     return res
// };