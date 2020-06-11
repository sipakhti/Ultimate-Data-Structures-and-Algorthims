package Queues;

import javax.swing.plaf.FontUIResource;

class FullQueueException extends RuntimeException {
    public FullQueueException(){
        super("Sorry the Queue is full");
    }
}

class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(){
        super("Sorry the Queue is empty");
    }
}