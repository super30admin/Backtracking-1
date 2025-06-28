from typing import List
# class Solution:
#     def addOperators(self, num: str, target: int) -> List[str]:
#         self.res = []
#         def helper(num, pivot, calc, tail,path, target):
#             #base
#             if pivot == len(num):
#                 if calc == target:
#                     self.res.append(path)
#             #logic
#             for i in range(pivot,len(num)):
#                 # preceeeding 0 edge case
#                 if i!=pivot and num[pivot] == '0': continue
#                 cur_str = num[pivot:i+1]
#                 curr = int(cur_str)
#                 if pivot == 0:
#                     helper(num , i+1, curr, curr, path+cur_str,target)
#                 else:
#                     # three choices + - or *
#                     helper(num , i+1, calc+curr, curr, path+"+"+cur_str, target)
#                     helper(num , i+1, calc-curr, -curr, path+"-"+cur_str, target)
#                     helper(num , i+1, calc-tail+tail*curr, tail*curr, path+"*"+cur_str, target)
#         helper(num,0,0,0,"", target)
#         return self.res

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res = []
        def helper(num, pivot, calc, tail,path, target):
            #base
            if pivot == len(num):
                if calc == target:
                    self.res.append(''.join(path))
                    return
            #logic
            for i in range(pivot,len(num)):
                # preceeeding 0 edge case
                if i!=pivot and num[pivot] == '0': break

                cur_str = num[pivot:i+1]
                curr = int(cur_str)
                len_before = len(path)

                if pivot == 0:
                    path.append(cur_str)
                    helper(num , i+1, curr, curr, path,target)
                    path[:] = path[:len_before]
                else:
                    # three choices + - or *
                    path.extend(['+', cur_str])
                    helper(num , i+1, calc+curr, curr, path, target)
                    path[:] = path[:len_before]

                    path.extend(['-', cur_str])
                    helper(num , i+1, calc-curr, -curr, path, target)
                    path[:] = path[:len_before]

                    path.extend(['*', cur_str])
                    helper(num , i+1, calc-tail+tail*curr, tail*curr, path, target)
                    path[:] = path[:len_before]
        helper(num,0,0,0,[], target)
        return self.res


        


        