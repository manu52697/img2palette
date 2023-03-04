package com.example.img2palette.util;

import java.util.HashMap;
import java.lang.Integer;

/**
 * This class implements a simple counter using a {@link HashMap} as the underlying store.
 * @param <K>
 */
public class Counter<K> extends HashMap<K,Integer> {

    /**
     * Checks if the key is present and if it's, increments by one its value. If it's not, sets the value to 1.
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return
     */
    @Override
    public Integer put(K key, Integer value) {
        if (super.containsKey(key)) {
            return super.put(key, super.get(key) + 1 );
        }
        return super.put(key, 1);
    }
}
