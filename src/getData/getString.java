package getData;

import java.util.Scanner;

/**
 *
 * @author duy20
 */
public class getString {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static String getValidString() {
        do {            
            String result = SCANNER.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input can not be empty!");
                System.out.print("Try again: ");
            } else {
                return result;
            }
        } while (true);
    }
}
