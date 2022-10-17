package com.cache.design.Cache.DoublyLinkedList;

import lombok.Getter;

@Getter
public class DoublyLinkedList<Value> {
    DoublyLinkedList<Value> prev;
    DoublyLinkedList<Value> next;
    Value val;
    public DoublyLinkedList(Value val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
