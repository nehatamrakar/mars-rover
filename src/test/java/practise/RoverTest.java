package practise;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RoverTest {

    @Test
    public void expect_Rovers_End_Position(){
        Plateau plateau_end_coordinates = new Plateau(5,5) ;
        Rover start_coordinates_for_first_rover = new Rover(1,2,'N');
        String instructions_for_first_rover = "LMLMLMLMM";

        Rover start_coordinates_for_second_rover = new Rover(3,3,'E');
        String instructions_for_second_rover = "MMRMMRMRRM";
        String expected_endpoints = "1 3 N 5 1 E";

        String end_coordinates_for_first_rover = start_coordinates_for_first_rover.nextPosition(instructions_for_first_rover,plateau_end_coordinates);
        String end_coordinates_for_second_rover = start_coordinates_for_second_rover.nextPosition(instructions_for_second_rover,plateau_end_coordinates);

        assertEquals(expected_endpoints, end_coordinates_for_first_rover + " " + end_coordinates_for_second_rover);
    }
}
