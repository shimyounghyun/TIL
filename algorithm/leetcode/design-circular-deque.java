class MyCircularDeque {
    
    int[] data;
    int size;
    int front;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.data = new int[k];
        this.size = 0;
        this.front = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        front = (front -1 + data.length) % data.length;
        data[front] = value;
        this.size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        
        data[(front+size)%data.length] = value;
        this.size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        front = (front + 1) % data.length;
        this.size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        this.size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty())
            return -1;
        return data[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty())
            return -1;
        return data[(front+size-1)%data.length];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size == data.length;
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
