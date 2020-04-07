package task2;

public class Kitchen {
    public String cookADish(BaseRecipe recipe) {
        String dish = "";
        dish += recipe.prepareIngredients() +
                recipe.mainActions() +
                recipe.finalAction();
        return dish;
    }
}
