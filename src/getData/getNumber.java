package getData;

import java.util.Scanner;

/**
 *
 * @author duy20
 */
public class getNumber {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static int getIntegerNumberInRangeOf(int min, int max, String errorMessage) {
        do {
            try {
                int result = Integer.parseInt(SCANNER.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println(errorMessage);
                System.out.print("Try again: ");
            }
        } while (true);
    }

    public static float getFloatNumber() {
        do {
            try {
                float result = Float.parseFloat(SCANNER.nextLine());
                if(result < 0 ) throw new NumberFormatException();
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Not valid float number!");
                System.out.print("Try again: ");
            }
        } while (true);
    }
}
