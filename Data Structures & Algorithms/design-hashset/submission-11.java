class MyHashSet {

    public static class ListNode {
        int key;
        ListNode next;
        ListNode (int key) {
            this.key = key;
        }
    }

    int n;
    ListNode[] hashSet;

    public MyHashSet() {
        this.n = 10000;
        this.hashSet= new ListNode[this.n];
        for (int i = 0; i < this.n; i++) {
            this.hashSet[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        int index = key % n;
        ListNode cur = hashSet[index];

        while (cur.next != null) {
            if (cur.next.key == key) return;
            cur = cur.next;
        }
        cur.next = new ListNode(key);
    }
    
    public void remove(int key) {
        int index = key % n;
        ListNode cur = hashSet[index];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
    
    public boolean contains(int key) {
        int index = key % n;
        ListNode cur = hashSet[index];
        while (cur.next != null) {
            if (cur.next.key == key) return true;
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