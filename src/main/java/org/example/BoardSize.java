package org.example;

public class BoardSize {
    private final int width;
    private final int height;

    public BoardSize(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Neither width: " + width + " nor height: " + height + " can be negative");
        }
        this.width = width;
        this.height = height;
    }

    public int getNumberOfTiles() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLastRowIndex() {
        return height - 1;
    }

    public int getLastColumnIndex() {
        return width - 1;
    }
}
