package checkers;

public class ResultChecker {
    public static boolean checkResult ( double x, double y, double r){
        if (    (x >= 0 && y >= 0 && x <= r && y <= r) ||                               // check for 1st coordinate axis
                (x <= 0 && y <= 0 && x <= r*(-1) && y <= r / 2 * (-1)) ||               // check for 3th coordinate axis
                (x >= 0 && y <= 0 && Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)) // check for 4th coordinate axis
        ) {
            return true;
        } else {
            return false;
        }
    }
}
