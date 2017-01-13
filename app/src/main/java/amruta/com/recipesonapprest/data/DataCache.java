package amruta.com.recipesonapprest.data;

import java.util.ArrayList;
import java.util.List;

import amruta.com.recipesonapprest.R;
import amruta.com.recipesonapprest.model.RecipeDetails;
import amruta.com.recipesonapprest.model.RecipeList;

/**
 * Created by AMRUTA on 8/17/16.
 * This class is used to casche the recipe data. It serializes data into the files for better performance.
 *
 */



public class DataCache
{

    public static RecipeList InstantiateRecipeObjectsForTesting()
    {
        RecipeList recipeList   =   new RecipeList();

        RecipeDetails []recipeDetails   =   new RecipeDetails[3];

        RecipeDetails recipeDetails1 =   new RecipeDetails();
        recipeDetails1.setImage_url("http://static.food2fork.com/Buffalo2BChicken2BGrilled2BCheese2BSandwich2B5002B4983f2702fe4.jpg");
        recipeDetails1.setTitle("Buffalo Chicken Grilled Cheese Sandwich");
        recipeDetails1.setSocial_rank("100");

        RecipeDetails recipeDetails2 =   new RecipeDetails();
        recipeDetails2.setImage_url("http://static.food2fork.com/19321150c4.jpg");
        recipeDetails2.setTitle("Slow Cooker Chicken Tortilla Soup");
        recipeDetails2.setSocial_rank("100");

        RecipeDetails recipeDetails3 =   new RecipeDetails();
        recipeDetails3.setImage_url("http://static.food2fork.com/MacandCheese1122b.jpg");
        recipeDetails3.setTitle("Mac and Cheese with Roasted Chicken, Goat Cheese, and Rosemary");
        recipeDetails3.setSocial_rank("100");

        recipeDetails[0]    =   recipeDetails1;
        recipeDetails[1]    =   recipeDetails2;
        recipeDetails[2]    =   recipeDetails3;

        recipeList.setRecipes(recipeDetails);
        recipeList.setCount(3);


        return recipeList;

    }
}
