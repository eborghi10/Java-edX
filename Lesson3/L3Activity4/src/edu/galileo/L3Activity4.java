package edu.galileo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class L3Activity4 {

    /*
     * 1) Retrieve information of a file (recipes.txt)
     */

    public static void main(String[] args) throws Exception{
        //firstExercise();
        secondExercise();
        thirdExercise();
    }

    /***************************************
     *              Part 1
     *
     ***************************************/

    public static ArrayList<Recipe> firstExercise() {

        Scanner input = null;

        // Reads the input file and create the Objects Recipe
        ArrayList<Recipe> recipeList = new ArrayList<>();

        try {
            String filenameTXT = "recipes.txt";
            // String filenameJSON = "recipes.json";

            input = new Scanner(new BufferedReader(new FileReader(filenameTXT)));

            boolean newRecipe = true;
            boolean isIngredient = false;
            boolean isStep = false;
            int cnt = 0;

            Recipe recipe = new Recipe();

            while (input.hasNext()) {
                String character = input.nextLine();

                if (newRecipe) {
                    if (recipeList.size() > 0) {
                        recipe = new Recipe();
                    }
                    recipe.setRecipeName(character);
                    newRecipe = false;
                } else if (character.equals("ingredients:")) {
                    isIngredient = true;
                } else if (character.equals("steps:")) {
                    isStep = true;
                    isIngredient = false;
                    cnt = 0;
                } else if (isStep && (!character.isEmpty())) {
                    recipe.setStep(++cnt + ". " + character);
                } else if (character.isEmpty()) {
                    // Finished the instructions of one recipe
                    isStep = false;
                    newRecipe = true;
                    recipeList.add(recipe);
                } else if (isIngredient) {
                    recipe.setIngredient(character);
                }
            }
            recipeList.add(recipe);

            // Prints all the objects Recipe that were created

            for (Recipe r : recipeList) System.out.println(r.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return recipeList;
    }

    /***************************************
     *              Part 2
     *
     ***************************************/

    public static void secondExercise() {

        try {

            ArrayList<Recipe> recipeList = new ArrayList<>(firstExercise());

            File file = new File("favorite_recipe.txt");
            FileOutputStream output = new FileOutputStream(file);
            file.createNewFile();

            output.write(recipeList.get(0).toAnotherString().getBytes());

        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    /***************************************
     *              Part 3
     *
     ***************************************/

    public static void thirdExercise() throws Exception {

        Scanner input = null;

        try {
            // Read the favorite_recipe.txt file
            input = new Scanner(new BufferedReader(new FileReader("favorite_recipe.txt")));

            // Print what the file "favorite_recipe.txt" has
            while (input.hasNext()) {
                String character = input.nextLine();
                System.out.println(character);
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}

class Recipe {
    private String recipeName;
    private ArrayList<String> ingredients;
    private ArrayList<String> steps;

    public Recipe() {
        this.recipeName = "";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public String toString(){
        String textToPrint =
                "\n\n" + this.getRecipeName() + "\n\tingredients:\n";
        for (String ingredient : this.ingredients) {
            textToPrint = textToPrint.concat("\t\t" + ingredient + "\n");
        }
        textToPrint = textToPrint.concat("\tsteps:\n");
        for (String step : this.steps) {
            textToPrint = textToPrint.concat("\t\t" + step + "\n");
        }

        return textToPrint;
    }

    public String toAnotherString() {
        return "\n" + this.getRecipeName() + "\n\tingredients: " + this.getAmountOfIngredients()
                + "\n\tsteps: " + this.getAmountOfSteps();
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public void setStep(String step) {
        this.steps.add(step);
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    private int getAmountOfIngredients() {
        return this.ingredients.size();
    }

    private int getAmountOfSteps() {
        return this.steps.size();
    }
}
