class TimeMap:

    def __init__(self):
        self.dict = {}
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.dict.setdefault(key, []).append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.dict:
            return ""

        l, r = 0, len(self.dict[key]) - 1
        res = ""

        while l <= r:
            m = l + (r - l) // 2

            entry = self.dict[key]

            if entry[m][1] <= timestamp:
                l = m + 1
                res = entry[m][0]
            else:
                r = m - 1

        return res
        
