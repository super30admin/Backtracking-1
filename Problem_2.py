'''
282 Expression Add Operators
https://leetcode.com/problems/expression-add-operators/description/

Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

Note that a number can contain multiple digits.

Example 1:
Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.

Example 3:
Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.


Constraints:
1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1

1. Backtracking using 0/1 recursion:
case 0: don't pick any operator, just append the next digit, do a recursion on the next digit (array[i+1])
case 1: pick operator +, append the next digit, do a recursion on the next digit (array[i+1])
case 2: pick operator -, append the next digit, do a recursion on the next digit (array[i+1])
case 3: pick operator *, append the next digit, do a recursion on the next digit (array[i+1])

If N = number of digits in string, then
Time is 4^N since for each digit in string, we have 4 choices to make (cases 0,1,2,3,4). Space is O(depth) = O(log 4^N) = O(N)

Time: O(4^N), Space: O(N)

2. Backtracking using for-loop recursion:

https://www.youtube.com/watch?v=ufBY5XwfQM8

Careful handling of 0s: https://youtu.be/ufBY5XwfQM8?t=2163
'''

def addOperators_recursion(num, target):
    ''' 282 https://leetcode.com/problems/expression-add-operators/description/
        Recursion
        Time: O(4^N), Space: O(N)
    '''
    def recurse(num, target, index, head, tail, curr, path):
        if index == N:
            if target == curr:
                result.append(path)
            return

        for j in range(index, N):
            # skip strings with leading 0s "05", "051"
            if num[index] == '0' and j > index:
                continue
            number = int(num[index:j+1]) # consumed all digits num[0],..,num[j]

            if index == 0: # add operand #1 into expression
                # add only operand to path and move to the next index j+1
                recurse(num, target, j+1, head, number, number, path + str(number))
            else: # add operands #2, #3, etc into expression
                # add 'operator AND operand' to path

                # op = +: head = curr, curr = head + number, tail = number
                recurse(num, target, j+1, curr, number, curr + number, path + "+" + str(number))

                # op = -: head = curr, curr = head - number, tail = -number
                recurse(num, target, j+1, curr, -number, curr - number, path + "-" + str(number))

                # op = *: head no change, curr = head + tail * number, tail = tail * number
                recurse(num, target, j+1, head, tail*number, head + tail*number, path + "*" + str(number))

                # # op = /: head no change, curr = head + tail / number, tail = tail / number
                # if number != 0: # avoid div by 0
                #     recurse(num, target, index+1, head, tail/number, head + tail/number, path + "/" + str(number))

    if not num:
        return []
    N = len(num)
    result = []
    path = ""
    recurse(num, target, 0, 0, 0, 0, path)
    return result


def addOperators_backtrack(num, target):
    ''' 282 https://leetcode.com/problems/expression-add-operators/description/
        Backtracking
        Time: O(4^N), Space: O(N)
    '''
    def recurse(num, target, index, head, tail, curr, path):
        if index == N:
            if target == curr:
                result.append("".join(path))
            return

        for j in range(index, N):
            # skip strings with leading 0s "05", "051"
            if num[index] == '0' and j > index:
                continue
            number = int(num[index:j+1]) # consumed all digits num[0],..,num[j]

            if index == 0: # add operand #1 into expression
                # add only operand to path and move to the next index j+1
                path.append(str(number))
                recurse(num, target, j+1, head, number, number, path)
                path.pop()
            else: # add operands #2, #3, etc into expression
                # add 'operator AND operand' to path

                # op = +: head = curr, curr = head + number, tail = number
                path.append('+')
                path.append(str(number))
                recurse(num, target, j+1, curr, number, curr + number, path)
                path.pop()
                path.pop()

                # op = -: head = curr, curr = head - number, tail = -number
                path.append('-')
                path.append(str(number))
                recurse(num, target, j+1, curr, -number, curr - number, path)
                path.pop()
                path.pop()

                # op = *: head no change, curr = head + tail * number, tail = tail * number
                path.append('*')
                path.append(str(number))
                recurse(num, target, j+1, head, tail*number, head + tail*number, path)
                path.pop()
                path.pop()

    if not num:
        return []
    N = len(num)
    result = []
    path = []
    recurse(num, target, 0, 0, 0, 0, path)
    return result

def run_addOperators():
    tests = [ ("123", 6, ['1+2+3', '1*2*3']),
              ("232", 8, ['2*3+2', '2+3*2']),
              ("124", 9, ['1+2*4']),
              ("125", 7, ['1*2+5', '12-5']),
              ("015", 6,  ['0+1+5']), # cannot have expr "01+5"
              ("015", 5,  ['0+1*5', '0*1+5']), # cannot have expr "01*5"
              ("015", 15,  ["0+15"]), # cannot have expr "015"
              ("105", 15,  ['10+5']),
              ("00", 0, ["0+0", "0-0", "0*0"]),
              ("1111", -1, ["1*1-1-1","1-1*1-1","1-1-1*1"]),
              ("3456237490", 9191, []),
              ("1",1,['1']),
    ]
    for test in tests:
        num, target, ans = test[0], test[1], test[2]
        print(f"\nNumber String = {num}")
        print(f"Target Sum = {target}")
        for method in ['recursion','backtracking']:
            if method == 'recursion':
                expressions = addOperators_recursion(num, target)
            elif method == 'backtracking':
                expressions = addOperators_backtrack(num, target)
            print(f"Method {method}: Expressions = {expressions}")
            print(f"Pass: {sorted(ans) == sorted(expressions)}")

run_addOperators()
