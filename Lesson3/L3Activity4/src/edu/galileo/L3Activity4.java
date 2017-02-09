package edu.galileo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L3Activity4 {

    /*
     * 1) Retrieve information of a file (recipes.txt)
     */

    public static void main(String[] args) throws Exception{

        /*
         * Part 1
         */

        Scanner input = null;
        String filenameTXT = "recipes.txt";
//        String filenameJSON = "recipes.json";

        try {
            input = new Scanner(new BufferedReader(
                    new FileReader(filenameTXT)));

            boolean newIngredient = true;
            boolean isStep = false;
            int cnt = 0;
            Recipe recipe = new Recipe();
            List<Recipe> recipeList = new ArrayList<>();

            while (input.hasNext()) {
                String character = input.nextLine();

                if (character.equals("ingredients:")) {
                    System.out.print("\t");
                } else if (character.equals("steps:")) {
                    isStep = true;
                    System.out.print("\t");
                } else if (isStep && !character.isEmpty()) {
                    System.out.print("\t\t" + (++cnt) + ". ");
                    recipe.setStep(character);
                } else if (character.isEmpty()) {
                    newIngredient = true;
                    isStep = false;
                    cnt = 0;
                } else if (newIngredient) {
                    recipe.setRecipeName(character);
                    newIngredient = false;
                } else {
                    System.out.print("\t\t");
                }

                System.out.println(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }


        /*
         * Part 2
         */

        try {
            FileOutputStream output = new FileOutputStream("favorite_recipe.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * Part 3
         */

    }
}

class Recipe {
    private String recipeName;
    private ArrayList<String> ingredients = new ArrayList<>();
    private ArrayList<String> steps = new ArrayList<>();

    public Recipe() {
    }

    public String toString(){
        return "";
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
}
