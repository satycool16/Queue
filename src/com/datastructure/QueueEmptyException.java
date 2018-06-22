package com.datastructure;

public class QueueEmptyException extends Exception
{
    QueueEmptyException(String message)
    {
        super(message);
    }

    QueueEmptyException()
    {
        super();
    }
}
