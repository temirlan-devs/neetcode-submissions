class MyHashMap {

    public static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    ListNode[] map;

    public MyHashMap() {
        this.capacity = 10000;
        this.map = new ListNode[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            this.map[i] = new ListNode(0, 0);
        }
    }
    
    public void put(int key, int value) {
        int index = key % capacity;

        ListNode cur = map[index];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key, value);
    }
    
    public int get(int key) {
        int index = key % capacity;
        ListNode cur = map[index];

        while (cur.next != null) {
            if (cur.next.key == key) {
                return cur.next.val;
            }
            cur = cur.next;
        }

        return -1;

    }
    
    public void remove(int key) {
        int index = key % capacity;
        ListNode cur = map[index];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */