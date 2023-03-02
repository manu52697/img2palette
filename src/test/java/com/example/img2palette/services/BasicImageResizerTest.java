package com.example.img2palette.services;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class BasicImageResizerTest {

    @Test
    void testResize(){
        try {
            BufferedImage originalImage = ImageIO.read(new URL(
                    "https://images.unsplash.com/photo-1677461746921-220b55213f0e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"));

            int originalWidth, originalHeight;
            originalWidth = originalImage.getWidth();
            originalHeight = originalImage.getHeight();

            ResizeService resizer = new BasicImageResizer(200,200);
            BufferedImage resizedImage = resizer.resize(originalImage);


            assertAll("Assert resize is working",
                    () -> assertEquals(200, resizedImage.getWidth()),
                    () -> assertEquals(200, resizedImage.getHeight()));
        } catch (IOException e) {
            fail();
            throw new RuntimeException("Error loading image from Unsplash", e);
        }


    }

}