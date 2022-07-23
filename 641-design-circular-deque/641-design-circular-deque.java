class DoublyLinkedNode {
    DoublyLinkedNode next, prev;
    int data;
    
    DoublyLinkedNode(int val){
        data = val;
    }
}

class MyCircularDeque {
    
    DoublyLinkedNode head, tail;
    int size, capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        
        head = new DoublyLinkedNode(-1);
        tail = new DoublyLinkedNode(-1);
        head.prev = tail;
        tail.next = head;
    }
    
    public boolean insertFront(int value) {
        DoublyLinkedNode temp = new DoublyLinkedNode(value);
        
        if(!isFull()){
            temp.prev = head.prev;
            head.prev.next = temp;
            temp.next = head;
            head.prev = temp;
            size++;
            return true;
        } return false;
    }
    
    public boolean insertLast(int value) {
        
        DoublyLinkedNode temp = new DoublyLinkedNode(value);
        
        if(!isFull()){
            
            temp.next = tail.next;
            tail.next.prev = temp;
            temp.prev = tail;
            tail.next = temp;
            size++;
            return true;
        } return false;
    }
    
    public boolean deleteFront() {
        if(!isEmpty()){
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
            size--;
            return true;
        } return false;
    }
    
    public boolean deleteLast() {
        if(!isEmpty()){
            tail.next.next.prev = tail;
            tail.next = tail.next.next;
            size--;
            return true;
        } return false;
    }
    
    public int getFront() {
        return head.prev.data;
    }
    
    public int getRear() {
        return tail.next.data;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == capacity);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */