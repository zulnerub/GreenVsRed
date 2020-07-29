package main.entity;

// Entity to store the color value
public class PositionEntity {

    private int color;

    public PositionEntity(int type) {
        this.color = type;
    }

    public int getColor() {
        return color;
    }

    public PositionEntity setColor(int color) {
        this.color = color;
        return this;
    }
}
