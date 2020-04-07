package task2;

public class Main {

    public static void main(String[] args) {
        var kitchen = new Kitchen();
        var salad = kitchen.cookADish(new MeatSaladRecipe());
        System.out.println(salad);
        System.out.println("***");
        var soup = kitchen.cookADish(new SoupRecipe());
        System.out.println(soup);
        System.out.println("***");
        var stew = kitchen.cookADish(new StewRecipe());
        System.out.println(stew);
        System.out.println("***");
    }
}
