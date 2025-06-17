# Time Complexity : O(4^N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []
        n = len(num)
        
        def backtrack(index, path, value, prev):
            if index == n:
                if value == target:
                    res.append(path)
                return
            for i in range(index, n):
                # Avoid numbers with leading zeros
                if i != index and num[index] == '0':
                    break
                curr_str = num[index:i+1]
                curr = int(curr_str)
                if index == 0:
                    backtrack(i+1, curr_str, curr, curr)
                else:
                    backtrack(i+1, path + '+' + curr_str, value + curr, curr)
                    backtrack(i+1, path + '-' + curr_str, value - curr, -curr)
                    backtrack(i+1, path + '*' + curr_str, value - prev + prev * curr, prev * curr)
        backtrack(0, '', 0, 0)
        return res
        