package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.*;

/**
 *
 * @author duy20
 */
public class ManageEastAsiaCountries {

    ArrayList<EastAsiaCountries> countries;

    public ManageEastAsiaCountries() {
        this.countries = new ArrayList<>();
    }

    public ManageEastAsiaCountries(ArrayList<EastAsiaCountries> countries) {
        this.countries = countries;
    }

    public void displayTableHeader() {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
    }

    public void displayMenu() {
        System.out.println("");
        System.out.println("                                     MENU                                     ");
        System.out.println("==============================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==============================================================================");
        System.out.print("Enter your choice: ");
    }

    public void addNewCountryToManage() throws Exception{
        System.out.print("Enter code of contry: ");
        String countryCode = getData.getString.getValidString();

        System.out.print("Enter name of contry: ");
        String countryName = getData.getString.getValidString();

        System.out.print("Enter total area: ");
        float totalArea = getData.getNumber.getFloatNumber();

        System.out.print("Enter terrain of contry: ");
        String countryTerrain = getData.getString.getValidString();

        EastAsiaCountries newCountry = new EastAsiaCountries(countryTerrain, countryCode, countryName, totalArea);
        
        addCountryInformation(newCountry);
    }

    public void addCountryInformation(EastAsiaCountries newCountry) throws Exception {
        //check code contry exist or not
        if (isCountryExisted(newCountry)) {
            throw new Exception("Country existed!");
        }
        
        this.countries.add(newCountry);
        
        System.out.println("Add country successful!");
    }
    
    public void displayCountries(ArrayList<EastAsiaCountries> countries) {
        displayTableHeader();
        countries.forEach((country) -> {
            country.display();
        });
    }

    //display infomation of country
    public void getRecentlyEnteredInformation() throws Exception {
        if (this.countries.isEmpty()) {
            throw new Exception("You have not entered any data!");
        }

        displayCountries(this.countries);
    }
    
    public void showCountriesSortedByOrder() throws Exception {
        ArrayList<EastAsiaCountries> sortedCountries = new ArrayList<>();
        
        sortedCountries = sortInformationByAscendingOrder();
        
        if (sortedCountries.isEmpty()) {
            throw new Exception("The list is empty!");
        }
        
        displayCountries(sortedCountries);
    }

    //display infomation sort name in ascending
    public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder() throws Exception {
        ArrayList<EastAsiaCountries> sortedCountries = new ArrayList<>(countries);

        Collections.sort(sortedCountries);

        return sortedCountries;
    }
    
    //allow user search infomation contry by name
    public void searchCountriesByName() throws Exception {
        System.out.print("Enter the name you want to search for: ");
        String countryName = getData.getString.getValidString();
        
        ArrayList<EastAsiaCountries> foundedCountries = searchInformationByName(countryName);
        
        displayCountries(foundedCountries);
    }

    public ArrayList<EastAsiaCountries> searchInformationByName(String name) throws Exception {
        // find country and push to an array
        ArrayList<EastAsiaCountries> foundedCountries = new ArrayList<>();
        this.countries.forEach(country -> {
            if (country.getCountryCode().equalsIgnoreCase(name)) {
                foundedCountries.add(country);
            }
        });

        // if no country founded, throw exception
        if (foundedCountries.isEmpty()) {
            throw new Exception("No country founded with the name " + name);
        }

        return foundedCountries;
    }

    //check country exist by code
    public boolean isCountryExisted(EastAsiaCountries newCountry) {
        for (EastAsiaCountries country : this.countries) {
            if (country.getCountryCode().equalsIgnoreCase(newCountry.getCountryCode())) {
                return true;
            }
        }
        return false;
    }

}
