package com.cache.design.Cache.Service;

import java.util.HashMap;
import java.util.Map;

import com.cache.design.Cache.DoublyLinkedList.DoublyLinkedList;
import com.cache.design.Cache.DoublyLinkedList.DoublyLinkedListMethods;
import com.cache.design.Cache.Exceptions.KeyNotFoundException;
import com.cache.design.Cache.Exceptions.StorageFullException;


public class CacheService<Key, Value> {
    DoublyLinkedList<Value> dll;
    Map<Key, DoublyLinkedList<Value>> map;
    DoublyLinkedListMethods<Value> dm;
    private int Capacity;

    public CacheService(int Capacity){
        dll = new DoublyLinkedList<Value>(null);
        map = new HashMap<>();
        this.Capacity = Capacity;
        dm = new DoublyLinkedListMethods<>();
    }

    // add a new value in cache 
    public void put(Key k, Value v) throws StorageFullException {
        try {
            dm.insertNode(new DoublyLinkedList<>(v));
            map.put(k, new DoublyLinkedList<>(v));    
        }
        catch(StorageFullException exception) {
            dm.deleteNode(dm.getTail());
        }
    }

    public Value get(Key k) throws KeyNotFoundException{
        if(map.get(k) == null) throw new KeyNotFoundException(k + " not found");
        else{
            DoublyLinkedList<Value> temp = map.get(k);
            dm.deleteNode(temp);
            dm.insertNode(temp);
            return temp.getVal();
        }

    }

    private boolean isStorageFull() {
        return Capacity == map.size();
    }
}
