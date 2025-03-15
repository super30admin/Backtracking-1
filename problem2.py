'''
// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []

        def helper(pivot, path, calc, tail):
            if pivot == len(num):
                if calc == target:
                    res.append(path)
                return
            for i in range(pivot, len(num)):
                if i != pivot and num[pivot] == '0':
                    continue
                cur = int(num[pivot: i + 1])
                if pivot == 0:
                    helper(i + 1, path + str(cur), cur, cur)
                else:
                    #Add
                    helper(i + 1, path + '+' + str(cur), calc + cur, cur)
                    #Sub
                    helper(i + 1, path + '-' + str(cur), calc - cur, -cur)
                    #Mul
                    helper(i + 1, path + '*' + str(cur), calc - tail + tail * cur, tail * cur)


        helper(0, '', 0, 0)
        return res