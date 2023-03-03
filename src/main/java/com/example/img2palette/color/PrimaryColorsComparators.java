package com.example.img2palette.color;

import java.awt.Color;
import java.util.Comparator;

/**
 * This class holds comparators that can order {@link Color} collections based on each one of the primary
 * RGB colors.
 * @author Manuel Artal
 */
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
