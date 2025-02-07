### RECURSIVE SOLUTION
# Time Complexity : exponential
# Space Complexity : O(n), because we are creating a new string when appending 2 strings at every recursuve call
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# using recursive solution, we have been given a string, we have to take substrings out recursively and use all operators with possible substrings
# to check if the evaluated value is equal to the given target
# we can have 4 branches - one is creating a number using the element of the string, without using any operators (because its nowhere given in the question that we cannot make numbers frm the given string or that we have to use digits alone)
# then we can use +, - or * operator bw different substrings
# variables used - calc (sum of previous calc value and the current num value)
# tail - last added/substracted value



class Solution(object):
    def __init__(self):
        self.result = []
    
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        if num is None:
            return []
        
        self.recurse(num, target, 0, 0, 0, "")
        return self.result
    
    def recurse(self, num, target, index, calc, tail, path):
        # base case
        # index reaches the end of the string
        if index == len(num):
            # check if current calc value is equal to target
            if calc == target:
                self.result.append(path)
            return

        # logic  for loop based recursion
        # i is iterating over all elements in the given string
        # starting from index (0) to the end of the string
        for i in range(index, len(num)):
            
            if num[index] == '0' and index != i:
                continue
            
            # making the number without any operator
            # so that we can use these for performing other operators
            # branch one - combining elements of the string as int 
            curr = int(num[index:i+1])
            
            if index == 0:
                # so since we are the first element, we cannot use operators
                # calc is also num[0] and so is tail
                self.recurse(num, target, i + 1, curr, curr, path + str(curr))
            

            else:
                # no we can use operators:

                # + operator
                # i will increment, cal becomes old cal + curr um and tail is + curr
                self.recurse(num, target, i + 1, calc + curr, +curr, path + "+" + str(curr))
                
                # - operator
                self.recurse(num, target, i + 1, calc - curr, -curr, path + "-" + str(curr))
                
                # * operator
                # we maintain tail for this case, else we could have just changed new calc = old calc (operator) current
                # but to maintain precedence of operators, we cannot do 3 + 3 instead of 1 + 2 * 3
                # so we need 1, 2, 3 separately so that we can complete the operation
                self.recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + str(curr))










        