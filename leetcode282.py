# Time Complexity  = O(n)
# Space Complexity = O(n)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []
        def helper(index,calc,tail,path):
            # Base case if we processed the entire number
            if index == len(num):
                if calc == target:
                    res.append(path)
                return
            
            #try all possible number of partitions
            for i in range(index,len(num)):
                #skipping number with leading zeros
                if i != index and num[index] == "0":
                    break
                curr = int(num[index:i+ 1])
                if index == 0:
                    #firxt number, no operator needed
                    helper(i +1,curr,curr,str(curr))
                else:
                    # Addition
                    helper(i + 1, calc + curr, curr, path + "+" + str(curr))
                    # Subtraction
                    helper(i + 1, calc - curr, -curr, path + "-" + str(curr))
                    # Multiplication
                    helper(i + 1, calc - tail + tail * curr, tail * curr, path + "*" + str(curr))
        helper(0,0,0, "")
        return res