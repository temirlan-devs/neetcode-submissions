class Solution:
    def isValid(self, s: str) -> bool:
        map = {"(": ")", "{": "}", "[": "]"}

        stack = []

        for c in s:
            if c in map.keys():
                stack.append(c)
                print(stack)
            else:
                if not stack: return False
                if c != map.get(stack[-1]): return False
                stack.pop()

        return True if not stack else False
