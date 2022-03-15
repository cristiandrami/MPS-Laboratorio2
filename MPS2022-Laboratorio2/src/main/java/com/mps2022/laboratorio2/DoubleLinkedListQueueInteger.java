package com.mps2022.laboratorio2;

public class DoubleLinkedListQueueInteger implements DoubleEndedQueue<Integer>{
    private DequeNode head=null;
    private DequeNode tail=null;
    private int size=0;

    @Override
    public void append(DequeNode node) {
        if(node==null){
            throw new RuntimeException("node is null, cannot append it");
        }
        if(head == null) {
            head = tail = node;
            head.setPrevious(null);
            tail.setNext(null);
        }
        else {

            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
            tail.setNext(null);
        }

        size++;


    }

    @Override
    public void appendLeft(DequeNode node) {

        if(node==null){
            throw new RuntimeException("node is null, cannot append it");
        }
        if(head == null ) {
            head =tail= node;
        }if(head==tail){
            head.setPrevious(node);
            node.setNext(head);
            head = node;
            tail.setPrevious(head);
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if(head==null){ return;}
        else if(head==tail){
            head=tail=null;
        }else{
            head =(DequeNode) head.getNext();
            if(this.head != null)
                head.setPrevious(null);

        }
        if(size!=0)
            size--;
    }

    @Override
    public void deleteLast() {
        if(tail==null){ return;}
        else if(head==tail){
            head=tail=null;
        }else{
            tail =(DequeNode) tail.getPrevious();
            if(tail != null)
                head.setNext(null);

        }
        if(size!=0)
            size--;
    }

    @Override
    public DequeNode peekFirst() {
        return head;
    }

    @Override
    public DequeNode peekLast() {
        return tail;
    }

    @Override
    public int size() {
        return size;
    }
}
