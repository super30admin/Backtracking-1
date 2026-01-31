// In this problem, we are using 01 backtracking where at each index we have two choices. We can either choose the element at that index or not choose it. When we choose the element, we add it to path and then recurse with target - the candidate we chose and whne we don't choose the element we keep the target same but move our pointer to the next one.
// Time complexity : O(2 ^ (m+n)) where m is the candidates length and n is the target
// Space complexity : O(n) for the path list and recursion stack


class Solution {
    val result = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        helper(candidates, target, 0, mutableListOf())
        return result
    }

    fun helper(candidates: IntArray, target: Int, i: Int, path: MutableList<Int>) {
        //base
        if (target< 0 || i == candidates.size) return
        if(target == 0) {
            result.add(path.toList())
            return
        }

        //no choose
        helper(candidates, target, i+ 1, path)

        //choose
        path.add(candidates[i])
        helper(candidates, target - candidates[i], i, path)
        path.removeAt(path.lastIndex)
    }
}