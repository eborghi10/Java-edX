package edu.galileo;

/**
 * Main class of the Java program.
 *
 */

/*

    In the following activity you should make a report about the life expectancy by country.
    This report must show the country’s name, region, income level and life expectancy.
    The information is located in different sources with different formats.
    Your task is to unify this data and display the report.
    If you cannot find one of the required data, write "-".

    Sources where you can obtain the information are:

        Country list (JSON): http://services.groupkt.com/country/get/all

        Region and income level (XML): http://api.worldbank.org/countries/?format=xml&per_page=304

        Life expectancy (XML):
        http://api.worldbank.org/countries/all/indicators/SP.DYN.LE00.IN/?format=xml&date=2014&per_page=264

    The steps you need to perform are the following:

        1. Complete the class InternetContent in order to obtain the content of a web page with a URL.
        2. Complete the class Country and the class Countries.
        3. Serialize the data of the different data sources. Use the following classes: CountriesJSONParser,
            CountriesSAXParser and CountriesDOMParser. From this classes invoke the methods of the class
            Countries to unify the data.
        4. Complete the class Countries with the requested data.
        5. Display the report of life expectancy.

    Note: To complete this activity, it is recommended to use an IDE because it is needed an external library
    to serialize the data. You can get the library from the following link: Javax.

    Example of the first lines of the report:

        Country, Region, Income Level, Life Expectancy
        Afghanistan, South Asia, Low income, 60.3744634146342
        Åland Islands, -, -, -
        Albania, Central Asia, Upper middle income, 77.8304634146342

 */
public class Main {

    public static void main(String[] args) throws Exception {

        final String url_countries = " http://services.groupkt.com/country/get/all";
        final String url_countries_info = "http://api.worldbank.org/countries/?format=xml&per_page=304";
        final String url_countries_life_expectancy = "http://api.worldbank.org/countries/all/indicators/SP.DYN.LE00.IN/?format=xml&date=2014&per_page=264";

        String countries_txt = InternetContent.get(url_countries);
        String countries_xml = InternetContent.get(url_countries_info);
        String life_expectancy_xml = InternetContent.get(url_countries_life_expectancy);
        Countries countries = new Countries();
        CountriesJSONParser.setCountries(countries,countries_txt);
        CountriesSAXParser.setWorldBankData(countries,countries_xml);
        CountriesDOMParser.setLifeExpectancy(countries,life_expectancy_xml);
    }
}
