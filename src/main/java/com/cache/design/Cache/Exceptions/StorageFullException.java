package com.cache.design.Cache.Exceptions;

public class StorageFullException extends RuntimeException {
    public StorageFullException(String message){
        System.out.println(message);
    }
}
