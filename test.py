class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        arr = []
        for i in range(1,n+1):
            arr.append(i)

        result = []
        def helper(i,k,path):
            nonlocal result
            if k == 0 and n == 0:
                result.append(path)
                return
            if k < 0 or i >= len(arr):
                return

            #not choose
            helper(i+1,k,path)

            #choose
            path.append(arr[i])
            helper(i+1,k-1,path)

        helper(0,k,[])
        return result

        