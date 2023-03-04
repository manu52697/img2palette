package com.example.img2palette.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    public void testPutMethod() {
        Counter<Integer> counter = new Counter<Integer>();


        for (int i=0; i<6;i++){
            counter.put(i,null);
        }

        for (int i=0; i<4;i++){
            counter.put(i,null);
        }

        for (int i=0; i<2;i++) {
            counter.put(i,null);
        }

        assertAll(
                "Check that counter.put increments value by one on repeating",
                () -> assertEquals(3, counter.get(0)),
                () -> assertEquals(2, counter.get(2)),
                () -> assertEquals(1, counter.get(4))
                );



    }

}