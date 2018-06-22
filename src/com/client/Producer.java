package com.client;

import com.datastructure.Queue;
import com.datastructure.QueueFullException;
import java.util.Random;

public class Producer implements Runnable {

    private Queue queue;
    private int count = 3;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < count; ++i) {
                int rand=new Random().nextInt(20);
                queue.enqueue(rand);
                System.out.println(Thread.currentThread().getName()+ " Enqueued:" + rand);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(Thread.currentThread().getName()+" Exception:"+e.getMessage());
        }
        catch (QueueFullException e)
        {
            System.out.println(Thread.currentThread().getName()+" Exception:"+e.getMessage());
        }
    }
}