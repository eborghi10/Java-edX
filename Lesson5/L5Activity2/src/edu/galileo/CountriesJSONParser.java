package edu.galileo;

/**
 * Created by emiliano on 02/03/17.
 *
 * Added "javax.json-api-1.0" to the project root.
 *
 */
import javax.json.*;
import java.io.StringReader;

public class CountriesJSONParser {
    public static void setCountries(Countries countries, String json) {

        JsonReader jsonReader = Json.createReader(new StringReader(json));

        JsonStructure jsonst = jsonReader.read();
        JsonObject object = (JsonObject) jsonst;

        navigateTree(jsonst, "Country");
    }

    private static void navigateTree(JsonValue tree, String key) {

        if (key != null)
            System.out.println("Key " + key + ": ");

        switch (tree.getValueType()) {

            case OBJECT:
                JsonObject object = (JsonObject) tree;
                for (String name : object.keySet())
                    navigateTree(object.get(name), name);
                break;
            case ARRAY:
                JsonArray array = (JsonArray) tree;
                for (JsonValue val : array)
                    navigateTree(val, null);
                break;
            case STRING:
                JsonString st = (JsonString) tree;
                System.out.println("STRING " + st.getString());
                break;
            case NUMBER:
                JsonNumber num = (JsonNumber) tree;
                System.out.println("NUMBER " + num);
                break;
            case TRUE:
            case FALSE:
            case NULL:
                System.out.println(tree.getValueType().toString());
                break;
        }
    }
}
