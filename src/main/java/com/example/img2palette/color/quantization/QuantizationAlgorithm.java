package com.example.img2palette.color.quantization;


import java.awt.Color;
import java.util.List;

public interface QuantizationAlgorithm {

    public List<Color> getReducedPalette(List<Color> colors, Integer targetPalette);


}
