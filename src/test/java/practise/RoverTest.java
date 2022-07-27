package practise;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RoverTest {

    @Test
    public void RoversEndPosition_SameAs_StartPosition(){
        Plateau plateau_end_coordinates = new Plateau(5,5) ;
        Rover start_coordinates_for_first_rover = new Rover(1,2,'N');
        String instructions_for_first_rover = "";
        Rover start_coordinates_for_second_rover = new Rover(3,3,'E');
        String instructions_for_second_rover = "";
        String expected_endpoints = "1 2 N 3 3 E";
        String end_coordinates_for_first_rover = start_coordinates_for_first_rover.action(instructions_for_first_rover,plateau_end_coordinates);
        String end_coordinates_for_second_rover = start_coordinates_for_second_rover.action(instructions_for_second_rover,plateau_end_coordinates);

        String endCoordinatesAndDirection_OfBothRovers = end_coordinates_for_first_rover + " " + end_coordinates_for_second_rover;

        assertEquals(expected_endpoints, endCoordinatesAndDirection_OfBothRovers);
    }

//    @Test
//    public void RoversTurnLeft(){
//
//    }
//
//    @Test
//    public void RoversTurnRight(){
//
//    }
//
//    @Test
//    public void RoversMove_InTheSameDirection(){
//
//    }

    @Test
    public void RoversMoveToEndPosition(){
        Plateau plateau_end_coordinates = new Plateau(5,5) ;
        Rover start_coordinates_for_first_rover = new Rover(1,2,Direction.N);
        String instructions_for_first_rover = "LMLMLMLMM";

        Rover start_coordinates_for_second_rover = new Rover(3,3,Direction.E);
        String instructions_for_second_rover = "MMRMMRMRRM";
        String expected_endpoints = "1 3 N 5 1 E";

        String end_coordinates_for_first_rover = start_coordinates_for_first_rover.action(instructions_for_first_rover,plateau_end_coordinates);
        String end_coordinates_for_second_rover = start_coordinates_for_second_rover.action(instructions_for_second_rover,plateau_end_coordinates);

        String endCoordinatesAndDirection_OfBothRovers = end_coordinates_for_first_rover + " " + end_coordinates_for_second_rover;

        assertEquals(expected_endpoints, endCoordinatesAndDirection_OfBothRovers);
    }
}
