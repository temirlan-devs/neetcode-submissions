class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        sdict, tdict = {}, {}

        for i in range(len(s)):
            sdict[s[i]] = sdict.get(s[i], 0) + 1
            tdict[t[i]] = tdict.get(t[i], 0) + 1

        return sdict == tdict