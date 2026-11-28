class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for t in tokens:
            if t == '+':
                stack.append(stack.pop() + stack.pop())
            
            elif t == '-':
                temp = stack.pop()
                stack.append(stack.pop() - temp)
            
            elif t == '*':
                stack.append(stack.pop() * stack.pop())

            elif t == '/':
                temp = stack.pop()
                stack.append(int(stack.pop() / temp))

            else:
                stack.append(int(t))

        
        return stack.pop()