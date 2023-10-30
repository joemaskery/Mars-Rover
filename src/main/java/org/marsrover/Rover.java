package org.marsrover;

import lombok.Data;
import java.util.Optional;

@Data
public class Rover {

    private Direction direction;
    private Coordinates coords;
    private Grid grid;

    public Rover() {
        this.direction = new Direction("N");
        this.coords = new Coordinates(0, 0);
        this.grid = new Grid(10, 10);
    }

    public String execute(String command) {
        char[] cmds = command.toCharArray();

        for (char c: cmds) {
            if (c == 'L') {
                direction.turnLeft();
            } else if (c == 'R') {
                direction.turnRight();
            } else if (c == 'M') {
                Optional<Coordinates> obstaclesEncountered = grid.moveAndReturnAnyObstacles(this.direction, this.coords);

                if (obstaclesEncountered.isPresent()) {
                    return String.format("O:%s:%s:%s",
                            this.coords.getX(),
                            this.coords.getY(),
                            this.direction.getDirection());
                }

            } else {
                throw new IllegalArgumentException("Commands can only be R, L, or M");
            }
        }

        return String.format("%s:%s:%s",
                this.coords.getX(),
                this.coords.getY(),
                this.direction.getDirection());

    }
}