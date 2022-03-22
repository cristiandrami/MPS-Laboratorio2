package com.mps2022.laboratorio2;

import java.util.Comparator;

public interface DoubleEndedQueue<T> {
    // Basic operations
    void append(DequeNode<T> node) ;
    void appendLeft(DequeNode<T> node) ;
    void deleteFirst() ;
    void deleteLast() ;
    DequeNode<T> peekFirst() ;
    DequeNode<T> peekLast() ;
    int size() ;

    // Complex operations
    // (Estas operaciones se incluirán más adelante para ser realizadas en la segunda
    // sesión de laboratorio de esta práctica.)

    DequeNode<T> find (T item) ;
    DequeNode<T> getAt(int position);
    void delete(DequeNode<T> node) ;
    void sort( Comparator<T> comparator) ;

}