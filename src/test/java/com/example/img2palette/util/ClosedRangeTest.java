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

    @Test
    void updateRange(){

        // setup
        ClosedRange emptyRange = new ClosedRange(0,0).updateRange(0);
        ClosedRange range1 = new ClosedRange(2,3).updateRange(4);
        ClosedRange range2 = new ClosedRange(3,4).updateRange(2);

        //assertions
        assertAll("Check updating range; Case: range contains int k",
                ()-> assertEquals(emptyRange.getRange(),  0),
                ()-> assertEquals(emptyRange.getMin(), 0),
                () -> assertEquals(emptyRange.getMax(), 0)
        );

        assertAll("Check updating range; Case: range not contains int k, k > range.getMax()",
                ()-> assertEquals(range1.getRange(), 2),
                ()-> assertEquals(range1.getMin(), 2),
                () -> assertEquals(range1.getMax(), 4)
                );

        assertAll("Check updating range; Case: range not contains int k, k < range.getMin()",
                () -> assertEquals(range2.getRange(), 2),
                ()-> assertEquals(range2.getMin(),2),
                () -> assertEquals(range2.getMax(), 4)
                );

        assertEquals(range1.getRange(), range2.getRange());

    }
}