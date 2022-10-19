package com.cache.design.Cache.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.design.Cache.Service.CacheService;

@RestController
@RequestMapping("/")
public class CacheController<Key, Value> {
    CacheService<Key, Value> cs;

    public CacheController(CacheService<Key, Value> cs){
        cs = new CacheService<>(10);
    }

    @PostMapping("/{key}/{value}")
    public void add(@PathVariable Key key, @PathVariable Value val){
        cs.put(key, val);;
    }

    @GetMapping("/{key}")
    public Value getCache(@PathVariable Key key) {
        return cs.get(key);
    }

}
