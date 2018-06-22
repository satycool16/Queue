package com.datastructure;

public class QueueFullException extends Exception
{
    QueueFullException(String message)
    {
        super(message);
    }

    QueueFullException()
    {
       super();
    }
}
