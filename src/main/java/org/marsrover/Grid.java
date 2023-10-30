package org.marsrover;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Grid {

    private int xLength;
    private int yLength;
    private List<Coordinates> obstacles = new ArrayList<>();

    public Grid(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
    }

    public Optional<Coordinates> moveAndReturnAnyObstacles(Direction direction, Coordinates coords) {
        Coordinates newCoord = new Coordinates(coords.getX(), coords.getY());

        if (direction.getDirection().equals("N")) {
            int newY = (coords.getY() + 1) % 10;
            newCoord.setY(newY);
        } else if (direction.getDirection().equals("S")) {
            int newY = (coords.getY() == 0) ? this.yLength - 1: (coords.getY() - 1) % 10;
            newCoord.setY(newY);
        } else if (direction.getDirection().equals("E")) {
            int newX = (coords.getX() + 1) % 10;
            newCoord.setX(newX);
        } else if (direction.getDirection().equals("W")) {
            int newX = (coords.getX() == 0) ? this.xLength - 1: (coords.getX() - 1) % 10;
            newCoord.setX(newX);
        }

        if (!this.doesCoordHaveObstacle(newCoord)) {
            coords.updateTo(newCoord);
            return Optional.empty();
        } else {
            return Optional.of(newCoord);
        }

    }

    public Boolean doesCoordHaveObstacle(Coordinates coords) {
        return this.obstacles.contains(coords);
    }

    public void setObstacles(List<Coordinates> obstacles) {
        this.obstacles = obstacles;
    }

}
