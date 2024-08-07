class Solution:
    """
    Time Complexity: O(4^n)
    Space Complexity: O(4^n)
    """
    def addOperators(self, num: str, target: int) -> List[str]:
        if num is None or len(num) == 0:
            return []

        self.result = []
        self.recurse(num, target, 0, 0, 0, "") # index, calc, tail, expression
        return self.result

    def recurse(self, num: str, target: int, index: int, calc: int, tail: int, path: str) -> None:
        # Base case:
        if index == len(num):
            if calc == target:
                self.result.append(path)
            return
        
        # Logic
        for i in range(index, len(num)):
            # Skip leading zero number
            if num[index] == '0' and i != index:
                continue
            
            curr = int(num[index:i + 1])
            
            if index == 0:
                # First number, pick it without any operator
                self.recurse(num, target, i + 1, curr, curr, path + str(curr))
            else:
                # Recurse call for '+' operator
                self.recurse(num, target, i + 1, calc + curr, curr, path + '+' + str(curr))
                
                # Recurse call for '-' operator
                self.recurse(num, target, i + 1, calc - curr, -curr, path + '-' + str(curr))
                
                # Recurse call for '*' operator
                self.recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + '*' + str(curr))

