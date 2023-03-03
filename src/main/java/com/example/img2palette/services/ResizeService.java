package com.example.img2palette.services;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *This interface declares a contract for classes whose purpose is the resizing of images.
 * Implements sensitive default methods that achieve that task without external dependencies
 * @author Manuel Artal
 */
public interface ResizeService {

    /**
     * This method performs the resizing of images using {@link java.awt.Graphics2D} for performance. Discards alpha.
     * @param originalImage The original {@link BufferedImage} we want to resize.
     * @param targetWidth The target width.
     * @param targetHeight The target height.
     * @return The resized copy of the original image with the specified width and height.
     * @see Graphics2D
     */
    default BufferedImage resize(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(originalImage, 0,0,targetWidth, targetHeight, null);
        graphics.dispose();
        return resizedImage;
    }

    /**
     * Syntactic sugar for {@link #resize(BufferedImage, int, int)} that specifies sensible defaults for downsizing
     * @param originalImage The original {@link BufferedImage} we want to resize.
     * @return The resulting downsized {@link BufferedImage}
     */
    default BufferedImage resize(BufferedImage originalImage){
        return resize(originalImage, 150, 150);
    }
}
