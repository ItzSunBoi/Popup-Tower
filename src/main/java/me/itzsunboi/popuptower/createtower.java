package me.itzsunboi.popuptower;

import java.util.ArrayList;
import java.util.List;

public class createtower {
    public static List<Layer> createLayers() {
        List<Layer> allLayers = new ArrayList<>();


        List<Point> layer1 = List.of(new Point(1,1), new Point(0,2), new Point(-1,2), new Point(-2,1),
                new Point(-2,0), new Point(-2,-1), new Point(-1,-2), new Point(0,-2), new Point(1,-1),
                new Point(-1,0));
        allLayers.add(new Layer(layer1));

        List<Point> layer2 = List.of(new Point(1,1), new Point(0,2), new Point(-1,2), new Point(-2,1),
                new Point(-2,0), new Point(-2,-1), new Point(-1,-2), new Point(0,-2), new Point(1,-1),
                new Point(-1,0));
        allLayers.add(new Layer(layer2));

        List<Point> layer3 = List.of(new Point(1,1), new Point(0,2), new Point(-1,2), new Point(-2,1),
                new Point(-2,0), new Point(-2,-1), new Point(-1,-2), new Point(0,-2), new Point(1,-1),
                new Point(1,0), new Point(-1,0));
        allLayers.add(new Layer(layer3));

        List<Point> layer4 = List.of(new Point(1,1), new Point(0,2), new Point(-1,2), new Point(-2,1),
                new Point(-2,0), new Point(-2,-1), new Point(-1,-2), new Point(0,-2), new Point(1,-1),
                new Point(1,0), new Point(-1,0));
        allLayers.add(new Layer(layer4));

        List<Point> layer5 = List.of(new Point(0,0), new Point(0,1), new Point(-1,1), new Point(-2,1),
                new Point(-2,0), new Point(-2,-1), new Point(-1,-1), new Point(0,-1), new Point(1,-1),
                new Point(1,0), new Point(1,1), new Point(1,2), new Point(0,2), new Point(-1,2),
                new Point(-2,2), new Point(-2,-2), new Point(-1,-2), new Point(0,-2), new Point(1,-2),
                new Point(2,-2), new Point(2,0), new Point(2,2), new Point(1,3), new Point(-2,3),
                new Point(-3,2), new Point(-3,0), new Point(-3,-2), new Point(-2,-3), new Point(1,-3),
                new Point(-1,0));
        allLayers.add(new Layer(layer5));

        List<Point> layer6 = List.of(new Point(2,0), new Point(2,1), new Point(2,2), new Point(1,3),
                new Point(0,3), new Point(-1,3), new Point(-2,3), new Point(-3,2), new Point(-3,1),
                new Point(-3,0), new Point(-3,-1), new Point(-3,-2), new Point(-2,-3), new Point(-1,-3),
                new Point(0,-3), new Point(1,-3), new Point(2,-2), new Point(2,-1));
        allLayers.add(new Layer(layer6));

        List<Point> layer7 = List.of(new Point(2,0), new Point(2,2), new Point(1,3), new Point(-2,3),
                new Point(-3,2), new Point(-3,0), new Point(-3,-2), new Point(-2,-3), new Point(1,-3),
                new Point(2,-2));
        allLayers.add(new Layer(layer7));

        return allLayers;

    }
}
