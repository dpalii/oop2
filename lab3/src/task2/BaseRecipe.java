package task2;

public abstract class BaseRecipe {
    public String prepareIngredients() {
        return "Chop potato, cabbage, carrot, onion and meat,\n";
    }
    public abstract String mainActions();
    public abstract String finalAction();
}
