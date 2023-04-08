package com.example.img2palette.color;


import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class ColorBucket {

    private final List<Color> colors;
    private final ColorChannelRanges colorRanges;


    public ColorBucket(List<Color> colors) {
        this.colors = colors;
        this.colorRanges = ColorChannelRanges.fromCollection(colors);
    }


    /**
     * Splits the bucket into two and returns a list with the partitions
     * @return A list containing two buckets
     */
    public List<ColorBucket> getHalves(){
        if(this.colors.size() == 1){
            return Arrays.asList(this);
        }

        int median = (int) this.colors.size() / 2;
        return List.of(
                new ColorBucket(this.colors.subList(0, median)),
                new ColorBucket(this.colors.subList(median, this.colors.size()))
        );
    }

    /**
     * This method sorts the colors in place by the widest color channel.
     */
    public ColorBucket sortByWidestChannel() {
        RGB sortingChannel = this.colorRanges.getWidestChannel();
        sortColorsByChannel(sortingChannel);
        return this;
    }

    /**
     * Sorts the list of colors by the specified {@link RGB} channel.
     * @param channel a RGB channel
     */
    private void sortColorsByChannel(RGB channel){
        switch (channel){
            case RED -> this.colors.sort(PrimaryColorsComparators.RED);
            case GREEN -> this.colors.sort(PrimaryColorsComparators.GREEN);
            case BLUE -> this.colors.sort(PrimaryColorsComparators.BLUE);
        }
    }

    /**
     * Returns the centroid of the colors in the bucket.
     * @return
     */
    public Color getCentroid(){
        int size = this.colors.size();
        int red = 0;
        int green = 0;
        int blue = 0;

        for (Color c : this.colors){
            red += c.getRed();
            green += c.getGreen();
            blue += c.getBlue();
        }

        red = (int) red / size;
        green = (int) green / size;
        blue = (int) blue / size;

        return new Color(red, green, blue);

    }

    // getters
    public List<Color> getColors() {
        return colors;
    }

    public ColorChannelRanges getColorRanges() {
        return colorRanges;
    }
}
