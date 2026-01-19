package Client;
import Base.BasePizza;
import Base.Farmhouse;
import Base.Margherita;
import Base.MushroomPizza;
import Topping.ExtraCheeseTopping;
import Topping.JalapenoTopping;
import Topping.Toppings;

public class PizzaStore {

    public static void main(String[] args) {
        BasePizza margherita = new Margherita();
        System.out.println("Margherita Pizza Cost: " + margherita.cost());

        BasePizza farmhouse = new Farmhouse();
        System.out.println("Farmhouse Pizza Cost: " + farmhouse.cost());

        BasePizza mushroomPizza = new MushroomPizza();
        System.out.println("Mushroom Pizza Cost: " + mushroomPizza.cost());


        Toppings ExtraCheeseJalapenoMargherita =
            new ExtraCheeseTopping(new JalapenoTopping(new Margherita()));
        System.out.println("Margherita with Extra Cheese and Jalapeno Toppings Cost: " +
            ExtraCheeseJalapenoMargherita.cost());
    }

}