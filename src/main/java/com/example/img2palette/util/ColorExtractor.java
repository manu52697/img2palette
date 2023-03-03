package com.example.img2palette.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ColorExtractor {

    private final Color[] colors;

    public ColorExtractor(Color[] colors) {
        this.colors = colors;
    }

    public ColorExtractor(BufferedImage image) {
        this.colors = extractColors(image);
    }

    public Color[] getColors(){
        return this.colors;
    }

    /**
     * This method reads the color data from a BufferedImage and returns an array stacking the pixel data by column
     * @param image An BufferedImage instance
     * @return An array of color values
     */
    public static Color[] extractColors(BufferedImage image) {
        int width, height;
        width = image.getWidth();
        height = image.getHeight();

        Color[] colors = new Color[width * height];

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                colors[i*width+j] = new Color(image.getRGB(i, j));
            }
        }

        return colors;
    }
}
