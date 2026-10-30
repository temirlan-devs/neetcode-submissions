class TimeMap {

    public static class ListNode {
        String value;
        int timestamp;

        ListNode (String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<ListNode>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new ListNode (value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return ""; 
        List<ListNode> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;



        while (l <= r) {
            int m = l + (r - l) / 2;

            int t = list.get(m).timestamp;
            if (t == timestamp) return list.get(m).value;

            if (t > timestamp) r = m - 1;
            else l = m + 1;
        }

        return r >= 0 ? list.get(r).value : "";
    }
}
