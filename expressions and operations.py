#for strings also look for edge case 0s
#for operations on strings always look for * operation and use tail*curr condition

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res =[]

        def helper(pivot,calc_val,tail,path,target):
            #base
            if pivot == len(num): #we are at leaf ie all digits are done
                if calc_val==target:
                    res.append(path)
                return

            #logic
            for i in range(pivot,len(num)):
                #preceeding 0 edge case  eg 105: 05 will be number with pivot at 0 but i at 5 and int will convert "05" to int 5. to avoid that
                if num[pivot] == '0' and i != pivot:
                    break
                #1 action
                curr = int(num[pivot:i+1])  #1st we get 1, 12, 123 numbers from "123" ie from pivot to i 
                if pivot==0: #no operators problems ie top level ie 1, 12, 123
                    helper(i+1,curr,curr,path+str(curr),target)
                    
                else:  # operators are present 
                #2 recurse
                    #+
                    helper(i+1,curr+calc_val,curr,path+"+"+str(curr),target)

                    #-
                    helper(i+1,-curr+calc_val,-curr,path+"-"+str(curr),target)

                    #*
                #3 backtrack only for *, we backtrack the last addition using tail and recalculate properl
                    helper(i+1, calc_val-tail+tail*curr, tail*curr, path+"*"+str(curr), target)


        helper(0,0,0,"",target)
        return res
