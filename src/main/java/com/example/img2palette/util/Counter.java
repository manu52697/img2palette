package com.example.img2palette.util;


import java.util.HashMap;
import java.lang.Integer;

public class Counter<K> extends HashMap<K,Integer> {

    @Override
    public Integer put(K key, Integer value) {
        if (super.containsKey(key)) {
            return super.put(key, super.get(key) + 1 );
        }
        return super.put(key, value);
    }
}
