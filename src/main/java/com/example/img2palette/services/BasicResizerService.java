package com.example.img2palette.services;

import org.springframework.beans.factory.annotation.Value;

import java.awt.image.BufferedImage;


/**
 * Implementation of {@link ResizeService} that allows for changing the resulting size
 * with runtime application properties.
 * @author Manuel Artal
 */
public class BasicResizerService implements ResizeService {

    @Value("${imageProcessing.defaults.targetHeight}")
    private final int targetHeight;

    @Value("${imageProcessing.defaults.targetWidth}")
    private final int targetWidth;

    public BasicResizerService(int targetHeight, int targetWidth) {
        this.targetHeight = targetHeight;
        this.targetWidth = targetWidth;
    }

    /**
     * {@inheritDoc}
     * This implementation overrides the default method allowing to set the target width and height at runtime
     * @param originalImage The original {@link BufferedImage} we want to resize.
     * @return The resulting {@link BufferedImage}
     */
    @Override
    public BufferedImage resize(BufferedImage originalImage) {
        return resize(originalImage, targetHeight, targetWidth);
    }
}
