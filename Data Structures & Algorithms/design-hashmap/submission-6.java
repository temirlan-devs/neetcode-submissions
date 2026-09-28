class MyHashMap {

    public static class ListNode {
        int key;
        int val;
        ListNode next;
        
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size;
    ListNode[] map;

    public MyHashMap() {
        this.size = 10000;
        this.map = new ListNode[this.size];

        for (int i = 0; i < this.size; i++) {
            this.map[i] = new ListNode(0, 0);
        }
    }
    
    public void put(int key, int value) {
        int index = key % this.size;
        ListNode curr = this.map[index];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key, value);

    }
    
    public int get(int key) {
        int index = key % this.size;
        ListNode curr = this.map[index];

        while (curr.next != null) {
            if (curr.next.key == key) {
                return curr.next.val;
            }
            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = key % this.size;
        ListNode curr = this.map[index];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/*

Time complexity: O(n/k) where n is the number of calls and k is the size (10000 here)
Space complexity: O(k + m) -> where m is the number of unique keys


put(1, 1)
cur = map[1]
0.next = (1, 1)
map - 1: (0, 0) -> (1, 1)

put(2, 2)
cur = map[2] = (0, 0)
(0, 0).next = (2, 2)
map - 1: (0, 0) -> (1, 1); 2: (0, 0) -> (2, 2)

get(1)
cur = map[1] = (0, 0)
while -> return 1

put(1, 5)
cur = map[1] = (0, 0)
while -> 0.next == 1 -> 1.val = 5 -> return
map - 1: (0, 0) -> (1, 5); 2: (0, 0) -> (2, 2)

remove(2)
cur = map[2] = (0, 0)
while -> 0.next.key == 2 -> 0.next = null -> return
map: 1: (0, 0) -> (1, 5); 2: (0, 0)




*/

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */