package com.mps2022.laboratorio2;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.util.Deque;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {

    DequeNode<Integer> node;

    @BeforeEach
    public void setup(){
        node = new DequeNode<Integer>(0,1,2);
    }

    @AfterEach
    public void finish(){
        node = null;
    }

    @Test
    public void getItemDontReturnNull(){
        int expectedValue = 0;
        int obtainedValue =  node.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void getNextDontReturnNull(){
        int expectedValue = 1;
        int obtainedValue =  node.getNext();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void getPreviousDontReturnNull(){
        int expectedValue = 2;
        int obtainedValue =  node.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void isFirstNodeReturnFalseIfPreviousNotNull(){
        assertFalse(node.isFirstNode() == true);
    }

}
