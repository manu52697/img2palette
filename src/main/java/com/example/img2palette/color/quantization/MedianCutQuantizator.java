package com.example.img2palette.color.quantization;

import com.example.img2palette.color.ColorBucket;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;


public class MedianCutQuantizator implements QuantizationAlgorithm{


    @Override
    public List<Color> getReducedPalette(List<Color> colors, Integer targetPalette) {
        ColorBucket bucket = new ColorBucket(colors);

        return sortAndSplit(bucket, targetPalette)
                .stream()
                .map(ColorBucket::getCentroid)
                .collect(Collectors.toList());

    }

    private List<ColorBucket> sortAndSplit(ColorBucket bucket, Integer numOfPartitions){
        if(numOfPartitions == 1){
            return List.of(bucket);
        }
        List<ColorBucket> finalBuckets = bucket.sortByWidestChannel()
                                                .getHalves()
                                                .stream()
                                                .map((b) -> sortAndSplit(b, numOfPartitions -1))
                                                .map((list) -> list.get(0))
                                                .collect(Collectors.toList());
        return finalBuckets;
    }

}
