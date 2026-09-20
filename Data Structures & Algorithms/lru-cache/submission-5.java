class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left; 
    }
    
    public void remove(Node node) {
        Node prv = node.prev;
        Node nxt = node.next;

        prv.next = nxt;
        nxt.prev = prv;
    }

    public void insert(Node node) {
        Node prv = this.right.prev;
        prv.next = node;
        node.prev = prv;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);

        if (map.size() > this.capacity) {
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

/* 

Test

Case 1:

put(1, 10)
L->1->M
map: 1->10

get(1)
L->1->M
return 10

put(2, 20)
L->1->2->M
map: 1->10, 2->20

put(3, 30)
L->1->2->3->M
map: 1->10, 2->20, 3->3-

map.size() > capacity
L->2->3->M
map: 2->20, 3->30


get(2)
L->3->2->M
return 20

map.put(4, 40)
L->3->2->4->M
map: 2->20, 3->30, 4->40

map.size() > capacity
L->2->4->M
map: 2->20, 4->40

map.put(4, 41)
L->2->M
l->2->4->M
map: 2->20, 4->41



*/
