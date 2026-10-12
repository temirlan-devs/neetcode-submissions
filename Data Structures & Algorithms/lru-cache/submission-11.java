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

    HashMap<Integer, ListNode> map;
    ListNode lru;
    ListNode mru;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.lru = new ListNode(0, 0);
        this.mru = new ListNode(0, 0);
        this.lru.next = this.mru;
        this.mru.prev = this.lru;
        this.capacity = capacity;
    }

    public void remove(ListNode node){
        ListNode prv = node.prev;
        ListNode nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    public void insert(ListNode node){
        ListNode prv = mru.prev;
        prv.next = node;
        node.prev = prv;
        node.next = mru;
        mru.prev = node;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode curNode = map.get(key);
            remove(curNode);
            insert(curNode);
            return curNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        ListNode newNode = new ListNode(key, value);
        insert(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {
            ListNode nodeToRemove = lru.next;
            remove(nodeToRemove);
            map.remove(nodeToRemove.key);
        }
    }
}
