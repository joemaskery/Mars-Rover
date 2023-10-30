package org.marsrover;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinates {

    private int x;
    private int y;

    public void updateTo(Coordinates newCoord) {
        this.x = newCoord.getX();
        this.y = newCoord.getY();
    }

}
