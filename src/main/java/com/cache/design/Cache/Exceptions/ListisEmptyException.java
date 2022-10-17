package com.cache.design.Cache.Exceptions;

public class ListisEmptyException extends RuntimeException {
    public ListisEmptyException(String message){
        System.out.println(message);
    }
}
