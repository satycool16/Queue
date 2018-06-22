package com.client;

import com.datastructure.Queue;
import com.datastructure.QueueEmptyException;

public class Consumer implements Runnable {

    private Queue queue;
    private int count = 2;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < count; ++i) {
                int element = queue.dequeue();
                System.out.println(Thread.currentThread().getName() + " Dequeued:" + element);
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println(Thread.currentThread().getName()+" Exception:"+ex.getMessage());
        }
        catch (QueueEmptyException ex)
        {
            System.out.println(Thread.currentThread().getName()+" Exception:"+ex.getMessage());
        }
    }
}