package edu.galileo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class L3Activity2 {

    /*
     * Find duplicate values of an array and remove them.
     * Then, print the new array without the duplicated values.
     */

    public static void main(String[] args) {

        ArrayList<String> computerBrands = new ArrayList<>();

        computerBrands.add("Apple");
        computerBrands.add("Acer");
        computerBrands.add("Samsung");
        computerBrands.add("Asus");
        computerBrands.add("Sony");
        computerBrands.add("Dell");
        computerBrands.add("Hewlett-Packard");
        computerBrands.add("Asus");
        computerBrands.add("Apple");
        computerBrands.add("Acer");
        computerBrands.add("Toshiba");
        computerBrands.add("Sony");
        computerBrands.add("Samsung");

        // Find duplicates in the list
        Map<String,Integer> computerBrandsNew = new HashMap<>();
        for (String tmp : computerBrands) {
            Integer cnt = computerBrandsNew.get(tmp);
            if (cnt == null) {
                computerBrandsNew.put(tmp, 1);
            } else {
                computerBrandsNew.put(tmp, ++cnt);
            }
        }

        // Prints ONLY the strings on the HashMap
        Iterator it = computerBrandsNew.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey());
            it.remove();
        }
    }
}
