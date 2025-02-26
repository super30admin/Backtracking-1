class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates is None or len(candidates) == 0:
            return []
        self.result = []
        self.recurse(candidates, target, 0, [])
        return self.result

    def recurse(self, candidates: List[int], target:int, idx: int, path: List[int]) -> None:
        # base case
        if target == 0:
            self.result.append(path[:])
            return
        if idx == len(candidates) or target < 0:
            return

        # logic
        #0case
        self.recurse(candidates, target, idx + 1, path)

        # 1 case

        # action
        path.append(candidates[idx])
        # recurse
        self.recurse(candidates, target - candidates[idx], idx, path)
        # backtrack
        path.pop()



        