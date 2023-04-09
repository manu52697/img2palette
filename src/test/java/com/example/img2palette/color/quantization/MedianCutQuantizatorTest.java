package com.example.img2palette.color.quantization;

import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedianCutQuantizatorTest {

    @Test
    void getReducedPalette() {
        Color color1, color2, color3;
        color1 = new Color(0,0,0);
        color2 = new Color(1,1,1);
        color3 = new Color(2,2,2);

        List<Color> colors = Arrays.asList(
                color1,
                color2,
                color3
        );

        QuantizationAlgorithm quant = new MedianCutQuantizator();
        List<Color> result1 = quant.getReducedPalette(colors, 1);

        assertAll("Check reduction to one color",
                () -> assertEquals(color2, result1.get(0)),
                () -> assertEquals(1, result1.size())
                );

        List<Color> result2 = quant.getReducedPalette(colors, 2);

        assertAll("Check reduction to two colors",
                () -> assertEquals(2, result2.size()),
                () -> assertEquals(color1, result2.get(0))
        );

    }
}