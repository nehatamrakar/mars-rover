package practise;

import com.tw.bootcamp.marsRover.exception.RoverOutsidePlateauException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Test
    void moveRoverTest() throws RoverOutsidePlateauException {
        Rover rover = new Rover(10, 10, 0, 0, Direction.N);
        rover.action(Instruction.M);
        Rover expectedRover = new Rover(10, 10, 0, 1, Direction.N);
        assertEquals(rover.xPosition(), expectedRover.xPosition());
        assertEquals(rover.yPosition(), expectedRover.yPosition());
        assertEquals(rover.facing(), expectedRover.facing());
    }

    @Test
    void roverOutsidePlateauTest() {
        assertThrows(RoverOutsidePlateauException.class, () -> new Rover(2, 2, 3, 3, Direction.N));
    }

    @Test
    void rotateRoverToLeft() throws RoverOutsidePlateauException {
        Rover rover = new Rover(10, 10, 0, 0, Direction.N);
        rover.action(Instruction.L);
        Rover expectedRover = new Rover(10, 10, 0, 0, Direction.W);
        assertEquals(rover.facing(), expectedRover.facing());
    }

    @Test
    void rotateRoverToRight() throws RoverOutsidePlateauException {
        Rover rover = new Rover(10, 10, 0, 0, Direction.N);
        rover.action(Instruction.R);
        Rover expectedRover = new Rover(10, 10, 0, 0, Direction.E);
        assertEquals(rover.facing(), expectedRover.facing());
    }

    @Test
    void moveRoverWithMultipleInputs() throws RoverOutsidePlateauException {
        Rover rover = new Rover(5, 5, 1, 2, Direction.N);

        List<Instruction> instructionList = List.of(Instruction.L, Instruction.M, Instruction.L, Instruction.M,
                Instruction.L, Instruction.M, Instruction.L, Instruction.M, Instruction.M);

        rover.action(instructionList);
        Rover expectedRover = new Rover(5, 5, 1, 3, Direction.N);
        assertEquals(rover.xPosition(), expectedRover.xPosition());
        assertEquals(rover.yPosition(), expectedRover.yPosition());
        assertEquals(rover.facing(), expectedRover.facing());
    }

    @Test
    void expectExtraInstructionsToMoveRoverOutsidePlateauDoNothing() throws RoverOutsidePlateauException {
        Rover rover = new Rover(2, 2, 0, 0, Direction.N);
        List<Instruction> instructionList = List.of(Instruction.M, Instruction.M);
        rover.action(instructionList);
        Rover expectedRover = new Rover(2, 2, 0, 1, Direction.N);
        assertEquals(rover.xPosition(), expectedRover.xPosition());
        assertEquals(rover.yPosition(), expectedRover.yPosition());
        assertEquals(rover.facing(), expectedRover.facing());
    }

    @Test
    void expectPlateauToGetExtraRoversInsideIt() {
        Plateau plateau = new Plateau(2, 2);
        List<Rover> rovers = List.of(new Rover(0, 0, Direction.N, plateau),
                new Rover(1, 0, Direction.N, plateau));
        assertDoesNotThrow(()-> plateau.addRovers(rovers));
    }

    @Test
    void expectMultipleRoversOnPlateauAreFunctioningCorrectly() {
        Plateau plateau = new Plateau(2, 2);
        List<Rover> rovers = List.of(new Rover(0, 0, Direction.N, plateau),
                new Rover(1, 0, Direction.N, plateau));
        List<List<Instruction>> instructionsList = List.of(List.of(Instruction.M, Instruction.M, Instruction.M, Instruction.R),
                List.of(Instruction.M, Instruction.R, Instruction.M, Instruction.M));
        plateau.addRovers(rovers);
        plateau.action(rovers, instructionsList);
        Rover expectedRover_1 = new Rover(0, 1, Direction.E, plateau);
        Rover expectedRover_2 = new Rover(1, 1, Direction.E, plateau);
        assertEquals(rovers.get(0).xPosition(), expectedRover_1.xPosition());
        assertEquals(rovers.get(0).yPosition(), expectedRover_1.yPosition());
        assertEquals(rovers.get(0).facing(), expectedRover_1.facing());
        assertEquals(rovers.get(1).xPosition(), expectedRover_2.xPosition());
        assertEquals(rovers.get(1).yPosition(), expectedRover_2.yPosition());
        assertEquals(rovers.get(1).facing(), expectedRover_2.facing());
    }

    @Test
    void expectRoverToTakeSpecialCharacterInputs() throws RoverOutsidePlateauException {
        Rover rover = new Rover(2, 2, 0, 0, Direction.N);
        rover.action("^");
        Rover expectedRover = new Rover(2, 2, 0, 1, Direction.N);
        assertEquals(rover.xPosition(), expectedRover.xPosition());
        assertEquals(rover.yPosition(), expectedRover.yPosition());
        assertEquals(rover.facing(), expectedRover.facing());
    }

    @Test
    void expectRoverToTakeMultipleSpecialCharacterInputs() throws RoverOutsidePlateauException {
        Rover rover = new Rover(2, 2, 0, 0, Direction.N);
        rover.action(">^^<^^^<^<^<<");
        Rover expectedRover = new Rover(2, 2, 0, 0, Direction.N);
        assertEquals(rover.xPosition(), expectedRover.xPosition());
        assertEquals(rover.yPosition(), expectedRover.yPosition());
        assertEquals(rover.facing(), expectedRover.facing());
    }
}
