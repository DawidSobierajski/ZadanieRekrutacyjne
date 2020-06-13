package com.sobierajski.zadanie.utils.mapper;

public class Mapper {
    public String map(byte[] array){
        return new String(array);
    }

    public byte[] map(String s){
        return s.getBytes();
    }
}
