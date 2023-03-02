package com.example.img2palette.util;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ColorExtractor {

    private final int[] colors;

    public ColorExtractor(int[] colors) {
        this.colors = colors;
    }

    public ColorExtractor(BufferedImage image) {
        this.colors = extractColors(image);
    }

    public int[] getColors(){
        return this.colors;
    }

    public static int[] extractColors(BufferedImage image) {
        int width, height;
        width = image.getWidth();
        height = image.getHeight();

        int[] colors = new int[width * height];

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                colors[i*width+j] = image.getRGB(i, j);
            }
        }
        Arrays.sort(colors);
        return colors;
    }
}
