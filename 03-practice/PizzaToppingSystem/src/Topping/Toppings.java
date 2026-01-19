package Topping;
import Base.BasePizza;
public abstract class Toppings extends BasePizza {
    protected BasePizza basePizza;

    public Toppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    protected abstract double getToppingCost();

    @Override
    public double cost() {
        return basePizza.cost() + getToppingCost();
    }
    
}
