# 282. Expression Add Operators
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        def helper(pivot,calc,tail,path_list):
            #base
            if pivot == len(num) and calc == target:
                result.append(''.join(path_list))
                return

            #logic
            for i in range(pivot,len(num)):
                if num[pivot] == '0' and i != pivot:
                    break
                currList = num[pivot:i+1]
                currNum = int(currList)
                if pivot == 0:
                    path_list.append(currList)
                    helper(i+1,currNum,currNum,path_list)
                    path_list.pop()
                else:
                    #+
                    path_list.extend(['+', currList])
                    helper(i+1,calc+currNum,currNum,path_list)
                    path_list.pop()
                    path_list.pop()

                    #-
                    path_list.extend(['-', currList])
                    helper(i+1,calc-currNum,-currNum,path_list)
                    path_list.pop()
                    path_list.pop()

                    #*
                    path_list.extend(['*', currList])
                    helper(i+1,(calc-tail)+(tail*currNum),(tail*currNum),path_list)
                    path_list.pop()
                    path_list.pop()




        result = []
        helper(0,0,0,[])
        return result
        