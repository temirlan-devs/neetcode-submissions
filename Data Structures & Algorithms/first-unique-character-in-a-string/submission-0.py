class Solution:
    def firstUniqChar(self, s: str) -> int:
        dict = {}

        for char in s:
            dict[char] = dict.get(char, 0) + 1

        for char in s:
            if dict[char] == 1:
                return s.index(char) 
            
        return -1
        