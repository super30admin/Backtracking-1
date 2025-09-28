class Solution(object):
    # tc : O(n*4^n) at each step we have 4 calls: not choosing, and 3 operations and the depth of tree is n so 4^n calls, and curr making a substring n times 
    # sc : O(n^2) , recrussion stack take n space and at each node we do cur which is substrign from pivot to i+1 which is n^2 complexity  
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        # intution 
        # need to check possibilities of taking the combination of numbers and also with combination of operations like 12*3, 
        #1*2*3 etc etc, approach : will do 0/1 recurssion i.e 0 is not gng to process this element by itself( like use 12 instead of 1 itself)
        # 1 as choosign in choosing have to do 3 perations +,-,* 
        # once we have done all procesing all the elements in the nm and if this combination of expression gives the target then we append the path ( where path is the exression of the nums)

        self.result = []
        self.helper(num,target,0,0,0,"")

        return self.result

    # will use cal, tail such that we can know the change done in the previous stage and in case of +,- we can simply
    # do cal+nums[i] or cal - nums[i] but in case of * we have to priotize * over +,- so we find the change which is the number before * and then we will process the expression as
    # (cal- tail) + (tail*curr) 

    def helper(self,num,target,pivot,cal,tail,expression):

        # base 
        if pivot == len(num) and cal == target:
            self.result.append(expression)
            return

        
        for i in range(pivot,len(num)):

        # if the num[i] is 0, our expression should not return with leading zeros 
        # 1 + 0 +5 is fine but 1 + 05 is not so when the pivot is 0 and out i > pivot mena sour curr start value is gng to be 0 follwoed by some number at this case we will simply do ntg
            if num[pivot] == '0' and i > pivot: 
                break 

            curr = int(num[pivot:i+1])
            
            if pivot == 0:
                self.helper(num,target,i+1, curr,curr,expression +  str(curr)) # movign 1 step and we didnt choose so no chaneg in cal, tail
            else:

                # + 
                self.helper(num,target,i+1,cal + curr, curr, expression + "+" + str(curr))

                # -
                self.helper(num,target,i+1,cal - curr, -curr, expression + "-" + str(curr))

                # *
                self.helper(num,target,i+1,(cal- tail) + (tail*curr), tail* curr, expression + "*" + str(curr))

        
        return



        
        