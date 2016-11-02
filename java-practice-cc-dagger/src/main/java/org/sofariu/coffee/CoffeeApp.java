package org.sofariu.coffee;

import dagger.Component;
import org.sofariu.coffee.DaggerCoffeeApp_Coffee.Builder;

import java.util.function.Function;
import java.util.function.Supplier;

public class CoffeeApp {

    @Component(modules={CoffeeModule.class})
    public interface Coffee {
        CoffeeMaker maker();
    }

    Supplier<Coffee> coffeeSupplier = DaggerCoffeeApp_Coffee.builder()::build;

    void brewCoffee() {
        Coffee coffee = coffeeSupplier.get();
        coffee.maker().makeCoffee();
    }
}
