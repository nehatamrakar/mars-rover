package practise;

import practise.exception.RoverOutsidePlateauException;

public enum Direction {
    N(0, 1),
    W(-1, 0),
    S(0, -1),
    E(1, 0);

    private int xCoordinate;
    private int yCoordinate;

    Direction(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static int moveHorizontally(int xCoordinate, int yCoordinate, Direction direction, Plateau plateau) {
        if(movingWillSendRoverOutOfPlateau(xCoordinate, yCoordinate, direction, plateau)) return xCoordinate;
        return xCoordinate + direction.xCoordinate;
    }

    public static int moveVertically(int xCoordinate, int yCoordinate, Direction direction, Plateau plateau) {
        if(movingWillSendRoverOutOfPlateau(xCoordinate, yCoordinate, direction, plateau)) return yCoordinate;
        return yCoordinate + direction.yCoordinate;
    }

    private static boolean movingWillSendRoverOutOfPlateau(int xCoordinate, int yCoordinate, Direction direction, Plateau plateau) {
        return xCoordinate + direction.xCoordinate > plateau.topRightX || xCoordinate + direction.xCoordinate < plateau.bottomLeftX
                || yCoordinate + direction.yCoordinate > plateau.topRightY || yCoordinate + direction.yCoordinate < plateau.bottomLeftY;
    }
    public static Direction rotateLeft(Direction direction) {
        if(direction == Direction.N){
            return Direction.W;
        }
        if(direction == Direction.W){
            return Direction.S;
        }
        if(direction == Direction.S) {
            return Direction.E;
        }
        return Direction.N;
    }

    public static Direction rotateRight(Direction direction) {
        if(direction == Direction.N){
            return Direction.E;
        }
        if(direction == Direction.E){
            return Direction.S;
        }
        if(direction == Direction.S) {
            return Direction.W;
        }
        return Direction.N;
    }
}

