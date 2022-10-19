package com.cache.design.Cache.DoublyLinkedList;

import lombok.Getter;

@Getter
public class DoublyLinkedList<Key, Value> {
    DoublyLinkedList<Key, Value> prev;
    DoublyLinkedList<Key, Value> next;
    Value val;
    Key key;
    public DoublyLinkedList(Key key, Value val){
        this.val = val;
        this.prev = null;
        this.next = null;
        this.key = key;
    }
}
