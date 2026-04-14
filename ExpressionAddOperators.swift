//
//  ExpressionAddOperators.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/8/26.
//

/*
 It has 2 layers of recursion.
 
 + - *
 there are 4 possibilities -
 1. Not putting any operator at all.
 2. putting +
 3. putting -
 4. putting *
        1234
 1    12     123  1234 (outer layer)
 
 */

class ExpressionAddOperators {
    func addOperators(_ num: String, _ target: Int) -> [String] {
        var result = [String]()
        var path = [Character]()
        helper(Array(num), start: 0, target, calculated: 0, tail: 0, path: path, result: &result)
        return result
    }

    func helper(_ numArr: [Character], start: Int, _ target: Int, calculated: Int, tail: Int, path: [Character], result: inout [String]) {
        //the start pointer went out of bounds
        if (start == numArr.count) {
            if (calculated == target) {
                result.append(String(path))
            }
            return
        }
        //logic
        for i in start..<numArr.count {
            if (start != i && numArr[start] == "0") {
                continue
            }
            let substr = numArr[start...i]
            let currNum = Int(String(substr))! //1, 12, 123, 1234, .... 2, 23, 234....
            let strCount = substr.count //used while backtracking

            /* at first level, we have only numbers. Fron next levels, we have expressions
            */
            if (start == 0) {
                // path.append(String(currNum))
                helper(numArr, start: i + 1, target, calculated: currNum, tail: currNum, path: path + substr, result: &result) // 23
                // path.removeLast(path.count - strCount)
            } else {
                //how to put all the characters after the substring and append it to the path
                //if it't not first level. It's further levels. We have 3 options

                //+
                helper(numArr, start: i + 1, target, calculated: calculated + currNum, tail: currNum, path: path + "+" + substr, result: &result)

                //-
                helper(numArr, start: i + 1, target, calculated: calculated - currNum, tail: -currNum, path: path + "-" + substr, result: &result)

                //*
                helper(numArr, start: i + 1, target, calculated: calculated - tail + tail * currNum, tail: tail * currNum, path: path + "*" + substr, result: &result)
            }
        }
    }
    
    //MARK: using backtracking
    func addOperatorsB(_ num: String, _ target: Int) -> [String] {
        var result = [String]()
        var path: [Character] = []
        helperB(Array(num), start: 0, target, calculated: 0, tail: 0, path: &path, result: &result)
        return result
    }

    func helperB(_ numArr: [Character], start: Int, _ target: Int, calculated: Int, tail: Int, path: inout [Character], result: inout [String]) {
        //the start pointer went out of bounds
        if (start == numArr.count) {
            if (calculated == target) {
                result.append(String(path))
            }
            return
        }
        //logic
        for i in start..<numArr.count {
            if (start != i && numArr[start] == "0") {
                continue
            }
            let substr = numArr[start...i]
            let currNum = Int(String(substr))! //1, 12, 123, 1234, .... 2, 23, 234....
            let strCount = substr.count //used while backtracking

            /* at first level, we have only numbers. Fron next levels, we have expressions
            */
            if (start == 0) {
                path += substr
                // path.append(Array(substr)
                helperB(numArr, start: i + 1, target, calculated: currNum, tail: currNum, path: &path, result: &result) // 23
                path.removeLast(strCount)
            } else {
                //to put all the operators after the substring and append it to the path
                //if it't not first level. It's further levels. We have 3 options
                //+
                path = path + "+" + substr
                helperB(numArr, start: i + 1, target, calculated: calculated + currNum, tail: currNum, path: &path, result: &result)
                path.removeLast(strCount + 1)
                //-
                path = path + "-" + substr
                helperB(numArr, start: i + 1, target, calculated: calculated - currNum, tail: -currNum, path: &path, result: &result)
                path.removeLast(strCount + 1)
                //*
                path = path + "*" + substr
                helperB(numArr, start: i + 1, target, calculated: calculated - tail + tail * currNum, tail: tail * currNum, path: &path, result: &result)
                path.removeLast(strCount + 1)
            }
        }
    }
}
