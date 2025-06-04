package view;

import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author duy20
 */
public class Main {

    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();

        while (true) {
            manager.displayMenu();
            int userChoice = getData.getNumber.getIntegerNumberInRangeOf(1, 5, "Invalid option!");
            try {
                switch (userChoice) {
                    case 1:
                        manager.addNewCountryToManage();
                        break;
                    case 2:
                        manager.getRecentlyEnteredInformation();
                        break;
                    case 3:
                        manager.searchCountriesByName();
                        break;
                    case 4:
                        manager.showCountriesSortedByOrder();
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
