package practise;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
public class Rover {
    private int xCoordinateOfRover;
    private int yCoordinateOfRover;
    private char directionOfRover;

    public Rover(int xCoordinateOfRover, int yCoordinateOfRover,char directionOfRover) {
        this.xCoordinateOfRover = xCoordinateOfRover;
        this.yCoordinateOfRover = yCoordinateOfRover;
        this.directionOfRover = directionOfRover;
    }

    public String nextPosition(String instructions) {
            CharacterIterator it = new StringCharacterIterator(instructions);
            while (it.current() != CharacterIterator.DONE) {
                char nextDirection= it.current();
                it.next();
            }
            return instructions;
        }
}
