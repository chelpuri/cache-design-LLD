package com.cache.design.Cache.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cache.design.Cache.DoublyLinkedList.DoublyLinkedList;
import com.cache.design.Cache.DoublyLinkedList.DoublyLinkedListMethods;
import com.cache.design.Cache.Exceptions.KeyNotFoundException;
import com.cache.design.Cache.Exceptions.StorageFullException;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CacheService<Key, Value> {
    DoublyLinkedList<Key, Value> dll;
    Map<Key, DoublyLinkedList<Key, Value>> map;
    DoublyLinkedListMethods<Key, Value> dm;
    public int Capacity;

    public CacheService(int Capacity){
        dll = new DoublyLinkedList<>(null, null);
        map = new HashMap<>();
        this.Capacity = Capacity;
        dm = new DoublyLinkedListMethods<>();
    }

    // add a new value in cache 
    public void put(Key k, Value v) throws StorageFullException {
        try {
            if(map.size() >= Capacity) throw new StorageFullException("Storage is full deleting tail node and inserting new node");
            dm.insertNode(new DoublyLinkedList<>(k, v));
            map.put(k, new DoublyLinkedList<>(k, v));
        }
        catch(StorageFullException exception) {
            map.remove(dm.getTail().getKey()); // remove tail node from hashmap also
            dm.deleteNode(dm.getTail());
            dm.insertNode(new DoublyLinkedList<>(k, v));
            map.put(k, new DoublyLinkedList<>(k,v));
        }
    }


    public Value get(Key k) throws KeyNotFoundException{
        try {
            if(map.get(k) == null) throw new KeyNotFoundException(k + " not found");
            else {
                DoublyLinkedList<Key, Value> temp = map.get(k);
                dm.deleteNode(dm.getNode(temp.getVal()));
                dm.insertNode(temp);
                return temp.getVal();
            }
        }
        catch(KeyNotFoundException message) {
            return null;
        }
    }
}
