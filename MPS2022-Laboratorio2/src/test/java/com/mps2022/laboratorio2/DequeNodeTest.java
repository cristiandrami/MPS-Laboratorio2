package com.mps2022.laboratorio2;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.util.Deque;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {

    DequeNode<Integer> node;
    DequeNode<Integer> next = null;
    DequeNode<Integer> previous = null;

    @BeforeEach
    public void setup(){
        node = new DequeNode<Integer>(0, next, previous);
    }

    @AfterEach
    public void finish(){
        node = null;
    }
    @Nested
    class TestingGetters {
        @Test
        public void getItemDontReturnNull() {
            int expectedValue = 0;
            int obtainedValue = node.getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        public void getNextDontReturnNull() {
            next.setItem(1);
            int expectedValue = 1;
            int obtainedValue = node.getNext().getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        public void getPreviousDontReturnNull() {
            node.getPrevious().setItem(2);
            int expectedValue = 2;
            int obtainedValue = node.getPrevious().getItem();

            assertEquals(expectedValue, obtainedValue);
        }
    }

    @Nested
    class TestingIsFirstIsLast {
        @Test
        public void isFirstNodeReturnFalseIfPreviousNotNull() {
            assertTrue(node.isFirstNode() == true);
        }

        @Test
        public void isLastNodeReturnFalseIfNextNotNull() {
            assertTrue(node.isLastNode() == true);
        }

        @Test
        public void isFirstNodeReturnTrueIfPreviousNull() {

            boolean expectedValue = true;
            boolean obtainedValue = node.isFirstNode();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        public void isLastNodeReturnTrueIfNextNull() {
            node.setNext(null);
            boolean expectedValue = true;
            boolean obtainedValue = node.isLastNode();

            assertEquals(expectedValue, obtainedValue);
        }
    }
    @Nested
    class TestingSets {
        @Test
        public void setItemSetsValueAndUpdatesIt() {
            node.setItem(5);
            int expectedValue = 5;
            int obtainedValue = node.getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        public void setPreviousSetsValueAndUpdatesIt() {
            previous= new DequeNode<Integer>(5, next, previous);
            node.setPrevious(previous);
            int expectedValue = 5;
            int obtainedValue = node.getPrevious().getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        public void setNextSetsValueAndUpdatesIt() {
            next= new DequeNode<Integer>(5, next, previous);
            node.setNext(next);
            int expectedValue = 5;
            int obtainedValue = node.getNext().getItem();

            assertEquals(expectedValue, obtainedValue);
        }
    }

}
