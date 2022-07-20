class Node {
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}

class MyCircularQueue {
    
    private Node head, tail;
    int size, capacity;
    
    public MyCircularQueue(int k) {
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            Node temp = new Node(value);
            if(size == 0){
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = tail.next;
            }
            size++;
            return true;
        } return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            head  = head.next;
            size--;
            return true;
        } return false;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        
        return head.data;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        
        return tail.data;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == capacity);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */