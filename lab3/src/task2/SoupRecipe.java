package task2;

public class SoupRecipe extends BaseRecipe {
    @Override
    public String mainActions() {
        return "boil meat for 30 min, fry onion with carrot,\n";
    }

    @Override
    public String finalAction() {
        return "add all ingredients to boiling meat, boil for another 20 minutes.";
    }
}
