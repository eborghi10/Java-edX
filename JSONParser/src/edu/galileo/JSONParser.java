package edu.galileo;

/*
    File -> Project Structure -> Libraries :

        javax.json-1.0.4
        javax.json-api-1.0
 */
import javax.json.*;
import java.io.FileReader;

public class JSONParser {

    /*
        Data is in name/value pairs.
        Data is separated by commas.
        Curly braces hold objects.
        Square brackets hold arrays.

        Values:
        - String
        - Number
        - JSON object
        - Array
        - Boolean
        - Null
     */

    public static void main(String[] args) throws Exception {

        // Creates the JSONReader object with the file location
        JsonReader reader = Json.createReader(
                new FileReader("Student.json"));

        // Creates the JSON tree structure
        JsonStructure jsonst = reader.read();
        JsonObject object = (JsonObject) jsonst;

        // To navigate in the tree we'll use a custom method that recursively
        // navigates in the complete structure
        navigateTree(jsonst, "Student");
    }

    public static void navigateTree(JsonValue tree, String key) {

        if (key != null)
            System.out.print("Key " + key + ": ");
        // Get the element "value, type" and, depending on the type, will execute the code
        // of the matching condition of the switch statement.
        switch (tree.getValueType()) {
            case OBJECT:
                System.out.println("OBJECT");
                JsonObject object = (JsonObject) tree;
                for (String name : object.keySet())
                    navigateTree(object.get(name), name);
                break;
            case ARRAY:
                System.out.println("ARRAY");
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
