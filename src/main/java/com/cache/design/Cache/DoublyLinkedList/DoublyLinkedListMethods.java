package com.cache.design.Cache.DoublyLinkedList;

import com.cache.design.Cache.Exceptions.KeyNotFoundException;
import com.cache.design.Cache.Exceptions.ListisEmptyException;
import com.cache.design.Cache.Exceptions.StorageFullException;

import lombok.Getter;

@Getter
public class DoublyLinkedListMethods<Key, Value> {
    DoublyLinkedList<Key, Value> head;
    DoublyLinkedList<Key, Value> tail;

    public DoublyLinkedListMethods() {
        head = new DoublyLinkedList<>(null, null);
        tail = new DoublyLinkedList<>(null,null);

        head.next = tail;
        tail.prev = head;
    }

    // add node at first as per LRU policy
    public void insertNode(DoublyLinkedList<Key, Value> dll) throws StorageFullException{
        DoublyLinkedList<Key, Value> headNext = head.next;
        head.next = dll;
        dll.prev = head;
        dll.next = headNext;
        headNext.prev = dll;
    }

    // delete the node passed form Doubly Linked List
    public void deleteNode(DoublyLinkedList<Key, Value> dll) throws KeyNotFoundException{ 
        if(getNode(dll.getVal()) == null) throw new KeyNotFoundException("Key not found in cache");
        dll.prev.next = dll.next;
        dll.next.prev = dll.prev;
    }

    // return tail node to remove it as per storage full policy and check for empty list
    public DoublyLinkedList<Key, Value> getTail() throws ListisEmptyException{
        if(tail.prev == head) throw new ListisEmptyException("Cache is Empty");
        else
            return tail.prev;
    }

    //check if node is in the cache
    public DoublyLinkedList<Key, Value> getNode(Value v) {
        DoublyLinkedList<Key, Value> temp = head.getNext();
        while(temp != null && temp.getVal() != v ){
            temp = temp.next;
        }

        if(temp == null) throw new KeyNotFoundException("node not found in cache");
        return temp;
    }

}
