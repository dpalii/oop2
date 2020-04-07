package task2;

public class MeatSaladRecipe extends BaseRecipe {

    @Override
    public String mainActions() {
        return "boil meat for 30 min,\n";
    }

    @Override
    public String finalAction() {
        return "mix all ingredients, add salt and pepper.";
    }
}
