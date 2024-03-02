package me.itzsunboi.popuptower;

// Layer.java
import java.util.List;

public class Layer {
    private int index;

    private List<Point> points;

    public Layer(List<Point> points) {
        this.points = points;
    }
    public int getIndex() {
        return index;
    }
    public List<Point> getPoints() {
        return points;
    }


}
