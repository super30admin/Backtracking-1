# Time = O(4**N)
# Space = O(exp)

class Solution:
    def __init__(self):
        self.result = []
    def addOperators(self, nums: str, target: int) -> List[str]:
        if not nums:
            return []
        self.recurse(nums, 0, target, 0, 0, "")
        return self.result
    
    def recurse(self, nums, index, target, cal, tail, path):
        # base
        if index == len(nums):
            if cal == target:
                self.result.append(path)
            return

        #logic 
        
        
        for i in range(index, len(nums)):
            if i != index and nums[index] == '0':
                break
            
            curr = int(nums[index:i+1])
            
            if index == 0:
                # first case 
                self.recurse(nums, i+1, target, curr, curr, path + str(curr))
            else:
                # + operator
                self.recurse(nums, i+1, target, cal + curr, +curr, path + "+" + str(curr))
                # - operator
                self.recurse(nums, i+1, target, cal - curr, -curr, path + "-" + str(curr))
                # * operator 
                self.recurse(nums, i+1, target, cal - tail + tail*curr, tail*curr, path + "*" + str(curr))
        