def combinationSum(candidates, target):
    result = []
    
    def backtrack(remain, comb, start):
        if remain == 0:
            # Make a deep copy of the current combination
            result.append(list(comb))
            return
        elif remain < 0:
            # Exceeded the scope, stop exploration.
            return

        for i in range(start, len(candidates)):
            # Add the number into the combination
            comb.append(candidates[i])
            # Give the current number another chance, since we can reuse the same number
            backtrack(remain - candidates[i], comb, i)
            # Backtrack, remove the number from the combination
            comb.pop()
    
    backtrack(target, [], 0)
    
    return result

candidates = [2, 3, 6, 7]
target = 7
print(combinationSum(candidates, target))
# Output: [[2, 2, 3], [7]]