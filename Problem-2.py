# Approach
# Maintain the sum if the importance of all the employee subordinates

# Complexities
#Time: O(N)
#Space O(N)



from typing import List


class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates



class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashMap = {}
        result = 0
        for employee in employees:
            hashMap[employee.id] = employee

        queue = []
        queue.append(hashMap[id])

        while queue:
            curremp = queue.pop(0)
            result += curremp.importance
            for subordinates in curremp.subordinates:
                queue.append(hashMap[subordinates])
        return result
