//Defining a Doubly Linked List
class Node {
    Node next;
    Node prev;
    int val;
    int key;
    
    Node(int key, int val){
        this.val = val;
        this.key = key;
    }
}

class LRUCache {

    private HashMap<Integer, Node> cache = new HashMap<>();
    private Node head, tail;
    int capacity, count;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }
    
    //to delete a Given Node
    public void deleteNode(Node node){
        
        Node prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;
    }
    
    //to add a Given Node to Head
    public void addToHead(Node node){
        
        Node curr = node;
        
        curr.next = head.next;
        head.next.prev = curr;
        curr.prev = head;
        head.next = curr;
    }
    
    public int get(int key) {
        
        if(cache.get(key) != null){
            Node node = cache.get(key);
            int result = node.val;
            deleteNode(node);
            addToHead(node);
            
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(cache.get(key) != null){
            Node node = cache.get(key);
            node.key = key;
            node.val = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            
            if(count < capacity){
                count++;
                addToHead(node);
            } else {
                cache.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */