// Time Complexity : O(2^(target/min)*n)
// Space Complexity : O(target/min)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

var combinationSum = function(candidates, target) {
    let result = [];
    let path = [];

    let helper = function(candidates, target, pivot, path) {
        //base case
        if(target < 0) return;
        if(target === 0) {
            result.push([...path]);
            return;
        }

        //logic
        for(let i = pivot; i < candidates.length; i++) {
            path.push(candidates[i]); //we are adding i not pivot because i is the one traversing through the array
            helper(candidates, target-candidates[i], i, path);
            path.pop();
        }
    }
    helper(candidates, target, 0, path);
    return result;
}
