from typing import List


class Solution:
    # Approach: String Concatenation Path
    # TC: O(4^n), SC: O(n) + O(k) for recursion and result

    def addOperators(self, num: str, target: int) -> List[str]:
        def helper(pivot, calc, tail, path):
            if pivot == len(num):
                if calc == target:
                    result.append(path)
                return

            for i in range(pivot, len(num)):
                if i > pivot and num[pivot] == "0":  # skip leading zeros
                    break

                curr_str = num[pivot : i + 1]
                curr = int(curr_str)

                if pivot == 0:
                    helper(i + 1, curr, curr, curr_str)
                else:
                    helper(i + 1, calc + curr, curr, path + "+" + curr_str)
                    helper(i + 1, calc - curr, -curr, path + "-" + curr_str)
                    helper(
                        i + 1,
                        calc - tail + tail * curr,
                        tail * curr,
                        path + "*" + curr_str,
                    )

        result = []
        helper(0, 0, 0, "")
        return result

    # Alternate Approach: Backtracking using Path List
    # TC: O(4^n), SC: O(n) + O(k)
    def addOperatorsBacktrack(self, num: str, target: int) -> List[str]:
        def helper(pivot, calc, tail, path):
            if pivot == len(num):
                if calc == target:
                    result.append("".join(path))
                return

            for i in range(pivot, len(num)):
                if i > pivot and num[pivot] == "0":
                    break

                curr_str = num[pivot : i + 1]
                curr = int(curr_str)
                len_before = len(path)

                if pivot == 0:
                    path.append(curr_str)
                    helper(i + 1, curr, curr, path)
                    path[:] = path[:len_before]
                else:
                    path.extend(["+", curr_str])
                    helper(i + 1, calc + curr, curr, path)
                    path[:] = path[:len_before]

                    path.extend(["-", curr_str])
                    helper(i + 1, calc - curr, -curr, path)
                    path[:] = path[:len_before]

                    path.extend(["*", curr_str])
                    helper(i + 1, calc - tail + tail * curr, tail * curr, path)
                    path[:] = path[:len_before]

        result = []
        helper(0, 0, 0, [])
        return result


sol = Solution()
print(sol.addOperators("123", 6))
print(sol.addOperatorsBacktrack("123", 6))
