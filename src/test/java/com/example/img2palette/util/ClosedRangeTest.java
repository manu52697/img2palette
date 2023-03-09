package com.example.img2palette.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosedRangeTest {

    @Test
    void contains() {
        ClosedRange range = new ClosedRange(0,10);
        assertAll(
                ()-> assertTrue(range.contains(0)),
                ()-> assertTrue(range.contains(10)),
                ()-> assertTrue(range.contains(5)),
                ()-> assertFalse(range.contains(11))
        );

    }

    @Test
    void getRange() {
        ClosedRange range = new ClosedRange(0,10);
        ClosedRange range2 = new ClosedRange(1,11);

        assertAll(
                ()-> assertEquals(10, range.getRange()),
                ()-> assertEquals(10, range2.getRange())
        );
    }
}