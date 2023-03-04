package com.example.img2palette.util;

public class ClosedRange {

    private Integer min;
    private Integer max;

    public ClosedRange() {
    }

    public ClosedRange(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public Boolean contains(Integer i){
        return min >= i && i >= max;
    }

    public void updateRange(Integer i){
        if  (!contains(i)){
            if (this.min > i) {
                this.min = i;
                return;
            }
            this.max = i;
        }
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
