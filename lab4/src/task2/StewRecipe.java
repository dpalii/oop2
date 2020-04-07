package task2;

public class StewRecipe extends BaseRecipe {
    @Override
    public String mainActions() {
        return "stew all ingredients until meat is ready,\n";
    }

    @Override
    public String finalAction() {
        return "add spices for meat, salt and pepper.";
    }
}
