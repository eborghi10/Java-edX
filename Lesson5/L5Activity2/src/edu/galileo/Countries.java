package edu.galileo;

/**
 * Created by emiliano on 02/03/17.
 */
import java.util.ArrayList;
import java.util.List;

public class Countries {
    private List<Country> countries;

    public Countries() {
        this.countries = new ArrayList<>();
    }

    public void addCountry(String name, String iso2code) {
        this.countries.add(
                new Country(name, iso2code));
    }

    public int getCountryByIso2Code(String iso2code) {
        return -1;
    }

    public void setRegion(String iso2code, String region) {

    }

    public void setIncomeLevel(String iso2code, String incomeLevel) {

    }

    public void setLifeExpectancy(String iso2code, String lifeExpectancy) {

    }

    public String report() {
        return null;
    }
}

