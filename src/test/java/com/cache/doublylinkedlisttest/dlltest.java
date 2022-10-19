package com.cache.doublylinkedlisttest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cache.design.Cache.DoublyLinkedList.DoublyLinkedList;
import com.cache.design.Cache.DoublyLinkedList.DoublyLinkedListMethods;

public class dlltest {
    
    @Test
    void addition(){
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>(3);
    DoublyLinkedList<Integer> dll1 = new DoublyLinkedList<Integer>(2);
    DoublyLinkedList<Integer> dll2 = new DoublyLinkedList<Integer>(1);
    DoublyLinkedList<Integer> dll3 = new DoublyLinkedList<Integer>(4);

    DoublyLinkedListMethods<Integer> dm = new DoublyLinkedListMethods<>();
        dm.insertNode(dll);
    assertEquals(dm.getHead().getNext(), dll);
        dm.insertNode(dll1);
        dm.insertNode(dll2);
        dm.insertNode(dll3);
    assertEquals(dm.getHead().getNext().getVal(), dll3.getVal());
    assertEquals(dm.getTail().getVal(), 3);
    }
}
