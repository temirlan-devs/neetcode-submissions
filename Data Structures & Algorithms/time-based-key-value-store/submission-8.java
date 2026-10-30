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
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry (value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return ""; 
        List<Entry> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;

        String res = "";

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
