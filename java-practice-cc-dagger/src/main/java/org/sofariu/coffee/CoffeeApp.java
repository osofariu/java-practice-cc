package org.sofariu.coffee;

import dagger.Component;

import java.util.function.Supplier;

public class CoffeeApp {

    @Component(modules = {CoffeeModule.class})
    interface Coffee {
        CoffeeMaker maker();
    }

    Supplier<Coffee> coffeeSupplier = DaggerCoffeeApp_Coffee.builder()::build;

    void brewCoffee() {
        Coffee coffee = coffeeSupplier.get();
        coffee.maker().makeCoffee();
    }

    public static void main(String[] args) {
        CoffeeApp coffeeApp = new CoffeeApp();
       coffeeApp.brewCoffee();
    }
}
