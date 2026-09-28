class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    ListNode (int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, ListNode> map;
    ListNode start;
    ListNode end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.start = new ListNode(0, 0);
        this.end = new ListNode(0, 0);
        this.start.next = this.end;
        this.end.prev = this.start;
    }

    public void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(ListNode node) {
        ListNode prev = this.end.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.end;
        this.end.prev = node;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
        }
        
        ListNode newNode = new ListNode(key, value);
        insert(newNode);
        map.put(key, newNode);
        
        if (map.size() > this.capacity) {
            ListNode lru = this.start.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
