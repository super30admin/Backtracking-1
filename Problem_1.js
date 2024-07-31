
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    
    let result = [];

    const combinationSumHelper = (candidates, pivot, target, path) => {
        //base case 
        if(target < 0)
            return;
        if(target === 0) {
            result.push([...path]); return;//deepcopy to result
            } 
        //recursive case 
            for(let i=pivot ; i< candidates.length; i++){
                //action 
                path.push(candidates[i]);
                //recurse 
                combinationSumHelper(candidates, i, target - candidates[i], path)
                //backtrack action 
                path.pop();
            }
           
    }

    combinationSumHelper(candidates, 0, target, []);
    return result;
};