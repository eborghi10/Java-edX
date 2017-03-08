package edu.galileo;

/**
 * Created by emiliano on 02/03/17.
 */
public class Country {
    private String name;
    private String region;
    private String incomeLevel;
    private String iso2code;
    private Double lifeExpectancy;

    public Country(String name,String iso2code) {
        this.name = name;
        this.iso2code = iso2code;
    }

    public String getName() {
        return this.name;
    }

    public String getIso2Code() {
        return this.iso2code;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getReportRow() {
        return null;
    }
}
