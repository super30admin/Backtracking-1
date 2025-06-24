###
# Approach (Recursion with 0/1 Choice and Backtracking):
# We recursively explore two options at each index:
#   1. Not choose the current number → move to the next index
#   2. Choose the current number → reduce the target and stay at the same index
#
# For each recursive call:
#   - If target becomes 0: we found a valid combination
#   - If index exceeds array or target < 0: return (dead end)
# Backtracking is done by popping the last added number after each call.
#
# Time Complexity: O(2^(target + n)) in the worst case (brute-force tree)
# Space Complexity: O(target) for recursion stack and path
###
###
# Approach (For-Loop Based Recursion with Backtracking):
# We iterate from the pivot index to the end of the candidates.
# At each step, we:
#   - Choose a number, reduce the target, and recurse from the same index (unlimited use)
#   - Backtrack by popping the number after recursion
#
# If the target becomes 0: valid combination found.
# If the target < 0: we back out.
#
# Time Complexity: O(2^(target + n)) in the worst case
# Space Complexity: O(target) for recursion and path stack
###

class Solution:
    def combinationSum_recursion01(self, candidates, target):
        res = []
        def helper(idx, path, tg):
            if tg == 0:
                res.append(path[:])
                return
            if idx == len(candidates) or tg < 0:
                return
            helper(idx+1, path, tg)
            path.append(candidates[idx])
            helper(idx, path, tg-candidates[idx])
            path.pop()
        helper(0, [], target)
        return res
    
    def combinationSum_forloop(self, candidates, target):
        res = []
        def helper(pivot, path, tg):
            #base
            if tg == 0:
                res.append(path[:])
                return
            if tg < 0: return
            
            # logic
            for i in range(pivot, len(candidates)):
                #action
                path.append(candidates[i])
                #recurse
                helper(i, path, tg-candidates[i])
                #backtrack
                path.pop()
        helper(0, [], target)
        return res

def main():
    sol = Solution()

    # Test Case 1
    candidates = [2, 3, 6, 7]
    target = 7
    print("Recursion 0-1:", sol.combinationSum_recursion01(candidates, target))
    print("For-loop:", sol.combinationSum_forloop(candidates, target))

    # Test Case 2
    candidates = [2, 3, 5]
    target = 8
    print("Recursion 0-1:", sol.combinationSum_recursion01(candidates, target))
    print("For-loop:", sol.combinationSum_forloop(candidates, target))

    # Test Case 3
    candidates = [2]
    target = 1
    print("Recursion 0-1:", sol.combinationSum_recursion01(candidates, target))
    print("For-loop:", sol.combinationSum_forloop(candidates, target))

main()
