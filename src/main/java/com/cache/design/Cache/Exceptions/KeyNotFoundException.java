package com.cache.design.Cache.Exceptions;

public class KeyNotFoundException extends RuntimeException{

    public KeyNotFoundException(String Message){
        System.out.println(Message);
    }
}
