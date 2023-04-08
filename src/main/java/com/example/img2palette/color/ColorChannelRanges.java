package com.example.img2palette.color;

import com.example.img2palette.util.ClosedRange;

import java.awt.Color;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ColorChannelRanges {

    private final ClosedRange redRange;

    private final ClosedRange greenRange;

    private final ClosedRange blueRange;


    private final RGB widestChannel;

    public ColorChannelRanges(ClosedRange redRange, ClosedRange greenRange, ClosedRange blueRange) {
        this.redRange = redRange;
        this.greenRange = greenRange;
        this.blueRange = blueRange;
        this.widestChannel = calculateWidestChannel();
    }

    public static ColorChannelRanges fromCollection(Collection<Color> colors) {
        List<Integer> reds, greens, blues;
        reds = colors.stream().map(c -> c.getRed()).collect(Collectors.toList());
        greens = colors.stream().map(c -> c.getGreen()).collect(Collectors.toList());
        blues = colors.stream().map(c -> c.getBlue()).collect(Collectors.toList());

        return new ColorChannelRanges(
                ClosedRange.fromList(reds),
                ClosedRange.fromList(greens),
                ClosedRange.fromList(blues));
    }

    public boolean containsColor(Color color){
        return
                this.redRange.contains(color.getRed()) &
                this.greenRange.contains(color.getGreen()) &
                this.blueRange.contains(color.getBlue());
    }


    /**
     * Returns a new {@link ColorChannelRanges} instance that will contain the specified color.
     * @param color
     * @return
     */
    public ColorChannelRanges updateChannelRanges(Color color){

        if (!containsColor(color)){
            // Setup a Builder in order to update the corresponding ranges. Uses current ranges as default,
            // in order to update just the ones that need to change
            ClosedRange updatedRed, updatedGreen, updatedBlue;
            updatedRed = getRedRange();
            updatedGreen = getGreenRange();
            updatedBlue = getBlueRange();

            Builder builder = new Builder();
            builder.setRedRange(updatedRed)
                    .setGreenRange(updatedGreen)
                    .setBlueRange(updatedBlue);

            // update the ranges that don't contain the color
            if(!getRedRange().contains(color.getRed())){
                updatedRed = updatedRed.updateRange(color.getRed());
            }
            if(!getGreenRange().contains(color.getGreen())){
                updatedGreen = updatedGreen.updateRange(color.getGreen());
            }
            if(!getBlueRange().contains(color.getBlue())){
                updatedBlue = updatedBlue.updateRange(color.getBlue());
            }
            // return the built ranges
            return builder.build();
        }
        return this;
    }


    /**
     * Checks wich of the RGB channels is widest, and returns the corresponding {@link RGB} value.
     * @return a {@link RGB} value.
     * @see RGB
     */
    private RGB calculateWidestChannel() {
        int redRangeSize, greenRangeSize, blueRangeSize;
        redRangeSize = this.redRange.getRange();
        greenRangeSize = this.greenRange.getRange();
        blueRangeSize = this.blueRange.getRange();

        // checks if red range is bigger than green range
        if (redRangeSize >= greenRangeSize){

            if (redRangeSize >= blueRangeSize){

                // if red range is bigger than green and blue ranges, return RGB.RED
                return RGB.RED;
            }

            // if red range is bigger than green range, but smaller than blue range, blue range is necessarily bigger
            // than green range, so we return RGB.BLUE
            return RGB.BLUE;

        } else if (greenRangeSize >= blueRangeSize){
            // if green  range is bigger than red and blue ranges we return RGB.GREEN
            return RGB.GREEN;
        }
        //if green range is bigger than red but smaller than blue, we return RGB.BLUE
        return RGB.BLUE;

    }

    // getters
    public ClosedRange getRedRange() {
        return redRange;
    }

    public ClosedRange getGreenRange() {
        return greenRange;
    }

    public ClosedRange getBlueRange() {
        return blueRange;
    }

    public RGB getWidestChannel() {
        return widestChannel;
    }



    public class Builder {
        private ClosedRange redRange;
        private ClosedRange greenRange;
        private ClosedRange blueRange;

        public ColorChannelRanges build(){
            if(!(redRange == null) & !(greenRange == null) & !(blueRange == null)){
                return new ColorChannelRanges(redRange, greenRange, blueRange);
            }
            return null;
        }

        public Builder setRedRange(ClosedRange redRange) {
            this.redRange = redRange;
            return this;
        }

        public Builder setGreenRange(ClosedRange greenRange) {
            this.greenRange = greenRange;
            return this;
        }

        public Builder setBlueRange(ClosedRange blueRange) {
            this.blueRange = blueRange;
            return this;
        }
    }
}
