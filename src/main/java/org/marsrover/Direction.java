package org.marsrover;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Direction {

    private String direction;
    private Map<String, String[]> compass;

    public Direction(String direction) {
        this.direction = direction;

        this.compass = new HashMap<>();
        this.compass.put("N", new String[] {"W", "E"});
        this.compass.put("E", new String[] {"N", "S"});
        this.compass.put("S", new String[] {"E", "W"});
        this.compass.put("W", new String[] {"S", "N"});

    }

    public void turnLeft() {
        this.direction = compass.get(this.direction)[0];
    }

    public void turnRight() {
        this.direction = compass.get(this.direction)[1];
    }

}
