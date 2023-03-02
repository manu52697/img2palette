package com.example.img2palette.services;

import org.springframework.beans.factory.annotation.Value;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ResizeService {

    static BufferedImage resize(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(originalImage, 0,0,targetWidth, targetHeight, null);
        graphics.dispose();
        return resizedImage;
    }

    public BufferedImage resize(BufferedImage originalImage) throws IOException;
}
