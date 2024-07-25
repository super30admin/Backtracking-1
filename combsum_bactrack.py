class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res=[]
        #0/1 recursion with backtracking
        #inx 0, path initial is [], to be appended when amt =0 at sme call
        self.helper(candidates, 0, [], res, target )
        return res

    def helper (self, candidates, idx, path, res, target):
        #base-- when to return 
        if idx== len(candidates) or target<0: return
        #when to append to res--> when target==0
        if target==0:
            #res.append(path)-->WONT WORK CUZ PATH REF IS PASSES, FINALLY 
            #AFTER POP PATH=[] (FROM DUST TO DUST)
            res.append(path.copy())
            return