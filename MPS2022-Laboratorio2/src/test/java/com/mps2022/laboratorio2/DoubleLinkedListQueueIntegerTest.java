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
 * Test cases for DoubleLinkedListQueue
 * Appending section test cases:
 *  appending null node -> Runtime exception
 *
 * 	appending left null node -> Runtime exception
 *
 * 	appending node -> internal size increase of 1 (size++)
 *
 * 	appending node left -> internal size increase of 1 (size++)
 *
 * 	appending node left -> head have to be updated
 * 		example if we have in list 0 and append left 5, 5 will be the new head (5 0)
 *
 * 	appending node -> head have to be updated
 * 		example if we have in list 0 and append 5, 5 will be the new tail (0 5)
 *
 * 	one node in list with append() -> head has to be equal to tail
 *
 * 	one node in list with appendLeft() -> head has to be equal to tail
 *
 *
 *  Deleting section test cases:
 * 	deleting first node on empty list -> Runtime exception
 *
 * 	deleting last node on empty list -> Runtime exception
 *
 * 	deleting first node on empty list -> internal size decrease of 1 (size--)
 *
 * 	deleting last node on empty list -> internal size decrease of 1 (size--)
 *
 * 	deleting first node on list that have only one node -> head has to be updated to null
 *
 * 	deleting last node on list that have only one node -> tail has to be updated to null
 *
 * 	deleting first node on list that have only one node -> tail has to be updated to null
 *
 * 	deleting last node on list that have only one node -> head has to be updated to null
 *
 * 	deleting first node -> head have to be updated
 * 		example if we have in list 0 5 and delete first, 5 will be the new head (5)
 *
 * 	deleting last node -> tail have to be updated
 * 		example if we have in list 0 5 and delete last 5, 0 will be the new tail (0)
 *
 *
 * finding a node by his internal value -> return the right node
 *      example if we have 3 4 5 7 and use find function with 4 as parameter, he has to return the node that contain 4
 *
 * finding a node by an internal value that doesn't exist -> return null
 *      example if we have 3 4 5 7 and use find function with 10 as parameter, he has to return null
 *
 * using getAt with a position -> return the node in that position
 *      example if we have 3 4 5 7 and use getAt function with 1 as parameter, he has to return the node that contain value 4
 *
 * using getAt with a negative position -> raise a RuntimeException
 *      example if we have 3 4 5 7 and use getAt function with -1 as parameter, he has to raise a RuntimeException
 *
 * using getAt with a non-present position -> return null
 *      example if we have 3 4 5 7 and use getAt function with 6 as parameter, he has return null
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
        /***
         * support methods
         */

        //this method help us to fill the list with 3 nodes, useful for testing operations in list
        private void fillListWithNodes(DoubleLinkedListQueueInteger list){
            linkedList.append(new DequeNode<>(new Integer(1), null,null));
            linkedList.append(new DequeNode<>(new Integer(3), null,null));
            linkedList.append(new DequeNode<>(new Integer(4), null,null));
        }

        /***
         * this method helps us to append a node and then switch it on tail, replacing head
         * for example if i have only one node 0 and the use append left a node 5
         * i will have that 0 is tail and 5 is new head
         */

        private void switchHeadNode(DequeNode<Integer> newHead){
            DequeNode<Integer> previousHead= new DequeNode<>(new Integer(12), null, null);
            linkedList.append(previousHead);
            linkedList.appendLeft(newHead);

        }

        @Test
        @DisplayName("runtime exception if append a null node")
        public void shouldEraseARuntimeExceptionIfAppendANullNode(){
            DequeNode<Integer> nodeToAppend= null;
            assertThrows(RuntimeException.class, ()-> linkedList.append(nodeToAppend));

        }

        @Test
        @DisplayName("runtime exception if append left a null node")
        public void shouldEraseARuntimeExceptionIfAppendLeftANullNode(){
            DequeNode<Integer> nodeToAppend= null;
            assertThrows(RuntimeException.class, ()-> linkedList.appendLeft(nodeToAppend));

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

        @Test
        @DisplayName("head have to be updated if using appendLeft (when there is only one node)")
        public void shouldHeadHadToBeModifiedIfAppendLeftInListThatHaveOnlyOneNode(){
            DequeNode<Integer> expectedNode= new DequeNode<>(new Integer(12), null, null);
            switchHeadNode(expectedNode);

            DequeNode<Integer> obtainedNode = linkedList.peekFirst();

            assertEquals(expectedNode, obtainedNode);

        }
        @Test
        @DisplayName("head have to be updated if using appendLeft (when there are more than one node)")
        public void shouldHeadHadToBeModifiedIfAppendLeftWithOtherNodes(){
            DequeNode<Integer> expectedNode= new DequeNode<>(new Integer(12), null, null);
            fillListWithNodes(linkedList);
            linkedList.appendLeft(expectedNode);


            DequeNode<Integer> obtainedNode = linkedList.peekFirst();

            assertEquals(expectedNode, obtainedNode);

        }




        @Test
        @DisplayName("tail have to be updated if using append")
        public void shouldTailHadToBeModifiedIfAppend(){
            linkedList.append(new DequeNode<>(new Integer(1), null,null));

            DequeNode<Integer> expectedNode= new DequeNode<>(new Integer(12), null, null);
            linkedList.append(expectedNode);

            DequeNode<Integer> obtainedNode = linkedList.peekLast();

            assertEquals(expectedNode, obtainedNode);

        }




        @Test
        @DisplayName("head equals to tail if there is only one node in list")
        public void shouldHeadEqualsToTailIfAppendOnlyOneNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(11), null, null);
            linkedList.append(nodeToAppend);

            //peek first returns head node
            DequeNode<Integer> expectedNode= linkedList.peekFirst();

            //peek last returns tail node
            DequeNode<Integer> obtainedNode = linkedList.peekLast();

            assertEquals(expectedNode, obtainedNode);

        }

        @Test
        @DisplayName("head equals to tail if appends left only one node")
        public void shouldHeadEqualsToTailIfAppendLeftOnlyOneNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(11), null, null);
            linkedList.appendLeft(nodeToAppend);

            //peek first returns head node
            DequeNode<Integer> expectedNode= linkedList.peekFirst();

            //peek last returns tail node
            DequeNode<Integer> obtainedNode = linkedList.peekLast();

            assertEquals(expectedNode, obtainedNode);

        }




    }

    @Nested
    class DeletingTest{

        @Test
        @DisplayName("runtime exception trying to delete first node and list is empty")
        public void shouldEraseARuntimeExceptionIfDeleteFirstOnAnEmptyList(){
            assertThrows(RuntimeException.class, ()-> linkedList.deleteFirst());

        }

        @Test
        @DisplayName("runtime exception trying to delete last node and list is empty")
        public void shouldEraseARuntimeExceptionIfDeleteLastOnAnEmptyList(){
            assertThrows(RuntimeException.class, ()-> linkedList.deleteLast());

        }

        @Test
        @DisplayName("list size will decrease if delete first node")
        public void shouldDecreaseSizeIfDeleteFirstNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(nodeToAppend);

            int expectedValue=0;

            linkedList.deleteFirst();
            int obtainedValue=linkedList.size();

            assertEquals(expectedValue, obtainedValue);

        }
        @Test
        @DisplayName("list size will decrease if delete last node")
        public void shouldDecreaseSizeIfDeleteLastNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(nodeToAppend);

            int expectedValue=0;

            linkedList.deleteLast();
            int obtainedValue=linkedList.size();

            assertEquals(expectedValue, obtainedValue);

        }


        @Test
        @DisplayName("head== null if deleting first node and list have only one node")
        public void shouldHeadBeNullIfDeleteFirstNodeAndListHaveOnlyOneNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(nodeToAppend);

            DequeNode<Integer> expectedValue=null;

            linkedList.deleteFirst();
            DequeNode<Integer> obtainedValue=linkedList.peekFirst();

            assertEquals(expectedValue, obtainedValue);

        }

        @Test
        @DisplayName("tail== null if deleting first node and list have only one node")
        public void shouldTailBeNullIfDeleteFirstNodeAndListHaveOnlyOneNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(nodeToAppend);

            DequeNode<Integer> expectedValue=null;

            linkedList.deleteFirst();
            DequeNode<Integer> obtainedValue=linkedList.peekLast();

            assertEquals(expectedValue, obtainedValue);

        }

        @Test
        @DisplayName("head== null if deleting last node and list have only one node")
        public void shouldHeadBeNullIfDeleteLastNodeAndListHaveOnlyOneNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(nodeToAppend);

            DequeNode<Integer> expectedValue=null;

            linkedList.deleteLast();
            DequeNode<Integer> obtainedValue=linkedList.peekFirst();

            assertEquals(expectedValue, obtainedValue);

        }

        @Test
        @DisplayName("head = next node if deleting first node")
        public void shouldHeadBeSettedToNextNodeIfDeleteFirstNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(nodeToAppend);

            DequeNode<Integer> expectedNode= new DequeNode<>(new Integer(11), null, null);
            linkedList.append(expectedNode);

            linkedList.deleteFirst();
            DequeNode<Integer> obtainedValue=linkedList.peekFirst();

            assertEquals(expectedNode, obtainedValue);

        }


        @Test
        @DisplayName("tail== null if deleting last node and list have only one node")
        public void shouldTailBeNullIfDeleteLastNodeAndListHaveOnlyOneNode(){
            DequeNode<Integer> nodeToAppend= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(nodeToAppend);

            DequeNode<Integer> expectedValue=null;

            linkedList.deleteLast();
            DequeNode<Integer> obtainedValue=linkedList.peekLast();

            assertEquals(expectedValue, obtainedValue);

        }

        @Test
        @DisplayName("tail = previous node if deleting last node")
        public void shouldTailBeSettedToPreviousNodeIfDeleteLastNode(){
            DequeNode<Integer> expectedNode= new DequeNode<>(new Integer(1), null, null);
            linkedList.append(expectedNode);

            DequeNode<Integer> nodeToDelete= new DequeNode<>(new Integer(11), null, null);
            linkedList.append(nodeToDelete);

            linkedList.deleteLast();
            DequeNode<Integer> obtainedValue=linkedList.peekLast();

            assertEquals(expectedNode, obtainedValue);

        }


    }

    @Nested
    class OperationsTesting{

        @Test
        @DisplayName("[find] find node by internal value should return the right node")
        public void shouldReturnTheRightNodeWhenWeTryToFindNodeByHisInternalItem(){
            DequeNode<Integer> expectedNode= new DequeNode<>(new Integer(1), null, null);
            Integer searchedValue=1;


            DequeNode<Integer> supportNodeOne = new DequeNode<>(new Integer(5), null, null);
            DequeNode<Integer> supportNodeTwo = new DequeNode<>(new Integer(7), null, null);
            DequeNode<Integer> supportNodeThree = new DequeNode<>(new Integer(4), null, null);
            DequeNode<Integer> supportNodeFour = new DequeNode<>(new Integer(3), null, null);
            linkedList.append(supportNodeOne);
            linkedList.append(supportNodeTwo);
            linkedList.append(expectedNode);
            linkedList.append(supportNodeThree);
            linkedList.append(supportNodeFour);

            DequeNode<Integer> obtainedNode= linkedList.find(searchedValue);

            assertEquals(expectedNode, obtainedNode);

        }
        @Test
        @DisplayName("[find] finding not contained node should return a null value")
        public void shouldReturnNullNodeWhenWeTryToFindNodeNotPresent(){
            Integer searchedValue=15;


            DequeNode<Integer> supportNodeOne = new DequeNode<>(new Integer(5), null, null);
            DequeNode<Integer> supportNodeTwo = new DequeNode<>(new Integer(7), null, null);
            DequeNode<Integer> supportNodeThree = new DequeNode<>(new Integer(4), null, null);
            DequeNode<Integer> supportNodeFour = new DequeNode<>(new Integer(3), null, null);
            linkedList.append(supportNodeOne);
            linkedList.append(supportNodeTwo);
            linkedList.append(supportNodeThree);
            linkedList.append(supportNodeFour);

            DequeNode<Integer> obtainedNode= linkedList.find(searchedValue);

            assertNull(obtainedNode);

        }

        @Test
        @DisplayName("[getAt] finding a node with a position not present")
        public void shouldReturnNullNodeWhenWeTryToFindNodeByNotPresentPosition(){
            int searchedPosition=15;


            DequeNode<Integer> supportNodeOne = new DequeNode<>(new Integer(5), null, null);
            DequeNode<Integer> supportNodeTwo = new DequeNode<>(new Integer(7), null, null);
            DequeNode<Integer> supportNodeThree = new DequeNode<>(new Integer(4), null, null);
            DequeNode<Integer> supportNodeFour = new DequeNode<>(new Integer(3), null, null);
            linkedList.append(supportNodeOne);
            linkedList.append(supportNodeTwo);
            linkedList.append(supportNodeThree);
            linkedList.append(supportNodeFour);

            DequeNode<Integer> obtainedNode= linkedList.getAt(searchedPosition);

            assertNull(obtainedNode);

        }

        @Test
        @DisplayName("[getAt] should raise a runtime exception if position is negative")
        public void shouldRaiseAnExceptionWhenWeTryToFindNodeByANegativePosition(){
            int searchedPosition=-1;


            DequeNode<Integer> supportNodeOne = new DequeNode<>(new Integer(5), null, null);
            DequeNode<Integer> supportNodeTwo = new DequeNode<>(new Integer(7), null, null);
            DequeNode<Integer> supportNodeThree = new DequeNode<>(new Integer(4), null, null);
            DequeNode<Integer> supportNodeFour = new DequeNode<>(new Integer(3), null, null);
            linkedList.append(supportNodeOne);
            linkedList.append(supportNodeTwo);
            linkedList.append(supportNodeThree);
            linkedList.append(supportNodeFour);

            assertThrows(RuntimeException.class, ()-> linkedList.getAt(searchedPosition));

        }

        @Test
        @DisplayName("[getAt] should return the right node with the right position")
        public void shouldReturnRightNodeWhenWeTryToFindNodeByPosition(){
            int searchedPosition=1;
            DequeNode<Integer> expectedNode = new DequeNode<>(new Integer(7), null, null);


            DequeNode<Integer> supportNodeOne = new DequeNode<>(new Integer(5), null, null);
            DequeNode<Integer> supportNodeThree = new DequeNode<>(new Integer(4), null, null);
            DequeNode<Integer> supportNodeFour = new DequeNode<>(new Integer(3), null, null);
            linkedList.append(supportNodeOne);
            linkedList.append(expectedNode);
            linkedList.append(supportNodeThree);
            linkedList.append(supportNodeFour);

            DequeNode<Integer> obtainedNode= linkedList.getAt(searchedPosition);

            assertEquals(expectedNode, obtainedNode);

        }



    }


}
