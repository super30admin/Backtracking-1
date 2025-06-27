// ## Problem2
// Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)
var addOperators = function(num, target) {
    const res = [];

    function backtrack(index, path, value, prev) {
        if (index === num.length) {
            if (value === target) {
                res.push(path);
            }
            return;
        }

        for (let i = index; i < num.length; i++) {

            if (i !== index && num[index] === '0') break;

            let str = num.substring(index, i + 1);
            let curr = parseInt(str);

            if (index === 0) {

                backtrack(i + 1, str, curr, curr);
            } else {

                backtrack(i + 1, path + '+' + str, value + curr, curr);

                backtrack(i + 1, path + '-' + str, value - curr, -curr);

                backtrack(i + 1, path + '*' + str, value - prev + (prev * curr), prev * curr);
            }
        }
    }

    backtrack(0, "", 0, 0);
    return res;
};
