import checkers.ResultChecker;
import com.lab2.servlets.AreaCheckServlet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AreaCheckServletTest {

    @Test
    public void testFirstCoordinateArea() {
        double[] xValues = {0, 0, 1, 1, 2, 2};
        double[] yValues = {0, 1, 0, 1, 2.5, 2.5};
        double[] rValues = {1, 1, 1, 1, 3.0, 2.0};

        boolean[] expected = {true, true, true, true, true, false};
        boolean[] found = new boolean[6];

        for (int i = 0; i < xValues.length; i++) {
            found[i] = ResultChecker.checkResult(xValues[i], yValues[i], rValues[i]);
        }
        assertArrayEquals(expected, found);
    }

    @Test
    public void testSecondCoordinateArea() {
        double[] xValues = {0, 0, 1, 1, 2, 2};
        double[] yValues = {0, 1, 0, 1, 2.5, 2.5};
        double[] rValues = {1, 1, 1, 1, 3.0, 2.0};

        boolean[] expected = {true, true, true, false, false, false};
        boolean[] found = new boolean[6];

        for (int i = 0; i < xValues.length; i++) {
            found[i] = ResultChecker.checkResult(xValues[i], yValues[i], rValues[i]);
        }
        assertArrayEquals(expected, found);
    }

    @Test
    public void testThirdCoordinateArea() {
        double[] xValues = {0, 0, -1, 1, 3};
        double[] yValues = {0, -1, 0, -0.25, 3};
        double[] rValues = {1, 2, 1, 3, 3.0, 1};
        boolean[] expected = {true, true, true, true, false};
        boolean[] found = new boolean[5];

        for (int i = 0; i < xValues.length; i++) {
            found[i] = ResultChecker.checkResult(xValues[i], yValues[i], rValues[i]);
        }
        assertArrayEquals(expected, found);
    }

    @Test
    public void testFourthCoordinateArea() {
        double[] xValues = {0, 1, 0, 1, 5};
        double[] yValues = {0, 0, -1, -1, 4.9};
        double[] rValues = {1, 1, 1, 3, 2, 2};

        boolean[] expected = {true, true, true, true, false};
        boolean[] found = new boolean[5];

        for (int i = 0; i < xValues.length; i++) {
            found[i] = new AreaCheckServlet().checkResult(xValues[i], yValues[i], rValues[i]);
        }
        assertArrayEquals(expected, found);
    }

}
