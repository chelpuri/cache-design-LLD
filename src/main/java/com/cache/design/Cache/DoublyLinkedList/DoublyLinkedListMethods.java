package com.cache.design.Cache.DoublyLinkedList;

import com.cache.design.Cache.Exceptions.KeyNotFoundException;
import com.cache.design.Cache.Exceptions.ListisEmptyException;
import com.cache.design.Cache.Exceptions.StorageFullException;

import lombok.Getter;

@Getter
public class DoublyLinkedListMethods<Value> {
    DoublyLinkedList<Value> head;
    DoublyLinkedList<Value> tail;

    public DoublyLinkedListMethods() {
        head = new DoublyLinkedList<>(null);
        tail = new DoublyLinkedList<>(null);

        head.next = tail;
        tail.prev = head;
    }

    // add node at first as per LRU policy
    public void insertNode(DoublyLinkedList<Value> dll) throws StorageFullException{
        DoublyLinkedList<Value> headNext = head.next;
        head.next = dll;
        dll.prev = head;
        dll.next = headNext;
        headNext.prev = dll;
    }

    // delete the node passed form Doubly Linked List
    public void deleteNode(DoublyLinkedList<Value> dll) throws KeyNotFoundException{ 
        if(dll == null) return;
        dll.prev.next = dll.next;
        dll.next.prev = dll.prev;
    }

    // return tail node to remove it as per storage full policy and check for empty list
    public DoublyLinkedList<Value> getTail() throws ListisEmptyException{
        if(tail.prev == head) throw new ListisEmptyException("Cache is Empty");
        else
            return tail.prev;
    }
}
