package org.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;

public class RoverTestObstacles {

    private Rover rover;

    @BeforeEach
    void setUp() {
        this.rover = new Rover();
        rover.getGrid().setObstacles(Arrays.asList(
                new Coordinates(2, 2),
                new Coordinates(6, 9))
        );
    }

    @ParameterizedTest
    @CsvSource({
            "RMMLMM, O:2:1:N",
            "RMMLMMMMMM, O:2:1:N",
            "RMMMMMMLMMMMMMMMM, O:6:8:N",
            "MMMMMMMMMRMMMMMM, O:5:9:E"
    })
    void canReportObstacles(String input, String obstacle) {
        Assertions.assertEquals(obstacle, rover.execute(input));
    }
}
