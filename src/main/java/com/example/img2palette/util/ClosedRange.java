package com.example.img2palette.util;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of a closed, compact range.
 */
public class ClosedRange {

    /**
     * The smallest integer contained in the range.
     */
    private final Integer min;

    /**
     * The biggest element contained in the range.
     */
    private final Integer max;


    public ClosedRange(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Static constructor that makes a {@code ClosedRange} from a list of integers
     * @param numbers a list of integers
     * @return A ClosedRange instance
     */
    public static ClosedRange fromList(List<Integer> numbers){
        Integer min, max;
        min = numbers.get(0);
        max = numbers.get(0);
        for (Integer n : numbers) {
            if (n < min){
                min = n;
            }else if (n > max){
                max = n;
            }
        }
        return new ClosedRange(min,max);
    }


    /**
     * Checks if the range contains the integer {@code i}.
     * @param i An integer.
     * @return True if the number is between the range's limits, false otherwise.
     */
    public Boolean contains(Integer i){
        return min <= i && i <= max;
    }

    /**
     * Checks if the range contains a given integer. If true, returns itself, else returns a new range including
     * that integer
     * @param k an Integer
     * @return A ClosedRange
     */
    public ClosedRange updateRange(Integer k){
        if (contains(k)){
            return this;
        }
        if (k < min) {
            return new ClosedRange(k,getMax());
        }
        return new ClosedRange(getMin(),k);
    }

    /**
     * Returns the difference between the biggest and the smallest elements in the range.
     * @return
     */
    public Integer getRange() {
        return this.max - this.min;
    }

    /**
     * Returns the smallest integer contained in the range.
     * @return {@code Integer}
     */
    public Integer getMin() {
        return min;
    }

    /**
     * Returns the largest integer contained in the range.
     * @return {@code Integer}
     */
    public Integer getMax() {
        return max;
    }

}
