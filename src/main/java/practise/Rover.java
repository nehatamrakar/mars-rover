package practise;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
public class Rover {
    private final int xCoordinateOfRover;
    private final int yCoordinateOfRover;
    private final char directionOfRover;

    public Rover(int xCoordinateOfRover, int yCoordinateOfRover,char directionOfRover) {
        this.xCoordinateOfRover = xCoordinateOfRover;
        this.yCoordinateOfRover = yCoordinateOfRover;
        this.directionOfRover = directionOfRover;
    }

    public String nextPosition(String instructions, Plateau plateau) {
            CharacterIterator it = new StringCharacterIterator(instructions);

            int currentXCoordinate = xCoordinateOfRover;
            int currentYCoordinate = yCoordinateOfRover;
            char currentDirection = directionOfRover;

            while (it.current() != CharacterIterator.DONE) {
                char nextDirection = it.current();

                if(currentDirection=='N'){
                    if(nextDirection=='M' && currentXCoordinate<plateau.topEndOfPlateau){
                        currentYCoordinate++;
                    }
                    if(nextDirection=='L'){
                        currentDirection='W';
                    }
                    if(nextDirection=='R'){
                        currentDirection='E';
                    }
                }
                else if(currentDirection=='S'){
                    if(nextDirection=='M' && currentYCoordinate>0){
                        currentYCoordinate--;
                    }
                    if(nextDirection=='L'){
                        currentDirection='E';
                    }
                    if(nextDirection=='R'){
                        currentDirection='W';
                    }
                }
                else if(currentDirection=='E'){
                    if(nextDirection=='M' && currentXCoordinate< plateau.bottomEndOfPlateau){
                        currentXCoordinate++;
                    }
                    if(nextDirection=='L'){
                        currentDirection='N';
                    }
                    if(nextDirection=='R'){
                        currentDirection='S';
                    }
                }
                else if(currentDirection=='W'){
                    if(nextDirection=='M' && currentXCoordinate>0){
                        currentXCoordinate--;
                    }
                    if(nextDirection=='L'){
                        currentDirection='S';
                    }
                    if(nextDirection=='R'){
                        currentDirection='N';
                    }
                }
                it.next();
            }
            String end_coordinate = currentXCoordinate+" "+currentYCoordinate+" "+currentDirection;
            return end_coordinate;
        }
}
