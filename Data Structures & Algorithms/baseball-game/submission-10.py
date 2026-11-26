class Solution:
    def calPoints(self, operations: List[str]) -> int:
        
        mystack = []
        total = 0
        for operation in operations:
            if operation == "+":
                top = mystack.pop()
                newtop = top + mystack[(len(mystack) - 1)]
                mystack.append(top)
                mystack.append(newtop)
                total += mystack[(len(mystack) - 1)]
            elif operation == "D":
                mystack.append(mystack[(len(mystack) - 1)] * 2)
                total += mystack[(len(mystack) - 1)]
            elif operation == "C":
                total -= mystack.pop()
            else:
                mystack.append(int(operation))
                total += int(operation)
            
        return total
            
