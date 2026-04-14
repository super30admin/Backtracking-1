//
//  CombinationSum.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/2/26.
//

class CombinationSum {
    func combinationSum(_ candidates: [Int], _ target: Int) -> [[Int]] {
        var result = [[Int]]()
        helper(candidates: candidates, idx: 0, target: target, path: [], result: &result)
        return result
    }

    //0-1 recursion
    /*
     time complexity - 2^(m + n)
     space complexity - depth of recursion stack - (m+n)
     */
    func helper(candidates: [Int], idx: Int, target: Int, path: [Int], result: inout [[Int]]) {
        //base
        if (target == 0) {
            result.append(path)
            return
        }
        if (idx == candidates.count || target < 0) {
            return
        }

        //logic

        //recurse

        //no choose
        helper(candidates: candidates, idx: idx + 1, target: target, path: path, result: &result)
        var path = path
        path.append(candidates[idx])
        //choose
        helper(candidates: candidates, idx: idx, target: target - candidates[idx], path: path, result: &result)
    }
}

class CombinationSumUsingForLoopBasedRecursion {
    func combinationSum(_ candidates: [Int], _ target: Int) -> [[Int]] {
        var result = [[Int]]()
        getCombinations(candidates: candidates, start: 0, target: target, path: [], result: &result)
        return result
    }

    //for loop based recursion - time complexty - 2^(m+n)
    /*
     here width of the tree is more and height is lesser. Effectvely it's choose, not choose algorithm only.
     Some places, for loop based recursions is beneficial because it's easier to reach solution.
     case in point, permutation of string, combination of string
     */
    func getCombinations(candidates: [Int], start: Int, target: Int, path: [Int], result: inout [[Int]]) {
        //base
        if (target == 0) {
            result.append(path)
            return
        }

        if (target < 0) {
            return
        }

        //logic
        var path = path
        for i in start..<candidates.count {
            //action
            path.append(candidates[i])

            //recurse
            getCombinations(candidates: candidates, start: i, target: target - candidates[i], path: path,  result: &result)
            
            //backtrack
            path.removeLast()
        }
    }
    
    
    /*
     for loop based recursion - If we want different permutations of the numbers which is summing up to a target then don't pass pivot to the recursive function. Always start from 0.
     */
    func getPermutationsWithDifferentArrangements(candidates: [Int], target: Int, path: [Int], result: inout [[Int]]) {
        //base
        if (target < 0) {
            return
        }
        if (target == 0) {
            result.append(path)
            return
        }
        
        //logic
        var path = path
        for i in 0..<candidates.count {
            //action
            path.append(candidates[i])
            
            //recurse
            getPermutationsWithDifferentArrangements(candidates: candidates, target: target - candidates[i], path: path,  result: &result)
            
            //backtrack
            path.removeLast()
        }
    }
}


//For permutation

class Permutation {
    func combinationSum(_ candidates: [Int], _ target: Int) -> [[Int]] {
        var result = [[Int]]()
        getCombinationsWithDifferentArrangements(candidates: candidates, target: target, path: [],result: &result)
        return result
    }

    func getCombinationsWithDifferentArrangements(candidates: [Int], target: Int, path: [Int], result: inout [[Int]]) {
        //base
        if (target < 0) {
            return
        }
        if (target == 0) {
            result.append(path)
            return
        }

        //logic
        var path = path
        for i in 0..<candidates.count {
            //action
            path.append(candidates[i])

            //recurse
            getCombinationsWithDifferentArrangements(candidates: candidates, target: target - candidates[i], path: path,  result: &result)
            
            //backtrack
            path.removeLast()
        }
    }
}
