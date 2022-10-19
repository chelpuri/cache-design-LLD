package com.cache.doublylinkedlisttest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cache.design.Cache.DoublyLinkedList.DoublyLinkedList;
import com.cache.design.Cache.DoublyLinkedList.DoublyLinkedListMethods;

public class dlltest {
    
    @Test
    void addition(){
    DoublyLinkedList<Integer, Integer> dll = new DoublyLinkedList<Integer, Integer>(1, 3);
    DoublyLinkedList<Integer, Integer> dll1 = new DoublyLinkedList<Integer, Integer>(2, 2);
    DoublyLinkedList<Integer, Integer> dll2 = new DoublyLinkedList<Integer, Integer>(3, 1);
    DoublyLinkedList<Integer, Integer> dll3 = new DoublyLinkedList<Integer, Integer>(4, 4);

    DoublyLinkedListMethods<Integer, Integer> dm = new DoublyLinkedListMethods<>();
        dm.insertNode(dll);
    assertEquals(dm.getHead().getNext(), dll);
        dm.insertNode(dll1);
        dm.insertNode(dll2);
        dm.insertNode(dll3); // dm = h,4,1,2,3,t
    assertEquals(dm.getHead().getNext().getVal(), dll3.getVal());
    assertEquals(dm.getTail().getVal(), 3);

    dm.deleteNode(dll3); // dm = h,1,2,3,t
    assertEquals(dm.getHead().getNext().getVal(), 1);
    dm.deleteNode(dll1); // dm = h,1,3,t
    assertEquals(dm.getHead().getNext().getNext().getVal(), 3);
    }
}
