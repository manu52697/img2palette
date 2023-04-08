package com.example.img2palette.color;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColorBucketTest {

    @Test
    void getHalves() {
        ColorBucket bucket1 = new ColorBucket(
                Arrays.asList(
                        new Color(3,3,3),
                        new Color(0,0,0),
                        new Color(3,3,3),
                        new Color(10,10,10)
                ));

        ColorBucket bucket2 = new ColorBucket(
                Arrays.asList(
                        new Color(3,3,3)
                ));

        ColorBucket bucket3 = new ColorBucket(
                Arrays.asList(
                        new Color(3,3,3),
                        new Color(0,0,0),
                        new Color(3,3,3)
                ));

        List<ColorBucket> halves1 = bucket1.getHalves();
        List<ColorBucket> halves2 = bucket2.getHalves();
        List<ColorBucket> halves3 = bucket3.getHalves();

        assertAll("Check behavior splitting bucket with even number of colors",
                () -> assertEquals(bucket1.getColors().get(0), halves1.get(0).getColors().get(0)),
                () -> assertEquals(bucket1.getColors().get(1), halves1.get(0).getColors().get(1)),
                () -> assertEquals(bucket1.getColors().get(2),halves1.get(1).getColors().get(0)),
                () -> assertEquals(bucket1.getColors().get(3),halves1.get(1).getColors().get(1)),
                () -> assertEquals(2, halves1.size()),
                () -> assertEquals(2, halves1.get(0).getColors().size()),
                () -> assertEquals(2, halves1.get(1).getColors().size())
        );

        assertAll("Check behavior splitting bucket with only one color",
                () -> assertEquals(1, halves2.get(0).getColors().size()),
                () -> assertEquals(1, halves2.size()),
                () -> assertEquals(bucket2.getColors().get(0), halves2.get(0).getColors().get(0))
    );

        assertAll("Check behavior splitting bucket with odd number of colors",
                () -> assertEquals(1, halves3.get(0).getColors().size()),
                () -> assertEquals(2, halves3.get(1).getColors().size()),
                () -> assertEquals(bucket3.getColors().get(0), halves3.get(0).getColors().get(0))
                );


    }

    @Test
    void sortByWidestChannel() {
        Color expectedFirstColor = new Color (0,0,0);

        ColorBucket bucket = new ColorBucket(
                Arrays.asList(
                    new Color(10,8,8),
                    expectedFirstColor,
                    new Color(16,50,3)
        ));

        bucket.sortByWidestChannel();

        assertEquals(expectedFirstColor, bucket.getColors().get(0));
    }

    @Test
    void getCentroid() {
        Color centroid1 = new Color(2,2,2);
        Color centroid2 = new Color(10,10,10);

        ColorBucket bucket1 = new ColorBucket(
                Arrays.asList(
                        new Color(3,3,3),
                        new Color(0,0,0),
                        new Color(3,3,3)
                ));

        ColorBucket bucket2 = new ColorBucket(
                Arrays.asList(
                        new Color(0,0,0),
                        new Color(10,10,10),
                        new Color(20,20,21)
                ));

        assertAll(
                () -> assertEquals(centroid1, bucket1.getCentroid()),
                () -> assertEquals(centroid2, bucket2.getCentroid())
        );

    }


}