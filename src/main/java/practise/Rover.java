package practise;

import practise.exception.RoverOutsidePlateauException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rover {
    private int xCoordinate;
    private int yCoordinate;
    private Direction direction;

    private Plateau plateau;

    private static Map<Coordinate, Boolean> allRoverCoordinates = new HashMap<>();

    public Rover(int topX, int topY, int xCoordinate, int yCoordinate, Direction direction) throws RoverOutsidePlateauException {
        if (xCoordinate < 0 || xCoordinate > topX || yCoordinate < 0 || yCoordinate > topY) {
            RoverOutsidePlateauException ex = new RoverOutsidePlateauException("Rover outside plateau");
            throw ex;
        }
        this.plateau = new Plateau(topX, topY);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }

    public Rover(int xCoordinate, int yCoordinate, Direction direction, Plateau plateau) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
        this.plateau = plateau;
        allRoverCoordinates.put(new Coordinate(xCoordinate, yCoordinate), Boolean.TRUE);
    }

    public void action(Instruction instruction) {
        int potentialXCoordinate = instruction.moveXCoordinate(xCoordinate, yCoordinate, facing(), plateau, instruction);
        int potentialYCoordinate = instruction.moveYCoordinate(xCoordinate, yCoordinate, facing(), plateau, instruction);
        if(allRoverCoordinates.containsKey(new Coordinate(potentialXCoordinate, potentialYCoordinate))) return;
        allRoverCoordinates.remove(new Coordinate(xCoordinate, yCoordinate));
        xCoordinate = potentialXCoordinate;
        yCoordinate = potentialYCoordinate;
        direction = instruction.turn(facing(), instruction);
        allRoverCoordinates.put(new Coordinate(xCoordinate, yCoordinate), Boolean.TRUE);
    }

    public void action(List<Instruction> instructionList) {
        for(Instruction instruction : instructionList) {
            xCoordinate = instruction.moveXCoordinate(xCoordinate, yCoordinate, facing(), plateau, instruction);
            yCoordinate = instruction.moveYCoordinate(yCoordinate, yCoordinate, facing(), plateau, instruction);
            direction = instruction.turn(facing(), instruction);
        }
    }

    public void action(String input) {
        for(int charIndex = 0; charIndex < input.length(); charIndex++) {
            if(input.charAt(charIndex) == '^') action(Instruction.M);
            if(input.charAt(charIndex) == '<') action(Instruction.L);
            if(input.charAt(charIndex) == '>') action(Instruction.R);
        }
    }

    public int xPosition() {
        return this.xCoordinate;
    }

    public int yPosition() {
        return this.yCoordinate;
    }

    public Direction facing() {
        return this.direction;
    }
}

