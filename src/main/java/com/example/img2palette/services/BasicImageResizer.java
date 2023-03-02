package com.example.img2palette.services;

import org.springframework.beans.factory.annotation.Value;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BasicImageResizer implements ResizeService {

    @Value("${imageProcessing.defaults.targetHeight}")
    private final int targetHeight;

    @Value("${imageProcessing.defaults.targetWidth}")
    private final int targetWidth;

    public BasicImageResizer(int targetHeight, int targetWidth) {
        this.targetHeight = targetHeight;
        this.targetWidth = targetWidth;
    }


    @Override
    public BufferedImage resize(BufferedImage originalImage) throws IOException {
        return ResizeService.resize(originalImage, targetHeight, targetWidth);
    }
}
