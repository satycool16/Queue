package com.client;

import com.datastructure.Queue;

public class QueueThreadClient {
    public static void main(String[] args) {

        Queue queue = new Queue(4);
        final int numberOfThreads = 5;

        for (int i = 1; i <= numberOfThreads; ++i) {

            Thread thread1 = new Thread(new Producer(queue));
            Thread thread2 = new Thread(new Consumer(queue));

            thread1.start();
            thread2.start();
        }
    }
}