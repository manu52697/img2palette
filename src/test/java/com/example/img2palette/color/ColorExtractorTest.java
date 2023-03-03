package com.example.img2palette.color;

import com.example.img2palette.color.ColorExtractor;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class ColorExtractorTest {


    @Test
    void extractColors() {
        int testHeight, testWidth;
        testWidth = 3;
        testHeight = 4;

        BufferedImage testImage = new BufferedImage(testWidth, testHeight, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < testWidth; i++) {
            for (int j = 0; j < testHeight; j++) {
                testImage.setRGB(i, j, new Color(i*20,j*20,0).getRGB());
            }
        }

        ColorExtractor extractor = new ColorExtractor(testImage);
        Color[] colors = extractor.getColors();

        assertAll("Check color extraction",
                () -> assertEquals(new Color(0), colors[0]),
                () -> assertEquals(new Color(0,20,0), colors[1]),
                () -> assertEquals(new Color(0,40,0), colors[2]),
                () -> assertEquals(new Color(20,0,0), colors[3]),
                () -> assertEquals(new Color(20,20,0), colors[4])
    );

    }
}