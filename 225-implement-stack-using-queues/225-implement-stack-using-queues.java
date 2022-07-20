class MyStack {
    
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        
        if(q1.isEmpty() == false){
            while(q1.size() != 1){
                q2.add(q1.poll());
            }
            //Return the last element of the queue which would be popped first in case of a Stack DS
            int popElement = q1.poll();
            
            //Load the elements back to the original Queue
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
            return popElement;
        } 
        
        return -1;
    }
    
    public int top() {
        
        if(q1.isEmpty() == false){
            while(q1.size() != 1){
                q2.add(q1.poll());
            }
            //Return the last element of the queue which would be Top first in case of a Stack DS
            int topElement = q1.peek();
            //adding the top element 
            q2.add(q1.poll());
            
            //Load the elements back to the original Queue
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
            return topElement;
        } 
        
        return -1;
    }
    
    public boolean empty() {
        return (q1.isEmpty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */