package practise;

import com.tw.bootcamp.marsRover.exception.RoverOutsidePlateauException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void moveHorizontallyTest() {
        Plateau plateau = new Plateau(10, 10);
        int actual_x_coordinate = Direction.moveHorizontally(0, 0, Direction.E, plateau);
        int expected_x_coordinate = 1;
        assertEquals(actual_x_coordinate, expected_x_coordinate);
    }

    @Test
    void moveHorizontallyErrorTest() {
        Plateau plateau = new Plateau(1, 1);
        assertThrows(RoverOutsidePlateauException.class, () -> Direction.moveHorizontally(1, 1, Direction.E, plateau));
    }

    @Test
    void moveVerticallyTest() {
        Plateau plateau = new Plateau(10, 10);
        int actual_y_coordinate = Direction.moveVertically(0, 0, Direction.N, plateau);
        int expected_y_coordinate = 1;
        assertEquals(actual_y_coordinate, expected_y_coordinate);
    }

    @Test
    void moveVerticallyErrorTest() {
        Plateau plateau = new Plateau(1, 1);
        assertThrows(RoverOutsidePlateauException.class, () -> Direction.moveVertically(1, 1, Direction.N, plateau));
    }
}