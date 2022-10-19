package com.cache.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;

import com.cache.design.Cache.Exceptions.KeyNotFoundException;
import com.cache.design.Cache.Service.CacheService;

import net.bytebuddy.implementation.bytecode.Throw;

public class serviceTest {

    @Test
    void get(){
        CacheService<Integer, Integer> c = new CacheService<>(3);
        c.put(1, 4);
        c.put(2, 5);
        c.put(3, 5);
        c.put(4, 6);
        assertEquals(6, c.get(4));

        assertEquals(null, c.get(1));
       // assertEquals(5, c.get(2));

    }
    
}
