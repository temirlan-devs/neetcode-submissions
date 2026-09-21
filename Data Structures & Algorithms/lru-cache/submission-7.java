class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new ListNode(0, 0);
        this.tail = new ListNode(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void remove(ListNode node) {
        ListNode prv = node.prev;
        ListNode nxt = node.next;

        prv.next = nxt;
        nxt.prev = prv;
    }

    public void insert(ListNode node) {
        ListNode prv = this.tail.prev;

        prv.next = node;
        node.prev = prv;
        node.next = this.tail;
        this.tail.prev = node;
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)) {
            ListNode node = this.map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            ListNode node = this.map.get(key);
            remove(node);
        }

        ListNode newNode = new ListNode(key, value);
        insert(newNode);
        this.map.put(key, newNode);

        if (map.size() > this.capacity) {
            ListNode lru = this.head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
