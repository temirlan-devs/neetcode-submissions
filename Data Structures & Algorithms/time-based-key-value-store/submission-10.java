class TimeMap {

    private static class Entry {
        String value;
        int timestamp;

        Entry (String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Entry>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    // O(1) - time
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry (value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";  // O(1) - time
        List<Entry> list = map.get(key); // O(1) - time

        int l = 0;
        int r = list.size() - 1;

        String res = "";

        // O(logn) - time, where n is the number of values for a key
        while (l <= r) {
            int m = l + (r - l) / 2;

            Entry entry = list.get(m);

            if (entry.timestamp > timestamp) r = m - 1;
            else {
                res = entry.value;
                l = m + 1;
            }
        }

        return res;
    }
}

/*
Time complexity: O(1) - set. O(logn) - get
Space complexity:
Map holds m keys and each key has n values -> O(m * n) - more loose option

Map holds m keys and total number of values is k Since m <= k, every key has at least one value-> O(k) - tighter option


*/

/*

Test

set(A, H, 1)
map: A - {[H, 1]}

set(A, K, 5)
map: A - {[H, 1], [K, 5]}

set(A, L, 11)
map: A - {[H, 1], [K, 5], [L, 11]}

set(A, M, 13)
map: A - {[H, 1], [K, 5], [L, 11], [M, 13]}

set(B, Y, 1)
map: A - {[H, 1], [K, 5], [L, 11], [M, 13]}; B - {[Y, 1]}

set(B, X, 8)
map: A - {[H, 1], [K, 5], [L, 11], [M, 13]}; B - {[Y, 1], [X, 8]}

set(C, I, 3}
map: A -{[H, 1], [K, 5], [L, 11], [M, 13]}; B - {[Y, 1], [X, 8]}; C - {[I, 3]}

get(D, 1)
return ""

get(A, 1)
map: A - {[H, 1], [K, 5], [L, 11], [M, 13]}
l = 0 -> 1
r = 3 -> 0
m = 1 -> 0
res = H

return H

get(A, 8)
map: A - {[H, 1], [K, 5], [L, 11], [M, 13]}
l = 0 -> 2
r = 3 -> 1
m = 1 -> 2
res = K

return K

get(A, 12)
map: A - {[H, 1], [K, 5], [L, 11], [M, 13]}
l = 0 -> 2 -> 3
r = 3 -> 2
m = 1 -> 2 -> 3
res = K -> L

return L

get(B, 10)
map: B - {[Y, 1], [X, 8]}
l = 0 -> 1 -> 2
r = 1
m = 0 -> 1
res = Y -> X

return X

get(C, 1)
map: C - {[I, 3]}
l = 0
r = 0 -> -1
m = 0

return ""



*/
