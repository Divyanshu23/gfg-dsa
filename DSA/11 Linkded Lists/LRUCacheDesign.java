import java.util.HashMap;

public class LRUCacheDesign {
    public static void main (String[] args) {
        LRUCache cache = new LRUCache(2); 

		cache.set(1, 10); 
		cache.set(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1).value);

        cache.set(3, 30); 

		System.out.println("Value for the key: 2 is " + 
				cache.get(2));
        System.out.println("Value for the key: 1 is " + 
				cache.get(1).value);

		// removing key 1 and store a key (4) with value 40 in the cache. 
		cache.set(4, 40);
		System.out.println("Value for the key: 1 is " + 
			cache.get(1).value); // returns -1 (not found) 
		System.out.println("Value for the key: 3 is " + 
						cache.get(3)); // returns 30 
		System.out.println("Value for the key: 4 is " + 
						cache.get(4).value); // return 40 
    }

    private static class LRUCache {

        HashMap<Integer, Node> hm;
        Node head;
        int cap;
        int curr;

        public LRUCache(int cap) {
            this.cap = cap;
            curr = 0;
            hm = new HashMap<>();
            head = null;
        }

        public Node get(int key) {
            if(hm.containsKey(key)) {
                if(head.key == key) return head;

                Node node = hm.get(key);
                node.prev.next = node.next;
                if(node.next != null) node.next.prev = node.prev;

                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
                return head;
            } else {
                System.out.println("Value does not exist in Cache. Returning null");
                return null;
            }
        }

        public void set(int key, int value) {
            if(hm.containsKey(key)) {
                Node node = hm.get(key);
                node.value = value;
                if(node == head) return;

                node.prev.next = node.next;
                if(node.next != null) node.next.prev = node.prev;

                node.prev = null;
                node.next = head;
                head = node;
            } else {
                Node node = new Node(key, value);
                if(isFull()) {
                    if(cap == 1) {
                        hm.remove(head.key);
                        hm.put(node.key, node);
                        head = node;
                        return;
                    }
                    Node temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    hm.remove(temp.key);
                    // System.out.println(temp.value);
                    temp.prev.next = null;
                    node.next = head;
                    head.prev = node;
                    head = node;
                    hm.put(node.key, node);
                } else {
                    node.next = head;
                    if(head != null) head.prev = node;
                    head = node;
                    hm.put(key, node);
                    curr++;
                }
            }
        }

        private boolean isFull() {
            return curr == cap;
        }
    }

    private static class Node {
        Node next;
        Node prev;
        int key;
        int value;
    
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
