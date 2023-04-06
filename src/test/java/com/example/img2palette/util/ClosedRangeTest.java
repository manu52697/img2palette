package com.example.img2palette.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClosedRangeTest {


    @Test
    void fromList(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,50);
        ClosedRange range = ClosedRange.fromList(numbers);

        assertAll(
                () -> assertEquals(1,range.getMin()),
                () -> assertEquals(50,range.getMax())
        );

    }

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