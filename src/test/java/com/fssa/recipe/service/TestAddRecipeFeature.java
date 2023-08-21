package com.fssa.recipe.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Recipe;

import com.fssa.recipe.service.exception.ServiceException;

 class TestAddRecipeFeature {
    @Test
     void testAddRecipeSuccess() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(900, "chicken", "Delicious pasta dish with bacon and cream sauce.",
                "Pasta, Bacon, Eggs, Parmesan cheese, Cream, Garlic, Black pepper, Salt",
                "1. Cook pasta according to package instructions.\n2. In a pan, fry bacon until crispy.\n3. In a bowl, whisk eggs, grated parmesan, cream, minced garlic, black pepper, and a pinch of salt.\n4. Drain cooked pasta and add it to the pan with bacon, then turn off the heat.\n5. Pour the egg mixture over the pasta and toss until coated in the sauce.\n6. Serve immediately with extra parmesan on top.",
                "https://www.example.com/images/pasta-carbonara.jpg");
        
        try {
        	assertTrue(recipeService.addRecipe(recipe));
        } catch (ServiceException e) {
            e.printStackTrace();
         fail();
        }
    }

@Test
     void testAddRecipeMissingName() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(99, null, "Description", "Ingredients", "Instructions", "ImageUrl");
        
        try {
           recipeService.addRecipe(recipe);
           fail();
        } catch (ServiceException e) {
            e.printStackTrace();
          
        }
    }

    
     void testAddRecipeMissingDescription() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(990, "RecipeName", null, "Ingredients", "Instructions", "ImageUrl");
        
        try {
            assertFalse(recipeService.addRecipe(recipe));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
     }
    void testAddRecipeInvalidIngredients() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(991, "RecipeName", "Description", null, "Instructions", "ImageUrl");
        
        try {
            assertFalse(recipeService.addRecipe(recipe));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }



}

	