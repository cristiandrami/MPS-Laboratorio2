package com.mps2022.laboratorio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/***
 * This is the testing class of DoubleLinkedListQueueInteger
 *
 *
 *
 * @author Cristian Domenico Dramisino
 */
public class DoubleLinkedListQueueIntegerTest {
    private DoubleLinkedListQueueInteger linkedList;

    @BeforeEach
    public void setup(){
        linkedList=new DoubleLinkedListQueueInteger();
    }

    @Nested
    class AppendingTests{
        @Test
        @DisplayName("runtime exception if append a null node")
        public void shouldEraseARuntimeExceptionIfAppendANullNode(){
            DequeNode<Integer> nodeToAppend= null;
            assertThrows(RuntimeException.class, ()-> linkedList.append(nodeToAppend));

        }

        @Test
        @DisplayName("list size will increase if append a node")
        public void shouldIncreaseSizeIfAppendANode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(nodeToAppend);

            int expectedValue=1;
            int obtainedValue=linkedList.size();

            assertEquals(expectedValue, obtainedValue);

        }

    }

}
