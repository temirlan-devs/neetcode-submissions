class MyHashSet {

    public static class ListNode {
        int key;        
        ListNode next;

        ListNode (int key) {
            this.key = key;
        }
    }

    int size;
    ListNode[] map;

    public MyHashSet() {
        this.size = 10000;
        this.map = new ListNode[this.size];

        for (int i = 0; i < this.size; i++) {
            this.map[i] = new ListNode(0);
        }
        
    }
    
    public void add(int key) {
        int index = key % this.size;

        ListNode curr = map[index];

        while (curr.next != null) {
            if (curr.next.key == key) {
                return;
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key);
    }
    
    public void remove(int key) {
        int index = key % this.size;

        ListNode curr = map[index];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int index = key % this.size;

        ListNode curr = map[index];

        while (curr.next != null) {
            if (curr.next.key == key) {
                return true;
            }
            curr = curr.next;
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