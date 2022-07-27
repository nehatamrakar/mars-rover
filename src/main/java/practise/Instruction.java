package practise;

import practise.exception.RoverOutsidePlateauException;

public enum Instruction {
    M,
    L,
    R;

    public int moveXCoordinate(int xCoordinate, int yCoordinate, Direction direction, Plateau plateau, Instruction instruction) {
        if(instruction == Instruction.M) return Direction.moveHorizontally(xCoordinate, yCoordinate, direction, plateau);
        return xCoordinate;
    }

    public int moveYCoordinate(int xCoordinate, int yCoordinate, Direction direction, Plateau plateau, Instruction instruction) {
        if(instruction == Instruction.M)return Direction.moveVertically(xCoordinate, yCoordinate, direction, plateau);
        return yCoordinate;
    }

    public Direction turn(Direction direction, Instruction instruction) {
        if(instruction == Instruction.L) return Direction.rotateLeft(direction);
        if(instruction == Instruction.R) return Direction.rotateRight(direction);
        return direction;
    }
}
