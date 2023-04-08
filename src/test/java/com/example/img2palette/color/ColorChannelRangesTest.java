package com.example.img2palette.color;

import com.example.img2palette.util.ClosedRange;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColorChannelRangesTest {

    @Test
    void fromCollection() {
        List<Color> colors = List.of(
                new Color(0,0,0),
                new Color(1,10,100),
                new Color(0,70,6)
        );
        ColorChannelRanges channels = ColorChannelRanges.fromCollection(colors);

        assertAll("Check resulting ranges lower limits",
                () -> assertEquals(0, channels.getRedRange().getMin()),
                () -> assertEquals(0, channels.getGreenRange().getMin()),
                () -> assertEquals(0, channels.getBlueRange().getMin())
        );

        assertAll("Check resulting ranges upper limits",
                () -> assertEquals(1, channels.getRedRange().getMax()),
                () -> assertEquals(70, channels.getGreenRange().getMax()),
                () -> assertEquals(100, channels.getBlueRange().getMax())
                        );

    }

    @Test
    void containsColor() {
        ColorChannelRanges channels = ColorChannelRanges.fromCollection(
                List.of(
                        new Color(1,1,1),
                        new Color(2,2,2)
                )
        );

        assertAll("Check contains true colors",
                () -> assertTrue(channels.containsColor(new Color(1,1,1))),
                () -> assertTrue(channels.containsColor(new Color(2,2,2)))
                );

        assertAll("Check returns false on not present colors",
                () -> assertFalse(channels.containsColor(new Color(3,3,3))),
                () -> assertFalse(channels.containsColor(new Color(255,255,255)))
                );
    }


    @Test
    void updateChannelRanges() {

        Color presentColor = new Color(1,1,1);
        Color otherColor = new Color(255,255,255);

        ClosedRange initialRange = ClosedRange.fromList(List.of(1,2,3));
        ClosedRange updatedRange = ClosedRange.fromList(List.of(1,2,3,255));

        ColorChannelRanges channels = ColorChannelRanges.fromCollection(
                List.of(
                        presentColor,
                        new Color(2,2,2),
                        new Color(3,3,3)
                )
        );

        channels.updateChannelRanges(presentColor);

        assertAll("Check channel doesn't updates when color is already present",
                () -> assertEquals(initialRange.getMin(), channels.getRedRange().getMin()),
                () -> assertEquals(initialRange.getMax(), channels.getRedRange().getMax()),
                () -> assertEquals(initialRange.getMin(), channels.getGreenRange().getMin()),
                () -> assertEquals(initialRange.getMax(), channels.getGreenRange().getMax()),
                () -> assertEquals(initialRange.getMin(), channels.getBlueRange().getMin()),
                () -> assertEquals(initialRange.getMax(), channels.getBlueRange().getMax())
        );

        channels.updateChannelRanges(otherColor);

        assertAll("Check channel updates properly when color is not already present",
                () -> assertEquals(initialRange.getMin(), channels.getRedRange().getMin()),
                () -> assertEquals(initialRange.getMax(), channels.getRedRange().getMax()),
                () -> assertEquals(initialRange.getMin(), channels.getGreenRange().getMin()),
                () -> assertEquals(initialRange.getMax(), channels.getGreenRange().getMax()),
                () -> assertEquals(initialRange.getMin(), channels.getBlueRange().getMin()),
                () -> assertEquals(initialRange.getMax(), channels.getBlueRange().getMax())
                );
    }

    @Test
    void getWidestChannel() {
        ColorChannelRanges channelsBlue = ColorChannelRanges.fromCollection(
                List.of(
                        new Color(0,0,0),
                        new Color(0,0,100)
                )
        );

        ColorChannelRanges channelsGreen = ColorChannelRanges.fromCollection(
                List.of(
                        new Color(0,0,0),
                        new Color(0,100,0)
                )
        );

        ColorChannelRanges channelsRed = ColorChannelRanges.fromCollection(
                List.of(
                        new Color(0,0,0),
                        new Color(100,0,0)
                )
        );

        assertAll(
                () -> assertEquals(RGB.RED, channelsRed.getWidestChannel()),
                () -> assertEquals(RGB.GREEN, channelsGreen.getWidestChannel()),
                () -> assertEquals(RGB.BLUE, channelsBlue.getWidestChannel())
        );
    }
}