package com.example.img2palette.util;

import java.awt.Color;
import java.util.Comparator;

public class PrimaryColorsComparators {

    public static final Comparator<Color> RED = new Comparator<Color>() {
        @Override
        public int compare(Color o1, Color o2) {
            return Integer.compare(o1.getRed(), o2.getRed());
        }
    };
    
    public static final Comparator<Color> BLUE = new Comparator<Color>(){
        @Override
        public int compare(Color o1, Color o2) {
            return Integer.compare(o1.getBlue(), o2.getBlue());
        }
    };
    
    public static final Comparator<Color> GREEN = new Comparator<Color>(){
        @Override
        public int compare(Color o1,Color o2) {
            return Integer.compare(o1.getGreen(), o2.getGreen());
        }
    };

    public PrimaryColorsComparators() {
    }

}
