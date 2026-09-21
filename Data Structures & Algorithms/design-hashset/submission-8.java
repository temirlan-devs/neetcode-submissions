class MyHashSet {

    public static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
            this.next = null;
        }
    }

    int size;
    ListNode[] set;

    public MyHashSet() {
        this.size = 10000;
        this.set = new ListNode[this.size];

        for (int i = 0; i < this.size; i++) {
            this.set[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        ListNode curr = this.set[key % this.size];

        while (curr.next != null) {
            if (curr.next.key == key) return;
            curr = curr.next;
        }
        curr.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode curr = this.set[key % this.size];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode curr = this.set[key % this.size];

        while (curr.next != null) {
            if (curr.next.key == key) return true;
            curr = curr.next;
        }
        return false;
    }
}

/*
Time complexity: O(n/k) in average
Space complexity: O(m + n)

n is the number of keys
k is the size of sets
m is the number of unique keys
*/

/*

add(1)
index = 1
curr = 0
0 -> 1
set - 1: 0 -> 1

add(2)
index = 2
curr = 0
0 -> 2
set - 1: 0 -> 1; 2: 0 -> 2

contains(1)
index = 1 - 0 -> 1
curr = 0
return true

add(10001)
index = 1 - 0 -> 1
curr = 0
after while loop curr = 1
1.next = 10001
set - 1: 0 -> 1 -> 10001; 2: 0 -> 2

add(1)
index = 1 - 0 -> 1 -> 10001
curr = 0
return in while loop cause it contains

remove(1)
index = 1 - 0 -> 1 -> 10001
curr = 0
in while loop: 0.next = 1001. As a result index = 1 - 0 -> 10001
return

contains(3)
index = 3
curr = 0
return false

*/
