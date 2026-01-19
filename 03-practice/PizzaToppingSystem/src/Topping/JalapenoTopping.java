
package Topping;
import Base.BasePizza;

public class JalapenoTopping extends Toppings {
    public JalapenoTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    protected double getToppingCost() {
        return 12.0;
    }

    
}