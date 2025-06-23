# Time Complexity: Exponential, O(4^n)
# Space Complexity: O(n) 
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.num = num
        self.target = target
        self.result = []
        self.helper(0,0,0,"")
        return self.result

    def helper(self, index, calc, tail, path):
        # Base Case
        if index == len(self.num):
            if calc == self.target:
                self.result.append(path)
            return

        # Logic
        for i in range(index, len(self.num)):
            # Skip numbers with leading zeros
            if self.num[index] == '0' and i != index:
                break

            curr_str = self.num[index:i+1]
            curr = int(curr_str)
            if index == 0:
                # First number, just pick it (no operator)
                self.helper(i+1, curr, curr, curr_str)
            else:
                # + 
                self.helper(i+1, calc+curr, curr, path + '+'+ curr_str)
                # -
                self.helper(i+1, calc-curr, -curr, path + '-'+curr_str)
                # *
                self.helper(i+1, calc-tail+(tail*curr), tail*curr, path+'*'+curr_str)