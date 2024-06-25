public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public void initializeQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert " + value);
        } else {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queueArray[++rear] = value;
            nItems++;
        }
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove.");
        } else {
            int value = queueArray[front++];
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            System.out.println("Removed " + value + " from queue.");
        }
    }

    public void peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
        } else {
            System.out.println("Front element is: " + queueArray[front]);
        }
    }

    public void checkEmpty() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue is not empty.");
        }
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.initializeQueue(10);

        for (int i = 2; i <= 20; i += 2) {
            queue.insert(i);
        }

        System.out.println("\nStarting to remove all elements from the queue:");

        while (!queue.isEmpty()) {
            queue.remove();
        }
    }
}
