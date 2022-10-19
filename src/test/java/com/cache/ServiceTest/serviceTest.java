package com.cache.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cache.design.Cache.Service.CacheService;

public class serviceTest {

    @Test
    void get(){
        CacheService c = new CacheService<Integer, Integer>(3);
        c.put(1, 4);
        c.put(2, 5);
        c.put(3, 5);
        assertEquals(5, c.get(3));

    }
    
}
