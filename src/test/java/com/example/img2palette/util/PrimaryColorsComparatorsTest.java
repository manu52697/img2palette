package com.example.img2palette.util;

import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrimaryColorsComparatorsTest {

    private Color[] colors = new Color[]{
            new Color(10, 1, 1),
            new Color(1, 10, 1),
            new Color(1, 1, 10),
    };

    @Test
    public void testRedComparator() {

        Color[] testColors = Arrays.copyOf(colors,3);
        Arrays.sort(testColors, PrimaryColorsComparators.RED);

        assertEquals(colors[0], testColors[2]);
    }

    @Test
    public void testGreenComparator() {

        Color[] testColors = Arrays.copyOf(colors,3);
        Arrays.sort(testColors, PrimaryColorsComparators.GREEN);

        assertEquals(colors[1], testColors[2]);
    }

    @Test
    public void testBlueComparator() {

        Color[] testColors = Arrays.copyOf(colors,3);
        Arrays.sort(testColors, PrimaryColorsComparators.BLUE);

        assertEquals(colors[2], testColors[2]);
    }
}