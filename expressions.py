# Time Complexity : O(2^N.N) where N is the number of nodes in the  tree
# Space Complexity : O(N) where N is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am creating an ans list to store the valid expressions.
# I am using a helper function to perform backtracking.
# The helper function takes the pivot index, tail value, calculated value and current path as input.
# If the pivot index is equal to the length of the num string, I check if the calculated value is equal to the target.
# If it is, I append the current path to the ans list.
# I iterate through the num string starting from the pivot index to avoid duplicates.
# For each character, I check if it is '0' and if it is not the first character in the current substring.
# If it is, I break the loop to avoid leading zeros.
# I convert the current substring to an integer and store it in curr.
# If the pivot index is 0, I call the helper function recursively with the updated pivot index, tail value, calculated value and current path.
# If the pivot index is not 0, I call the helper function recursively for each of the 3 operators (+, -, *) with the updated values.
# Finally, I return the ans list.   


from typing import List
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        ans = []
        def helper(pivot,tail,calc,path):
            if pivot == len(num):
                if target == calc:
                    ans.append(path)
            for i in range(pivot,len(num)):
                if num[pivot] == '0' and i != pivot:
                    break
                curr = int(num[pivot:i+1]) 
                if pivot == 0:
                    helper(i+1,curr,curr,path+str(curr))
                else:
                    helper(i+1,curr,calc+curr,path+"+"+str(curr))

                    helper(i+1,-curr,calc-curr,path+"-"+str(curr))

                    helper(i+1,tail*curr,calc-tail+(curr*tail),path+"*"+str(curr))
        helper(0,0,0,"")
        return ans

        