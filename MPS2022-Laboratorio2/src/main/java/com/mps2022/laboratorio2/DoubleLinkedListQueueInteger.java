package com.mps2022.laboratorio2;

import java.util.Comparator;

public class DoubleLinkedListQueueInteger implements DoubleEndedQueue<Integer>{
    private DequeNode<Integer> head=null;
    private DequeNode<Integer> tail=null;
    private int size=0;

    @Override
    public void append(DequeNode<Integer> node) {
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
    public void appendLeft(DequeNode<Integer> node) {

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
        if(head==null){ throw new RuntimeException("cannot delete first node, link is empty");}
        else if(head==tail){
            head=tail=null;
        }else{
            head = head.getNext();
            if(head != null)
                head.setPrevious(null);

        }
        if(size!=0)
            size--;
    }

    @Override
    public void deleteLast() {
        if(tail==null){ throw new RuntimeException("cannot delete first node, link is empty");}
        else if(head==tail){
            head=tail=null;
        }else{
            tail =tail.getPrevious();
            if(tail != null)
                head.setNext(null);

        }
        if(size!=0)
            size--;
    }

    @Override
    public DequeNode<Integer> peekFirst() {
        return head;
    }

    @Override
    public DequeNode<Integer> peekLast() {
        return tail;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DequeNode<Integer> find(Integer item) {
        DequeNode<Integer> tmp=head;
        while(tmp!=tail){
            if(tmp!=null){
                if(tmp.getItem().equals(item)){
                    return tmp;
                }
                tmp=tmp.getNext();
            }else{
                break;
            }

        }
        return null;
    }

    @Override
    public DequeNode<Integer> getAt(int position) {
        return null;
    }

    @Override
    public void delete(DequeNode<Integer> node) {
        DequeNode<Integer> tmp=head;
        while(tmp!=tail){
            if(tmp!=null){
                if(tmp==node){
                    DequeNode<Integer> previous=tmp.getPrevious();
                    DequeNode<Integer> next = tmp.getNext();
                    previous.setNext(next);
                    next.setPrevious(previous);
                    tmp=null;
                }
            }

        }
    }

    @Override
    public void sort(Comparator<?> comparator) {

    }
}
