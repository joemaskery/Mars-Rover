package org.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoverTestNoObstacles {

    private Rover rover;

    @BeforeEach
    void startUp() {
        this.rover = new Rover();
    }

    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N",
            "RRRRR, 0:0:E"
    })
    void canTurnRight(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N",
            "LLLLL, 0:0:W"
    })
    void canTurnLeft(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "M, 0:1:N",
            "MMMMM, 0:5:N"
    })
    void canMoveNorth(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMMMMMM, 0:5:N"
    })
    void canWrapBoardNorth(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "RM, 1:0:E",
            "RMMMMM, 5:0:E"
    })
    void canMoveEast(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMMMMMM, 5:0:E"
    })
    void canWrapBoardEast(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "RRM, 0:9:S",
            "LLMMMMM, 0:5:S"
    })
    void canMoveSouth(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "RRMMMMMMMMMM, 0:0:S",
            "LLMMMMMMMMMMMMMMM, 0:5:S"
    })
    void canWrapBoardSouth(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "LM, 9:0:W",
            "LMMMMM, 5:0:W"
    })
    void canMoveWest(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "LMMMMMMMMMM, 0:0:W",
            "LMMMMMMMMMMMMMMM, 5:0:W"
    })
    void canWrapBoardWest(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

    @ParameterizedTest
    @CsvSource({
            "RMMLM, 2:1:N"
    })
    void overallTest(String input, String output) {
        Assertions.assertEquals(output, rover.execute(input));
    }

}