package com.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue myqueue;
    @Test(expected = QueueFullException.class)
    public void enqueueIfQueueFull() throws Exception {
        myqueue=new Queue(1);
        myqueue.enqueue(3);
        myqueue.enqueue(4);

    }

    @Test(expected = QueueEmptyException.class)
    public void dequeueIfQueueEmpty() throws Exception {
        myqueue = new Queue(2);
        myqueue.dequeue();
        myqueue.enqueue(3);
        myqueue.enqueue(4);

    }

    @Test
    public void enqueueTest() throws Exception {
        myqueue=new Queue(2);
        assertEquals(0, myqueue.getSize());
        myqueue.enqueue(3);
        myqueue.enqueue(4);
        assertEquals(2, myqueue.getSize());
    }

    @Test
    public void dequeueTest() throws Exception {
        myqueue=new Queue(2);
        myqueue.enqueue(3);
        myqueue.enqueue(4);
        myqueue.dequeue();
        assertEquals(1, myqueue.getSize());
        myqueue.dequeue();
        assertEquals(0, myqueue.getSize());
    }

    @Test
    public void increaseMaxSize() throws Exception {
        int size=3;
        myqueue=new Queue(size);
        myqueue.increaseMaxSize();
        assertEquals(size*2,myqueue.getMaxSize());
    }

    @Test
    public void testCheckEmpty() throws Exception {
        myqueue=new Queue(3);
        myqueue.enqueue(0);
        myqueue.dequeue();
        assertEquals(true,myqueue.checkEmpty());
    }

    @Test
    public void testCheckFull() throws Exception {
        myqueue=new Queue(2);
        myqueue.enqueue(7);
        myqueue.enqueue(343);
        assertEquals(true,myqueue.checkFull());
    }

    @Test
    public void testFront() throws Exception{
        myqueue=new Queue(2);
        myqueue.enqueue(10);
        assertEquals(10,myqueue.front());
        myqueue.enqueue(25);
        myqueue.dequeue();
        assertEquals(25,myqueue.front());
    }

    @Test
    public void testRear() throws Exception{
        myqueue=new Queue(2);
        myqueue.enqueue(10);
        assertEquals(10,myqueue.rear());
        myqueue.enqueue(25);
        assertEquals(25,myqueue.rear());
    }

}