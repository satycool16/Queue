package com.datastructure;

public class Queue{

    private int maxSize = 4;
    private int front;
    private int rear;
    private int size;
    private int queueArr[];

    private final Object lock = new Object();

    public Queue() {
        front=0;
        rear=-1;
        size=0;
        queueArr=new int[maxSize];
    }

    public Queue(int size) {
        front=0;
        rear=-1;
        this.size=0;
        maxSize=size;
        queueArr=new int[maxSize];
    }


    public void enqueue(int element) throws QueueFullException,InterruptedException {
        synchronized (lock) {
            if (checkFull()) {
                throw new QueueFullException("Queue is Full");
            }

            rear = (rear + 1) % (maxSize);
            queueArr[rear] = element;
            size++;
            lock.notify();
        }
    }

    public int dequeue() throws QueueEmptyException,InterruptedException {
        synchronized (lock) {
            int element;
            if (checkEmpty()) {
                throw new QueueEmptyException("Queue is Empty");
            }

            element = queueArr[front];
            front = (front + 1) % (maxSize);
            size--;
            lock.notify();
            return element;
        }
    }

    int front() throws QueueEmptyException
    {
        if(checkEmpty())
        {
            throw new QueueEmptyException("Queue is Empty");
        }
        return queueArr[front];
    }

    int rear() throws QueueEmptyException
    {
        if(checkEmpty())
        {
            throw new QueueEmptyException("Queue is Empty");
        }
        return queueArr[rear];
    }

    public void print()
    {
        if(checkEmpty())
        {
            System.out.println("Queue is Empty");
        }
        else
        {
            int length = size;
            int itr = front;

            while(length > 0)
            {
                System.out.println(queueArr[itr++%maxSize]);
                length--;
            }
        }
    }

    public void increaseMaxSize(){
        int newMaxSize = maxSize*2;
        int newQueueArr[] = new int[newMaxSize];

        int i = 0;
        if(!checkEmpty())
        {
            int length = size;
            int itr = front;
            while(length>0)
            {
                newQueueArr[i++] = queueArr[itr++%maxSize];
                length--;
            }
        }
        front = 0;
        rear = i-1;
        maxSize = newMaxSize;
        queueArr = newQueueArr;
    }

    public boolean checkEmpty() {
        return (size == 0);
    }

    public boolean checkFull() {
        return size == maxSize;
    }

    public int getSize(){
        return size;
    }

    public int getMaxSize(){
        return maxSize;
    }
}