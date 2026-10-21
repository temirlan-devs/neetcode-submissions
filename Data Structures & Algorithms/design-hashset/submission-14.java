class MyHashSet {

    public static class ListNode {
        int key;
        ListNode next;
        ListNode(int key) {
            this.key = key;
        }
    }

    int capacity;
    ListNode[] map;

    public MyHashSet() {
        this.capacity = 10000;
        this.map = new ListNode[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            map[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        int index = key % capacity;
        ListNode cur = map[index];

        while (cur.next != null) {
            if (cur.next.key == key) {
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key);
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
    
    public boolean contains(int key) {
        int index = key % capacity;
        ListNode cur = map[index];
        while (cur.next != null) {
            if (cur.next.key == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */