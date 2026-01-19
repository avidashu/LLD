
package Topping;
import Base.BasePizza;

public class ExtraCheeseTopping extends Toppings { 

    public ExtraCheeseTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    protected double getToppingCost() {
        return 15.0;
    }
    
}
